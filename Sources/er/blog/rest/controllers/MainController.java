package er.blog.rest.controllers;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WORequest;

import er.blog.components.Main;
import er.rest.format.ERXRestFormat;

public class MainController extends BaseController {
  
  public MainController(WORequest request) {
    super(request);
  }
  
  @Override
  protected boolean isAutomaticHtmlRoutingEnabled() {
    return true;
  }

  @Override
  public WOActionResults indexAction() throws Throwable {
    return pageWithName(Main.class);
  }
  
  @Override
  protected ERXRestFormat defaultFormat() {
    return ERXRestFormat.html();
  }

}
