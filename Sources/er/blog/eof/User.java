package er.blog.eof;

import org.apache.log4j.Logger;

import com.webobjects.eocontrol.EOEditingContext;

import er.extensions.eof.ERXEC;
import er.extensions.eof.ERXEOControlUtilities;
import er.extensions.validation.ERXValidationException;

public class User extends _User {
  @SuppressWarnings("unused")
  private static Logger log = Logger.getLogger(User.class);

  public static User validateLogin(EOEditingContext editingContext, String username, String password) throws UserLoginException {
    User user = User.fetchUser(editingContext, User.USERNAME.eq(username).and(User.PASSWORD.eq(password)));
    if (user == null) {
      throw new UserLoginException("User.NoUserFound", user, USERNAME_KEY);
    }
    return user;
  }
  
  public static boolean isHaveUsers() {
    int count = ERXEOControlUtilities.objectCountWithQualifier(ERXEC.newEditingContext(), User.ENTITY_NAME, null);
    return (count == 0)? false: true;
  }
  
  public static class UserLoginException extends ERXValidationException {
    public UserLoginException(String type, Object object, String key) {
      super(type, object, key);
    }
  }
}
