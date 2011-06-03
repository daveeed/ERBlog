package er.blog.rest.controllers;

import java.io.IOException;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WORequest;
import com.webobjects.appserver.WOResponse;
import com.webobjects.foundation.NSDictionary;

import sun.misc.BASE64Decoder;

import er.blog.eof.User;
import er.blog.eof.User.UserLoginException;
import er.extensions.eof.ERXGenericRecord;
import er.rest.format.ERXRestFormat;
import er.rest.routes.ERXDefaultRouteController;
import er.rest.routes.ERXRouteResults;
import er.rest.routes.ERXRouteUrlUtils;

public class BaseController extends ERXDefaultRouteController {

  private User authenticatedUser;

  public BaseController(WORequest request) {
    super(request);
  }

  @Override
  public WOActionResults newAction() throws Throwable {
    return errorResponse(405);
  }

  @Override
  public WOActionResults updateAction() throws Throwable {
    return errorResponse(405);
  }

  @Override
  public WOActionResults destroyAction() throws Throwable {
    return errorResponse(405);
  }

  @Override
  public WOActionResults showAction() throws Throwable {
    return errorResponse(405);
  }

  @Override
  public WOActionResults createAction() throws Throwable {
    return errorResponse(405);
  }

  @Override
  public WOActionResults indexAction() throws Throwable {
    return errorResponse(405);
  }
  
  protected void generateLocationHeader(ERXRouteResults response, ERXGenericRecord entity, String methodName) {
    String host = this.request()._serverName();
    if (this.request().isSecure())  {
      host = "https://" + host; 
    } else {
      host = "http://" + host; 
    }
    if (this.request()._serverPort() != null) {
      host = host + ":" + this.request()._serverPort();
    }
    NSDictionary<String,Object> queryDict = new NSDictionary<String,Object>();
    response.setHeaderForKey(host + ERXRouteUrlUtils.actionUrlForRecord(_context, entity, methodName, this.format().name(), queryDict, this.request().isSecure(), this.request().isSessionIDInRequest()), "Location");
  }
  
  protected void initAuthentication() throws UserLoginException, NotAuthorizedException {
    String authValue = request().headerForKey( "authorization" );
    if( authValue != null ) {
      try {
        byte[] authBytes = new BASE64Decoder().decodeBuffer( authValue.replace( "Basic ", "" ) );
        String[] parts = new String( authBytes ).split( ":", 2 );
        String username = parts[0];
        String password = parts[1];
        setAuthenticatedUser(User.validateLogin(editingContext(), username, password));
      } catch ( IOException e ) {
        log.error( "Could not decode basic auth data: " + e.getMessage() );
        e.printStackTrace();
      }
    } else {
      throw new NotAuthorizedException();
    }
  }
  
  public class NotAuthorizedException extends Exception {
    public NotAuthorizedException() {
      super();
    }
  }
  
  @Override
  protected boolean isAutomaticHtmlRoutingEnabled() {
    return true;
  }
  
  @Override
  protected ERXRestFormat defaultFormat() {
    return ERXRestFormat.json();
  }
  
  @Override
  public WOActionResults performActionNamed(String actionName, boolean throwExceptions)  {
    if (!(ERXRestFormat.html().name().equals(this.format().name()))) {
      try {
        initAuthentication();
      } catch (UserLoginException ex) {
        WOResponse response = (WOResponse)errorResponse("Unauthorized", 401);
        response.setHeader("Basic realm=\"ERBlog\"", "WWW-Authenticate");
        return response;
      } catch (NotAuthorizedException ex) {
        WOResponse response = (WOResponse)errorResponse("Unauthorized", 401);
        response.setHeader("Basic realm=\"ERBlog\"", "WWW-Authenticate");
        return response;
      }
    }
    return super.performActionNamed(actionName, throwExceptions);
  }
  
  protected User authenticatedUser() {
    return authenticatedUser;
  }

  protected void setAuthenticatedUser(User authenticatedUser) {
    this.authenticatedUser = authenticatedUser;
  }

}
