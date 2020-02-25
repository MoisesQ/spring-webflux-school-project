package com.projects.springboot.app.entity;

import javax.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "families")
public class Family {

  @Id
  private String familyId;

  @NotEmpty
  private String headOfFamilyParentId;

  @NotEmpty
  private String familyName;

  /**
   * This is the default constructor method without id.
   */
  public Family(@NotEmpty String headOfFamilyParentId, @NotEmpty String familyName) {
    super();
    this.headOfFamilyParentId = headOfFamilyParentId;
    this.familyName = familyName;
  }

  public String getFamilyId() {
    return familyId;
  }

  public void setFamilyId(String familyId) {
    this.familyId = familyId;
  }

  public String getHeadOfFamilyParentId() {
    return headOfFamilyParentId;
  }

  public void setHeadOfFamilyParentId(String headOfFamilyParentId) {
    this.headOfFamilyParentId = headOfFamilyParentId;
  }

  public String getFamilyName() {
    return familyName;
  }

  public void setFamilyName(String familyName) {
    this.familyName = familyName;
  }

}
