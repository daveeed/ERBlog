package er.blog.components.admin;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;

import er.blog.Session;
import er.blog.eof.User;
import er.extensions.components.ERXComponent;

public class Login extends ERXComponent {

  public String username;
  public String password;

  public Login(WOContext context) {
    super(context);
  }
  
  public boolean haveExistingUsers() {
    return (User.isHaveUsers());
  }
  
  public WOActionResults login() {
    User loggedUser = User.validateLogin(session().defaultEditingContext(), username, password);
    session().setLoggedUser(loggedUser);
    return null;
  }

  public Session session() {
    return (Session)super.session();
  }

}