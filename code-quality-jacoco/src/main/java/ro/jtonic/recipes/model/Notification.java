package ro.jtonic.recipes.model;

import java.util.Objects;
import java.util.StringJoiner;

public class Notification {

  private String id;
  private String message;
  private String recipient;
  private String type;

  public Notification(String id, String message, String recipient, String type) {
    this.id = id;
    this.message = message;
    this.recipient = recipient;
    this.type = type;
  }

  public Notification() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getRecipient() {
    return recipient;
  }

  public void setRecipient(String recipient) {
    this.recipient = recipient;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Notification that = (Notification) o;
    return id.equals(that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Notification.class.getSimpleName() + "[", "]")
        .add("id='" + id + "'")
        .add("message='" + message + "'")
        .add("recipient='" + recipient + "'")
        .add("type='" + type + "'")
        .toString();
  }
}
