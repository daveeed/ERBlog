package er.blog.components;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

import er.blog.eof.Category;
import er.rest.routes.ERXRouteParameter;
import er.rest.routes.IERXRouteComponent;

public class CategoryShowPage extends WOComponent implements IERXRouteComponent {

  private Category category;

  public CategoryShowPage(WOContext context) {
    super(context);
  }

  @ERXRouteParameter
  public void setCategory(Category category) {
    this.category = category; 
  }
  
  public Category category() {
    return category;
  }
}