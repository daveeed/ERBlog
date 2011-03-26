package er.blog;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WORequest;

import er.blog.components.admin.CreateFirstAccount;
import er.blog.components.admin.Login;
import er.blog.eof.User;
import er.extensions.appserver.ERXDirectAction;
import er.extensions.eof.ERXEOControlUtilities;

public class DirectAction extends ERXDirectAction {
	public DirectAction(WORequest request) {
		super(request);
	}

	@Override
	public WOActionResults defaultAction() {
    int totalOfUsers = ERXEOControlUtilities.objectCountWithQualifier(session().defaultEditingContext(), User.ENTITY_NAME, null);
    if (totalOfUsers == 0) {
      return pageWithName(CreateFirstAccount.class);
    }
		return pageWithName(Login.class);
	}
}
