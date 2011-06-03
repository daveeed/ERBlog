package er.blog.components;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

import er.blog.eof.Category;
import er.rest.routes.ERXRouteParameter;
import er.rest.routes.IERXRouteComponent;

public class CategoryUpdatePage extends WOComponent implements IERXRouteComponent {

  private Category category;

  public CategoryUpdatePage(WOContext context) {
    super(context);
  }

  @ERXRouteParameter
  public void setCategory(Category category) {
    this.category = category; 
  }

  public Category category() {
    return category;
  }
  
  public WOActionResults update() {
    category.editingContext().saveChanges();
    return null;
  }
}
