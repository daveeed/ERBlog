package er.blog.eof.migrations;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXMigrationTable;
import er.extensions.migration.ERXModelVersion;

public class BlogModel0 extends ERXMigrationDatabase.Migration {
  @Override
  public NSArray<ERXModelVersion> modelDependencies() {
    return null;
  }
  
  @Override
  public void downgrade(EOEditingContext editingContext, ERXMigrationDatabase database) throws Throwable {
    // DO NOTHING
  }

  @Override
  public void upgrade(EOEditingContext editingContext, ERXMigrationDatabase database) throws Throwable {
    ERXMigrationTable userTable = database.newTableNamed("User");
    userTable.newStringColumn("accessLevel", 50, false);
    userTable.newStringColumn("firstName", 50, false);
    userTable.newIntegerColumn("id", false);
    userTable.newStringColumn("lastName", 50, false);
    userTable.newStringColumn("password", 16, false);
    userTable.newStringColumn("username", 16, false);
    userTable.create();
    userTable.setPrimaryKey("id");

    ERXMigrationTable categoryTable = database.newTableNamed("Category");
    categoryTable.newIntegerColumn("id", false);
    categoryTable.newStringColumn("name", 100, false);
    categoryTable.newStringColumn("shortName", 16, false);
    categoryTable.create();
    categoryTable.setPrimaryKey("id");

    ERXMigrationTable postTable = database.newTableNamed("Post");
    postTable.newLargeStringColumn("content", false);
    postTable.newIntegerColumn("id", false);
    postTable.newTimestampColumn("lastModifiedDate", false);
    postTable.newTimestampColumn("publishedDate", false);
    postTable.newStringColumn("title", 255, false);
    postTable.newIntegerColumn("userID", false);
    postTable.create();
    postTable.setPrimaryKey("id");

    ERXMigrationTable systemPreferencesTable = database.newTableNamed("SystemPreferences");
    systemPreferencesTable.newStringColumn("dateFormat", 10, false);
    systemPreferencesTable.newStringColumn("emailAddress", 255, false);
    systemPreferencesTable.newIntegerColumn("feedNbrRecentPosts", false);
    systemPreferencesTable.newIntegerColumn("id", false);
    systemPreferencesTable.newBooleanColumn("isAllowComments", false);
    systemPreferencesTable.newBooleanColumn("isEmailWhenAnyonePostsComment", false);
    systemPreferencesTable.newBooleanColumn("isPublishExternalNotification", false);
    systemPreferencesTable.newBooleanColumn("shouldModerateComments", false);
    systemPreferencesTable.newStringColumn("siteTitle", 100, false);
    systemPreferencesTable.newStringColumn("tagLine", 100, false);
    systemPreferencesTable.newStringColumn("timeFormat", 10, false);
    systemPreferencesTable.newStringColumn("timeZone", 255, false);
    systemPreferencesTable.create();
    systemPreferencesTable.setPrimaryKey("id");

    postTable.addForeignKey("userID", "User", "id");
  }
}