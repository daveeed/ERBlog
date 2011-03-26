// DO NOT EDIT.  Make changes to Post.java instead.
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
public abstract class _Post extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Post";

  // Attribute Keys
  public static final ERXKey<String> CONTENT = new ERXKey<String>("content");
  public static final ERXKey<NSTimestamp> LAST_MODIFIED_DATE = new ERXKey<NSTimestamp>("lastModifiedDate");
  public static final ERXKey<NSTimestamp> PUBLISHED_DATE = new ERXKey<NSTimestamp>("publishedDate");
  public static final ERXKey<String> TITLE = new ERXKey<String>("title");
  // Relationship Keys
  public static final ERXKey<er.blog.eof.User> AUTHOR = new ERXKey<er.blog.eof.User>("author");

  // Attributes
  public static final String CONTENT_KEY = CONTENT.key();
  public static final String LAST_MODIFIED_DATE_KEY = LAST_MODIFIED_DATE.key();
  public static final String PUBLISHED_DATE_KEY = PUBLISHED_DATE.key();
  public static final String TITLE_KEY = TITLE.key();
  // Relationships
  public static final String AUTHOR_KEY = AUTHOR.key();

  private static Logger LOG = Logger.getLogger(_Post.class);

  public Post localInstanceIn(EOEditingContext editingContext) {
    Post localInstance = (Post)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String content() {
    return (String) storedValueForKey(_Post.CONTENT_KEY);
  }

  public void setContent(String value) {
    if (_Post.LOG.isDebugEnabled()) {
    	_Post.LOG.debug( "updating content from " + content() + " to " + value);
    }
    takeStoredValueForKey(value, _Post.CONTENT_KEY);
  }

  public NSTimestamp lastModifiedDate() {
    return (NSTimestamp) storedValueForKey(_Post.LAST_MODIFIED_DATE_KEY);
  }

  public void setLastModifiedDate(NSTimestamp value) {
    if (_Post.LOG.isDebugEnabled()) {
    	_Post.LOG.debug( "updating lastModifiedDate from " + lastModifiedDate() + " to " + value);
    }
    takeStoredValueForKey(value, _Post.LAST_MODIFIED_DATE_KEY);
  }

  public NSTimestamp publishedDate() {
    return (NSTimestamp) storedValueForKey(_Post.PUBLISHED_DATE_KEY);
  }

  public void setPublishedDate(NSTimestamp value) {
    if (_Post.LOG.isDebugEnabled()) {
    	_Post.LOG.debug( "updating publishedDate from " + publishedDate() + " to " + value);
    }
    takeStoredValueForKey(value, _Post.PUBLISHED_DATE_KEY);
  }

  public String title() {
    return (String) storedValueForKey(_Post.TITLE_KEY);
  }

  public void setTitle(String value) {
    if (_Post.LOG.isDebugEnabled()) {
    	_Post.LOG.debug( "updating title from " + title() + " to " + value);
    }
    takeStoredValueForKey(value, _Post.TITLE_KEY);
  }

  public er.blog.eof.User author() {
    return (er.blog.eof.User)storedValueForKey(_Post.AUTHOR_KEY);
  }
  
  public void setAuthor(er.blog.eof.User value) {
    takeStoredValueForKey(value, _Post.AUTHOR_KEY);
  }

  public void setAuthorRelationship(er.blog.eof.User value) {
    if (_Post.LOG.isDebugEnabled()) {
      _Post.LOG.debug("updating author from " + author() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setAuthor(value);
    }
    else if (value == null) {
    	er.blog.eof.User oldValue = author();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _Post.AUTHOR_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _Post.AUTHOR_KEY);
    }
  }
  

  public static Post createPost(EOEditingContext editingContext, String content
, NSTimestamp lastModifiedDate
, NSTimestamp publishedDate
, String title
, er.blog.eof.User author) {
    Post eo = (Post) EOUtilities.createAndInsertInstance(editingContext, _Post.ENTITY_NAME);    
		eo.setContent(content);
		eo.setLastModifiedDate(lastModifiedDate);
		eo.setPublishedDate(publishedDate);
		eo.setTitle(title);
    eo.setAuthorRelationship(author);
    return eo;
  }

  public static ERXFetchSpecification<Post> fetchSpec() {
    return new ERXFetchSpecification<Post>(_Post.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Post> fetchAllPosts(EOEditingContext editingContext) {
    return _Post.fetchAllPosts(editingContext, null);
  }

  public static NSArray<Post> fetchAllPosts(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Post.fetchPosts(editingContext, null, sortOrderings);
  }

  public static NSArray<Post> fetchPosts(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Post> fetchSpec = new ERXFetchSpecification<Post>(_Post.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Post> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Post fetchPost(EOEditingContext editingContext, String keyName, Object value) {
    return _Post.fetchPost(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Post fetchPost(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Post> eoObjects = _Post.fetchPosts(editingContext, qualifier, null);
    Post eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Post that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Post fetchRequiredPost(EOEditingContext editingContext, String keyName, Object value) {
    return _Post.fetchRequiredPost(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Post fetchRequiredPost(EOEditingContext editingContext, EOQualifier qualifier) {
    Post eoObject = _Post.fetchPost(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Post that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Post localInstanceIn(EOEditingContext editingContext, Post eo) {
    Post localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
