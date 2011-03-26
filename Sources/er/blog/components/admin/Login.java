package er.blog.components.admin;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

import er.blog.eof.User;
import er.extensions.components.ERXComponent;

public class Login extends ERXComponent {

  public String username;
  public String password;

  public Login(WOContext context) {
    super(context);
  }
  
  public WOComponent login() {
    User loggedUser = User.fetchRequiredUser(session().defaultEditingContext(), User.USERNAME.eq(username).and(User.PASSWORD.eq(password)));
    if (loggedUser != null) {
      return (MainAdminPage)pageWithName(MainAdminPage.class);
    }
    return null;
  }
  
}