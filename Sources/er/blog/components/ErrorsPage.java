package er.blog.components;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSLog;
import com.webobjects.foundation.NSMutableArray;

import er.extensions.components.ERXStatelessComponent;

public class ErrorsPage extends ERXStatelessComponent {
  
  private String errorItem;
  private NSMutableArray<String> errors;
  
  public ErrorsPage(WOContext context) {
    super(context);
  }

  public String errorItem() {
    return errorItem;
  }

  public void setErrorItem(String errorItem) {
    this.errorItem = errorItem;
  }
  
  public NSMutableArray<String> errors() {
    if (errors == null) {
      NSLog.out.appendln(valueForBinding("errors"));
      errors = ((NSMutableArray<String>)valueForBinding("errors"));
    }
    return errors;
  }
  
  public void setErrors(NSMutableArray<String> errors) {
    this.errors = errors;
  }
  
}