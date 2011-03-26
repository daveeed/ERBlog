package er.blog.components;

import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSMutableArray;

import er.blog.Session;
import er.extensions.components.ERXComponent;

public class BaseComponent extends ERXComponent {

  private NSMutableArray<String> errors;
  
  public BaseComponent(WOContext context) {
    super(context);
    errors = new NSMutableArray<String>();
  }

  public Session session() {
    return (Session)super.session();
  }

  public EOEditingContext editingContext() {
    return session().defaultEditingContext();
  }

  public NSMutableArray<String> errors() {
    return errors;
  }

  public void setErrors(NSMutableArray<String> errors) {
    this.errors = errors;
  }
  
  @Override
  public void validationFailedWithException(Throwable t, Object value, String keyPath) {
    super.validationFailedWithException(t, value, keyPath);
    errors().addObject(t.getMessage());
  }
  
  public boolean hasErrors() {
    if (errors().count() > 0) {
      return true;
    }
    return false;
  }
  
  public void clearErrors() {
    errors.removeAllObjects(); 
  }

}
