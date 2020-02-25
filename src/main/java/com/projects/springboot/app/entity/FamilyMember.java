package com.projects.springboot.app.entity;

import javax.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "familymembers")
public class FamilyMember {

  @Id
  private String familyMemberId;

  @NotEmpty
  private String familyId;

  @NotEmpty
  private String parentOrStudentMember;

  @NotEmpty
  private String parentId;

  @NotEmpty
  private String studentId;

  /**
   * This is the default constructor method without id.
   */
  public FamilyMember(@NotEmpty String familyId, @NotEmpty String parentOrStudentMember, 
      @NotEmpty String parentId,@NotEmpty String studentId) {
    super();
    this.familyId = familyId;
    this.parentOrStudentMember = parentOrStudentMember;
    this.parentId = parentId;
    this.studentId = studentId;
  }

  public String getFamilyMemberId() {
    return familyMemberId;
  }

  public void setFamilyMemberId(String familyMemberId) {
    this.familyMemberId = familyMemberId;
  }

  public String getFamilyId() {
    return familyId;
  }

  public void setFamilyId(String familyId) {
    this.familyId = familyId;
  }

  public String getParentOrStudentMember() {
    return parentOrStudentMember;
  }

  public void setParentOrStudentMember(String parentOrStudentMember) {
    this.parentOrStudentMember = parentOrStudentMember;
  }

  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId;
  }

  public String getStudentId() {
    return studentId;
  }

  public void setStudentId(String studentId) {
    this.studentId = studentId;
  }
}
