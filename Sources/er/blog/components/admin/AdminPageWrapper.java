package er.blog.components.admin;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSKeyValueCoding;

import er.blog.components.BaseComponent;

public class AdminPageWrapper extends BaseComponent {
  
  private String pageTitle;
  
  public AdminPageWrapper(WOContext context) {
    super(context);
  }

  public NSKeyValueCoding navigationContext() {
    return (NSKeyValueCoding)session().objectForKey("navigationContext");
  }

  public String pageTitle() {
    return pageTitle;
  }

  public void setPageTitle(String pageTitle) {
    this.pageTitle = pageTitle;
  } 
}