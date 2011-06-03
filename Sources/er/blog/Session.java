package er.blog;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WORedirect;

import er.blog.eof.User;
import er.extensions.appserver.ERXSession;

public class Session extends ERXSession {
  private static final long serialVersionUID = 1L;
  private User loggedUser;

  public Session() {
    setStoresIDsInCookies(true);
  }

  public User loggedUser() {
    return loggedUser;
  }

  public void setLoggedUser(User loggedUser) {
    this.loggedUser = loggedUser;
  }
  
  public WOActionResults logout() {
    this.terminate();
    WORedirect defaultPage = new WORedirect(this.context());
    defaultPage.setUrl(this.context().directActionURLForActionNamed("default", null));
    return defaultPage;
  }
}
