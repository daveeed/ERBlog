package er.blog.components.admin;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResponse;
import com.webobjects.eoaccess.EODatabaseDataSource;

import er.blog.components.BaseComponent;
import er.blog.eof.Category;
import er.extensions.batching.ERXBatchingDisplayGroup;

public class CategoriesListing extends BaseComponent {

  public ERXBatchingDisplayGroup<Category> dg;
  private Category categoryItem;

  public CategoriesListing(WOContext context) {
    super(context);
  }
  
  @Override
  public void appendToResponse(WOResponse response, WOContext context) {
    EODatabaseDataSource dataSource = new EODatabaseDataSource(editingContext(), Category.ENTITY_NAME);
    dg = new ERXBatchingDisplayGroup<Category>();
    dg.setNumberOfObjectsPerBatch(20);
    dg.setDataSource(dataSource);
    dg.setObjectArray(Category.fetchAllCategories(editingContext()));
    super.appendToResponse(response, context);
  }

  public WOComponent addNewCategory() {
    EditCategory nextPage = (EditCategory)pageWithName(EditCategory.class);
    nextPage.setCategoryItem(Category.createCategory(editingContext(), null, null));
    return nextPage;
  }

  public WOComponent editCategory() {
    EditCategory nextPage = (EditCategory)pageWithName(EditCategory.class);
    nextPage.setCategoryItem(categoryItem);
    return nextPage;
  }

  public Category categoryItem() {
    return categoryItem;
  }

  public void setCategoryItem(Category categoryItem) {
    this.categoryItem = categoryItem;
  }

  public WOComponent deleteCategory() {
    editingContext().deleteObject(categoryItem);
    editingContext().saveChanges();
    return null;
  }
}