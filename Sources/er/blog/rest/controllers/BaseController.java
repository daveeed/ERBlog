package er.blog.rest.controllers;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WORequest;
import com.webobjects.foundation.NSDictionary;

import er.extensions.eof.ERXGenericRecord;
import er.rest.format.ERXRestFormat;
import er.rest.routes.ERXDefaultRouteController;
import er.rest.routes.ERXRouteResults;
import er.rest.routes.ERXRouteUrlUtils;

public class BaseController extends ERXDefaultRouteController {

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
  
  @Override
  protected boolean isAutomaticHtmlRoutingEnabled() {
    return true;
  }
  
  @Override
  protected ERXRestFormat defaultFormat() {
    return ERXRestFormat.json();
  }

}
