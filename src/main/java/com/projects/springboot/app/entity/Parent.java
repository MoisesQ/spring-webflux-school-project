package com.projects.springboot.app.entity;

import javax.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "parents")
public class Parent {

  @Id
  private String parentId;

  @NotEmpty
  private String gender;

  @NotEmpty
  private String firstName;

  @NotEmpty
  private String middleName;

  @NotEmpty
  private String lastName;

  private String otherParentDetails;

  /**
   * This is the default constructor method without id.
   */
  public Parent(@NotEmpty String gender, @NotEmpty String firstName, @NotEmpty String middleName,
      @NotEmpty String lastName, String otherParentDetails) {
    super();
    this.gender = gender;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.otherParentDetails = otherParentDetails;
  }

  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getOtherParentDetails() {
    return otherParentDetails;
  }

  public void setOtherParentDetails(String otherParentDetails) {
    this.otherParentDetails = otherParentDetails;
  }

}
