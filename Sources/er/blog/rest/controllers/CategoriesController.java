package er.blog.rest.controllers;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WORequest;

import er.blog.eof.Category;
import er.extensions.eof.ERXKeyFilter;
import er.rest.routes.ERXRouteResults;

public class CategoriesController extends BaseController {

  public CategoriesController(WORequest request) {
    super(request);
  }

  @Override
  public WOActionResults createAction() throws Throwable {
    ERXKeyFilter filter = ERXKeyFilter.filterWithAttributes();
    Category newCategory = create(filter);
    editingContext().saveChanges();
    
    ERXRouteResults response = (ERXRouteResults)response(newCategory, filter);
    generateLocationHeader(response, newCategory, "show");
    return response;    
  }
  
  @Override
  public WOActionResults updateAction() throws Throwable {
    ERXKeyFilter filter = ERXKeyFilter.filterWithAttributes();
    Category category = routeObjectForKey("category");
    update(category, filter);
    editingContext().saveChanges();
    return response(category, filter);
  }

}
