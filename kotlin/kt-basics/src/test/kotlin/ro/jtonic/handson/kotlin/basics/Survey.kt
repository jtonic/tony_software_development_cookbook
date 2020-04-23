package ro.jtonic.handson.kotlin.basics;

import java.util.Objects;
import java.util.StringJoiner;

public class Survey {

  private String id;
  private String name;
  private String description;
  private String category;

  public Survey(String id, String name, String description, String category) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.category = category;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Survey survey = (Survey) o;
    return Objects.equals(id, survey.id) &&
        name.equals(survey.name) &&
        Objects.equals(description, survey.description) &&
        category.equals(survey.category);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, category);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Survey.class.getSimpleName() + "[", "]")
        .add("id='" + id + "'")
        .add("name='" + name + "'")
        .add("description='" + description + "'")
        .add("category='" + category + "'")
        .toString();
  }
}
