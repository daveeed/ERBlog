package er.blog.components;

import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.blog.eof.Category;
import er.blog.eof.Post;
import er.extensions.components.ERXComponent;
import er.extensions.eof.ERXEC;

public class Main extends ERXComponent {

  private NSArray<Post> recentPosts;
  private NSArray<Category> categories;
  private EOEditingContext editingContext;
  private Category categoryItem;
  private Post postItem;

  public Main(WOContext context) {
    super(context);
  }

  public EOEditingContext editingContext() {
    if (editingContext == null) {
      editingContext = ERXEC.newEditingContext();
    }
    return editingContext;
  }

  public NSArray<Category> categories() {
    if (categories == null) {
      categories = Category.fetchAllCategories(editingContext());
    }
    return categories;
  }

  public NSArray<Post> recentPosts() {
    if (recentPosts == null) {
      recentPosts = Post.fetchAllPosts(editingContext());
    }
    return recentPosts;
  }

  public Category categoryItem() {
    return categoryItem;
  }

  public void setCategoryItem(Category categoryItem) {
    this.categoryItem = categoryItem;
  }

  public Post postItem() {
    return postItem;
  }

  public void setPostItem(Post postItem) {
    this.postItem = postItem;
  }

}
