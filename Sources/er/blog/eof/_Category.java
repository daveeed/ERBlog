// DO NOT EDIT.  Make changes to Category.java instead.
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
public abstract class _Category extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Category";

  // Attribute Keys
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  public static final ERXKey<String> SHORT_NAME = new ERXKey<String>("shortName");
  // Relationship Keys
  public static final ERXKey<er.blog.eof.Post> POSTS = new ERXKey<er.blog.eof.Post>("posts");

  // Attributes
  public static final String NAME_KEY = NAME.key();
  public static final String SHORT_NAME_KEY = SHORT_NAME.key();
  // Relationships
  public static final String POSTS_KEY = POSTS.key();

  private static Logger LOG = Logger.getLogger(_Category.class);

  public Category localInstanceIn(EOEditingContext editingContext) {
    Category localInstance = (Category)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String name() {
    return (String) storedValueForKey(_Category.NAME_KEY);
  }

  public void setName(String value) {
    if (_Category.LOG.isDebugEnabled()) {
    	_Category.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, _Category.NAME_KEY);
  }

  public String shortName() {
    return (String) storedValueForKey(_Category.SHORT_NAME_KEY);
  }

  public void setShortName(String value) {
    if (_Category.LOG.isDebugEnabled()) {
    	_Category.LOG.debug( "updating shortName from " + shortName() + " to " + value);
    }
    takeStoredValueForKey(value, _Category.SHORT_NAME_KEY);
  }

  public NSArray<er.blog.eof.Post> posts() {
    return (NSArray<er.blog.eof.Post>)storedValueForKey(_Category.POSTS_KEY);
  }

  public NSArray<er.blog.eof.Post> posts(EOQualifier qualifier) {
    return posts(qualifier, null);
  }

  public NSArray<er.blog.eof.Post> posts(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    NSArray<er.blog.eof.Post> results;
      results = posts();
      if (qualifier != null) {
        results = (NSArray<er.blog.eof.Post>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<er.blog.eof.Post>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }
  
  public void addToPosts(er.blog.eof.Post object) {
    includeObjectIntoPropertyWithKey(object, _Category.POSTS_KEY);
  }

  public void removeFromPosts(er.blog.eof.Post object) {
    excludeObjectFromPropertyWithKey(object, _Category.POSTS_KEY);
  }

  public void addToPostsRelationship(er.blog.eof.Post object) {
    if (_Category.LOG.isDebugEnabled()) {
      _Category.LOG.debug("adding " + object + " to posts relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToPosts(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _Category.POSTS_KEY);
    }
  }

  public void removeFromPostsRelationship(er.blog.eof.Post object) {
    if (_Category.LOG.isDebugEnabled()) {
      _Category.LOG.debug("removing " + object + " from posts relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromPosts(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _Category.POSTS_KEY);
    }
  }

  public er.blog.eof.Post createPostsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( er.blog.eof.Post.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _Category.POSTS_KEY);
    return (er.blog.eof.Post) eo;
  }

  public void deletePostsRelationship(er.blog.eof.Post object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Category.POSTS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllPostsRelationships() {
    Enumeration<er.blog.eof.Post> objects = posts().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deletePostsRelationship(objects.nextElement());
    }
  }


  public static Category createCategory(EOEditingContext editingContext, String name
, String shortName
) {
    Category eo = (Category) EOUtilities.createAndInsertInstance(editingContext, _Category.ENTITY_NAME);    
		eo.setName(name);
		eo.setShortName(shortName);
    return eo;
  }

  public static ERXFetchSpecification<Category> fetchSpec() {
    return new ERXFetchSpecification<Category>(_Category.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Category> fetchAllCategories(EOEditingContext editingContext) {
    return _Category.fetchAllCategories(editingContext, null);
  }

  public static NSArray<Category> fetchAllCategories(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Category.fetchCategories(editingContext, null, sortOrderings);
  }

  public static NSArray<Category> fetchCategories(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Category> fetchSpec = new ERXFetchSpecification<Category>(_Category.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Category> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Category fetchCategory(EOEditingContext editingContext, String keyName, Object value) {
    return _Category.fetchCategory(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Category fetchCategory(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Category> eoObjects = _Category.fetchCategories(editingContext, qualifier, null);
    Category eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Category that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Category fetchRequiredCategory(EOEditingContext editingContext, String keyName, Object value) {
    return _Category.fetchRequiredCategory(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Category fetchRequiredCategory(EOEditingContext editingContext, EOQualifier qualifier) {
    Category eoObject = _Category.fetchCategory(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Category that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Category localInstanceIn(EOEditingContext editingContext, Category eo) {
    Category localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
