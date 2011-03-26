package er.blog.components.admin;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

import er.blog.components.BaseComponent;
import er.blog.enums.AccessLevel;
import er.blog.eof.User;

public class CreateFirstAccount extends BaseComponent {

  public String username;
  public String password;
  public String firstName;
  public String lastName;

  public CreateFirstAccount(WOContext context) {
    super(context);
  }

  public WOComponent createUser() {
    User newUser = User.createUser(editingContext(), AccessLevel.ADMIN, firstName, lastName, password, username);
    if (newUser != null) {
      session().setLoggedUser(newUser);
      editingContext().saveChanges();
      return (MainAdminPage)pageWithName(MainAdminPage.class);
    }
    return null;
  }
}