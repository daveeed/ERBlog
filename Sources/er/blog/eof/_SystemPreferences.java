// DO NOT EDIT.  Make changes to SystemPreferences.java instead.
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
public abstract class _SystemPreferences extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "SystemPreferences";

  // Attribute Keys
  public static final ERXKey<String> DATE_FORMAT = new ERXKey<String>("dateFormat");
  public static final ERXKey<String> EMAIL_ADDRESS = new ERXKey<String>("emailAddress");
  public static final ERXKey<Integer> FEED_NBR_RECENT_POSTS = new ERXKey<Integer>("feedNbrRecentPosts");
  public static final ERXKey<Boolean> IS_ALLOW_COMMENTS = new ERXKey<Boolean>("isAllowComments");
  public static final ERXKey<Boolean> IS_EMAIL_WHEN_ANYONE_POSTS_COMMENT = new ERXKey<Boolean>("isEmailWhenAnyonePostsComment");
  public static final ERXKey<Boolean> IS_PUBLISH_EXTERNAL_NOTIFICATION = new ERXKey<Boolean>("isPublishExternalNotification");
  public static final ERXKey<Boolean> SHOULD_MODERATE_COMMENTS = new ERXKey<Boolean>("shouldModerateComments");
  public static final ERXKey<String> SITE_TITLE = new ERXKey<String>("siteTitle");
  public static final ERXKey<String> TAG_LINE = new ERXKey<String>("tagLine");
  public static final ERXKey<String> TIME_FORMAT = new ERXKey<String>("timeFormat");
  public static final ERXKey<String> TIME_ZONE = new ERXKey<String>("timeZone");
  // Relationship Keys

  // Attributes
  public static final String DATE_FORMAT_KEY = DATE_FORMAT.key();
  public static final String EMAIL_ADDRESS_KEY = EMAIL_ADDRESS.key();
  public static final String FEED_NBR_RECENT_POSTS_KEY = FEED_NBR_RECENT_POSTS.key();
  public static final String IS_ALLOW_COMMENTS_KEY = IS_ALLOW_COMMENTS.key();
  public static final String IS_EMAIL_WHEN_ANYONE_POSTS_COMMENT_KEY = IS_EMAIL_WHEN_ANYONE_POSTS_COMMENT.key();
  public static final String IS_PUBLISH_EXTERNAL_NOTIFICATION_KEY = IS_PUBLISH_EXTERNAL_NOTIFICATION.key();
  public static final String SHOULD_MODERATE_COMMENTS_KEY = SHOULD_MODERATE_COMMENTS.key();
  public static final String SITE_TITLE_KEY = SITE_TITLE.key();
  public static final String TAG_LINE_KEY = TAG_LINE.key();
  public static final String TIME_FORMAT_KEY = TIME_FORMAT.key();
  public static final String TIME_ZONE_KEY = TIME_ZONE.key();
  // Relationships

  private static Logger LOG = Logger.getLogger(_SystemPreferences.class);

  public SystemPreferences localInstanceIn(EOEditingContext editingContext) {
    SystemPreferences localInstance = (SystemPreferences)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String dateFormat() {
    return (String) storedValueForKey(_SystemPreferences.DATE_FORMAT_KEY);
  }

  public void setDateFormat(String value) {
    if (_SystemPreferences.LOG.isDebugEnabled()) {
    	_SystemPreferences.LOG.debug( "updating dateFormat from " + dateFormat() + " to " + value);
    }
    takeStoredValueForKey(value, _SystemPreferences.DATE_FORMAT_KEY);
  }

  public String emailAddress() {
    return (String) storedValueForKey(_SystemPreferences.EMAIL_ADDRESS_KEY);
  }

  public void setEmailAddress(String value) {
    if (_SystemPreferences.LOG.isDebugEnabled()) {
    	_SystemPreferences.LOG.debug( "updating emailAddress from " + emailAddress() + " to " + value);
    }
    takeStoredValueForKey(value, _SystemPreferences.EMAIL_ADDRESS_KEY);
  }

  public Integer feedNbrRecentPosts() {
    return (Integer) storedValueForKey(_SystemPreferences.FEED_NBR_RECENT_POSTS_KEY);
  }

  public void setFeedNbrRecentPosts(Integer value) {
    if (_SystemPreferences.LOG.isDebugEnabled()) {
    	_SystemPreferences.LOG.debug( "updating feedNbrRecentPosts from " + feedNbrRecentPosts() + " to " + value);
    }
    takeStoredValueForKey(value, _SystemPreferences.FEED_NBR_RECENT_POSTS_KEY);
  }

  public Boolean isAllowComments() {
    return (Boolean) storedValueForKey(_SystemPreferences.IS_ALLOW_COMMENTS_KEY);
  }

  public void setIsAllowComments(Boolean value) {
    if (_SystemPreferences.LOG.isDebugEnabled()) {
    	_SystemPreferences.LOG.debug( "updating isAllowComments from " + isAllowComments() + " to " + value);
    }
    takeStoredValueForKey(value, _SystemPreferences.IS_ALLOW_COMMENTS_KEY);
  }

  public Boolean isEmailWhenAnyonePostsComment() {
    return (Boolean) storedValueForKey(_SystemPreferences.IS_EMAIL_WHEN_ANYONE_POSTS_COMMENT_KEY);
  }

  public void setIsEmailWhenAnyonePostsComment(Boolean value) {
    if (_SystemPreferences.LOG.isDebugEnabled()) {
    	_SystemPreferences.LOG.debug( "updating isEmailWhenAnyonePostsComment from " + isEmailWhenAnyonePostsComment() + " to " + value);
    }
    takeStoredValueForKey(value, _SystemPreferences.IS_EMAIL_WHEN_ANYONE_POSTS_COMMENT_KEY);
  }

  public Boolean isPublishExternalNotification() {
    return (Boolean) storedValueForKey(_SystemPreferences.IS_PUBLISH_EXTERNAL_NOTIFICATION_KEY);
  }

  public void setIsPublishExternalNotification(Boolean value) {
    if (_SystemPreferences.LOG.isDebugEnabled()) {
    	_SystemPreferences.LOG.debug( "updating isPublishExternalNotification from " + isPublishExternalNotification() + " to " + value);
    }
    takeStoredValueForKey(value, _SystemPreferences.IS_PUBLISH_EXTERNAL_NOTIFICATION_KEY);
  }

  public Boolean shouldModerateComments() {
    return (Boolean) storedValueForKey(_SystemPreferences.SHOULD_MODERATE_COMMENTS_KEY);
  }

  public void setShouldModerateComments(Boolean value) {
    if (_SystemPreferences.LOG.isDebugEnabled()) {
    	_SystemPreferences.LOG.debug( "updating shouldModerateComments from " + shouldModerateComments() + " to " + value);
    }
    takeStoredValueForKey(value, _SystemPreferences.SHOULD_MODERATE_COMMENTS_KEY);
  }

  public String siteTitle() {
    return (String) storedValueForKey(_SystemPreferences.SITE_TITLE_KEY);
  }

  public void setSiteTitle(String value) {
    if (_SystemPreferences.LOG.isDebugEnabled()) {
    	_SystemPreferences.LOG.debug( "updating siteTitle from " + siteTitle() + " to " + value);
    }
    takeStoredValueForKey(value, _SystemPreferences.SITE_TITLE_KEY);
  }

  public String tagLine() {
    return (String) storedValueForKey(_SystemPreferences.TAG_LINE_KEY);
  }

  public void setTagLine(String value) {
    if (_SystemPreferences.LOG.isDebugEnabled()) {
    	_SystemPreferences.LOG.debug( "updating tagLine from " + tagLine() + " to " + value);
    }
    takeStoredValueForKey(value, _SystemPreferences.TAG_LINE_KEY);
  }

  public String timeFormat() {
    return (String) storedValueForKey(_SystemPreferences.TIME_FORMAT_KEY);
  }

  public void setTimeFormat(String value) {
    if (_SystemPreferences.LOG.isDebugEnabled()) {
    	_SystemPreferences.LOG.debug( "updating timeFormat from " + timeFormat() + " to " + value);
    }
    takeStoredValueForKey(value, _SystemPreferences.TIME_FORMAT_KEY);
  }

  public String timeZone() {
    return (String) storedValueForKey(_SystemPreferences.TIME_ZONE_KEY);
  }

  public void setTimeZone(String value) {
    if (_SystemPreferences.LOG.isDebugEnabled()) {
    	_SystemPreferences.LOG.debug( "updating timeZone from " + timeZone() + " to " + value);
    }
    takeStoredValueForKey(value, _SystemPreferences.TIME_ZONE_KEY);
  }


  public static SystemPreferences createSystemPreferences(EOEditingContext editingContext, String dateFormat
, String emailAddress
, Integer feedNbrRecentPosts
, Boolean isAllowComments
, Boolean isEmailWhenAnyonePostsComment
, Boolean isPublishExternalNotification
, Boolean shouldModerateComments
, String siteTitle
, String tagLine
, String timeFormat
, String timeZone
) {
    SystemPreferences eo = (SystemPreferences) EOUtilities.createAndInsertInstance(editingContext, _SystemPreferences.ENTITY_NAME);    
		eo.setDateFormat(dateFormat);
		eo.setEmailAddress(emailAddress);
		eo.setFeedNbrRecentPosts(feedNbrRecentPosts);
		eo.setIsAllowComments(isAllowComments);
		eo.setIsEmailWhenAnyonePostsComment(isEmailWhenAnyonePostsComment);
		eo.setIsPublishExternalNotification(isPublishExternalNotification);
		eo.setShouldModerateComments(shouldModerateComments);
		eo.setSiteTitle(siteTitle);
		eo.setTagLine(tagLine);
		eo.setTimeFormat(timeFormat);
		eo.setTimeZone(timeZone);
    return eo;
  }

  public static ERXFetchSpecification<SystemPreferences> fetchSpec() {
    return new ERXFetchSpecification<SystemPreferences>(_SystemPreferences.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<SystemPreferences> fetchAllSystemPreferenceses(EOEditingContext editingContext) {
    return _SystemPreferences.fetchAllSystemPreferenceses(editingContext, null);
  }

  public static NSArray<SystemPreferences> fetchAllSystemPreferenceses(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _SystemPreferences.fetchSystemPreferenceses(editingContext, null, sortOrderings);
  }

  public static NSArray<SystemPreferences> fetchSystemPreferenceses(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<SystemPreferences> fetchSpec = new ERXFetchSpecification<SystemPreferences>(_SystemPreferences.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<SystemPreferences> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static SystemPreferences fetchSystemPreferences(EOEditingContext editingContext, String keyName, Object value) {
    return _SystemPreferences.fetchSystemPreferences(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static SystemPreferences fetchSystemPreferences(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<SystemPreferences> eoObjects = _SystemPreferences.fetchSystemPreferenceses(editingContext, qualifier, null);
    SystemPreferences eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one SystemPreferences that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static SystemPreferences fetchRequiredSystemPreferences(EOEditingContext editingContext, String keyName, Object value) {
    return _SystemPreferences.fetchRequiredSystemPreferences(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static SystemPreferences fetchRequiredSystemPreferences(EOEditingContext editingContext, EOQualifier qualifier) {
    SystemPreferences eoObject = _SystemPreferences.fetchSystemPreferences(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no SystemPreferences that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static SystemPreferences localInstanceIn(EOEditingContext editingContext, SystemPreferences eo) {
    SystemPreferences localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
