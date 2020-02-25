package com.projects.springboot.app.controllers;

import com.projects.springboot.app.entity.FamilyMember;
import com.projects.springboot.app.service.FamilyMemberService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/familyMembers")
public class FamilyMemberController {

  @Autowired
  FamilyMemberService familyMemberService;

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Service to create a family member", 
                notes = "Save the family member's information")
  public Mono<FamilyMember> postFamilyMember(@RequestBody FamilyMember familyMember) {
    return familyMemberService.create(familyMember);
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Service to get all family member", 
                notes = "Get all family members's information")
  public Flux<FamilyMember> getFamilyMembers() {
    return familyMemberService.findAll();
  }

  @GetMapping(path = "/{familyMemberId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Service to get a family Member", 
                notes = "Get the family member's information")
  public Mono<FamilyMember> getFamilyById(@PathVariable String familyMemberId) {
    return familyMemberService.findById(familyMemberId);
  }

  @PutMapping(path = "/{familyMemberId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Service to update a family member", 
                notes = "Update the family member's information")
  public Mono<FamilyMember> updateFamilyMember(@PathVariable String familyMemberId, 
                                         @RequestBody FamilyMember familyMember) {
    return familyMemberService.update(familyMemberId, familyMember);
  }

  /**
   * This controller is created to delete a FamilyMember Object by id.
   */
  @DeleteMapping(path = "/{familyMemberId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Service to delete a family member", 
                notes = "Delete the family member's information")
  public Mono<ResponseEntity<Void>> deleteFamilyMember(@PathVariable String familyMemberId) {
    return familyMemberService.deleteById(familyMemberId)
        .map(r -> ResponseEntity.ok().<Void>build())
        .defaultIfEmpty(ResponseEntity.notFound().build());
  }
  
}
