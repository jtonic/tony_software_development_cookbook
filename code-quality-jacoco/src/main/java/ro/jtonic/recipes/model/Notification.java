package ro.jtonic.recipes.model;

import java.util.StringJoiner;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Notification {

  private String id;
  private String message;
  private String recipient;
  private String type;

  @Override
  @Generated
  public String toString() {
    return new StringJoiner(", ", Notification.class.getSimpleName() + "[", "]")
        .add("id='" + id + "'")
        .add("message='" + message + "'")
        .add("recipient='" + recipient + "'")
        .add("type='" + type + "'")
        .toString();
  }
}
