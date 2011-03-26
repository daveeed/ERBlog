package er.blog.enums;

import com.webobjects.foundation.NSArray;

public enum AccessLevel {

  ADMIN("Administrator"),
  WRITER("Writer");
  
  private String description;

  private AccessLevel(String description) {
    this.description = description;
  }
  
  public String key() {
    return description;
  }
    
  public static NSArray<AccessLevel> triggers() {
    return new NSArray<AccessLevel>(AccessLevel.values());
  }
  
  private AccessLevel() {
  }
}
  