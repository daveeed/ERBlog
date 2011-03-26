// DO NOT EDIT.  Make changes to User.java instead.
package er.blog.eof;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;
import org.apache.log4j.Logger;

import er.extensions.eof.*;
import er.extensions.foundation.*;

@SuppressWarnings("all")
public abstract class _User extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "User";

  // Attribute Keys
  public static final ERXKey<er.blog.enums.AccessLevel> ACCESS_LEVEL = new ERXKey<er.blog.enums.AccessLevel>("accessLevel");
  public static final ERXKey<String> FIRST_NAME = new ERXKey<String>("firstName");
  public static final ERXKey<String> LAST_NAME = new ERXKey<String>("lastName");
  public static final ERXKey<String> PASSWORD = new ERXKey<String>("password");
  public static final ERXKey<String> USERNAME = new ERXKey<String>("username");
  // Relationship Keys
  public static final ERXKey<er.blog.eof.Post> POSTS = new ERXKey<er.blog.eof.Post>("posts");

  // Attributes
  public static final String ACCESS_LEVEL_KEY = ACCESS_LEVEL.key();
  public static final String FIRST_NAME_KEY = FIRST_NAME.key();
  public static final String LAST_NAME_KEY = LAST_NAME.key();
  public static final String PASSWORD_KEY = PASSWORD.key();
  public static final String USERNAME_KEY = USERNAME.key();
  // Relationships
  public static final String POSTS_KEY = POSTS.key();

  private static Logger LOG = Logger.getLogger(_User.class);

  public User localInstanceIn(EOEditingContext editingContext) {
    User localInstance = (User)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public er.blog.enums.AccessLevel accessLevel() {
    return (er.blog.enums.AccessLevel) storedValueForKey(_User.ACCESS_LEVEL_KEY);
  }

  public void setAccessLevel(er.blog.enums.AccessLevel value) {
    if (_User.LOG.isDebugEnabled()) {
    	_User.LOG.debug( "updating accessLevel from " + accessLevel() + " to " + value);
    }
    takeStoredValueForKey(value, _User.ACCESS_LEVEL_KEY);
  }

  public String firstName() {
    return (String) storedValueForKey(_User.FIRST_NAME_KEY);
  }

  public void setFirstName(String value) {
    if (_User.LOG.isDebugEnabled()) {
    	_User.LOG.debug( "updating firstName from " + firstName() + " to " + value);
    }
    takeStoredValueForKey(value, _User.FIRST_NAME_KEY);
  }

  public String lastName() {
    return (String) storedValueForKey(_User.LAST_NAME_KEY);
  }

  public void setLastName(String value) {
    if (_User.LOG.isDebugEnabled()) {
    	_User.LOG.debug( "updating lastName from " + lastName() + " to " + value);
    }
    takeStoredValueForKey(value, _User.LAST_NAME_KEY);
  }

  public String password() {
    return (String) storedValueForKey(_User.PASSWORD_KEY);
  }

  public void setPassword(String value) {
    if (_User.LOG.isDebugEnabled()) {
    	_User.LOG.debug( "updating password from " + password() + " to " + value);
    }
    takeStoredValueForKey(value, _User.PASSWORD_KEY);
  }

  public String username() {
    return (String) storedValueForKey(_User.USERNAME_KEY);
  }

  public void setUsername(String value) {
    if (_User.LOG.isDebugEnabled()) {
    	_User.LOG.debug( "updating username from " + username() + " to " + value);
    }
    takeStoredValueForKey(value, _User.USERNAME_KEY);
  }

  public NSArray<er.blog.eof.Post> posts() {
    return (NSArray<er.blog.eof.Post>)storedValueForKey(_User.POSTS_KEY);
  }

  public NSArray<er.blog.eof.Post> posts(EOQualifier qualifier) {
    return posts(qualifier, null, false);
  }

  public NSArray<er.blog.eof.Post> posts(EOQualifier qualifier, boolean fetch) {
    return posts(qualifier, null, fetch);
  }

  public NSArray<er.blog.eof.Post> posts(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<er.blog.eof.Post> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(er.blog.eof.Post.AUTHOR_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = er.blog.eof.Post.fetchPosts(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = posts();
      if (qualifier != null) {
        results = (NSArray<er.blog.eof.Post>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<er.blog.eof.Post>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToPosts(er.blog.eof.Post object) {
    includeObjectIntoPropertyWithKey(object, _User.POSTS_KEY);
  }

  public void removeFromPosts(er.blog.eof.Post object) {
    excludeObjectFromPropertyWithKey(object, _User.POSTS_KEY);
  }

  public void addToPostsRelationship(er.blog.eof.Post object) {
    if (_User.LOG.isDebugEnabled()) {
      _User.LOG.debug("adding " + object + " to posts relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToPosts(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _User.POSTS_KEY);
    }
  }

  public void removeFromPostsRelationship(er.blog.eof.Post object) {
    if (_User.LOG.isDebugEnabled()) {
      _User.LOG.debug("removing " + object + " from posts relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromPosts(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _User.POSTS_KEY);
    }
  }

  public er.blog.eof.Post createPostsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( er.blog.eof.Post.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _User.POSTS_KEY);
    return (er.blog.eof.Post) eo;
  }

  public void deletePostsRelationship(er.blog.eof.Post object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _User.POSTS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllPostsRelationships() {
    Enumeration<er.blog.eof.Post> objects = posts().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deletePostsRelationship(objects.nextElement());
    }
  }


  public static User createUser(EOEditingContext editingContext, er.blog.enums.AccessLevel accessLevel
, String firstName
, String lastName
, String password
, String username
) {
    User eo = (User) EOUtilities.createAndInsertInstance(editingContext, _User.ENTITY_NAME);    
		eo.setAccessLevel(accessLevel);
		eo.setFirstName(firstName);
		eo.setLastName(lastName);
		eo.setPassword(password);
		eo.setUsername(username);
    return eo;
  }

  public static ERXFetchSpecification<User> fetchSpec() {
    return new ERXFetchSpecification<User>(_User.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<User> fetchAllUsers(EOEditingContext editingContext) {
    return _User.fetchAllUsers(editingContext, null);
  }

  public static NSArray<User> fetchAllUsers(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _User.fetchUsers(editingContext, null, sortOrderings);
  }

  public static NSArray<User> fetchUsers(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<User> fetchSpec = new ERXFetchSpecification<User>(_User.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<User> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static User fetchUser(EOEditingContext editingContext, String keyName, Object value) {
    return _User.fetchUser(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static User fetchUser(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<User> eoObjects = _User.fetchUsers(editingContext, qualifier, null);
    User eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one User that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static User fetchRequiredUser(EOEditingContext editingContext, String keyName, Object value) {
    return _User.fetchRequiredUser(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static User fetchRequiredUser(EOEditingContext editingContext, EOQualifier qualifier) {
    User eoObject = _User.fetchUser(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no User that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static User localInstanceIn(EOEditingContext editingContext, User eo) {
    User localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
