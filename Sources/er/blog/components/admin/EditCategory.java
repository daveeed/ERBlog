package er.blog.components.admin;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

import er.blog.components.BaseComponent;
import er.blog.eof.Category;
import er.extensions.validation.ERXValidationException;

public class EditCategory extends BaseComponent {

  private Category categoryItem;

  public EditCategory(WOContext context) {
    super(context);
  }

  public Category categoryItem() {
    return categoryItem;
  }

  public void setCategoryItem(Category categoryItem) {
    this.categoryItem = categoryItem;
  }

  public WOComponent save() {
    try {
      editingContext().saveChanges();
    } catch (ERXValidationException exception) {
      return null;
    }
    return (CategoriesListing)pageWithName(CategoriesListing.class);
  }

}