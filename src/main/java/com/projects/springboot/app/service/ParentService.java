package com.projects.springboot.app.service;

import com.projects.springboot.app.entity.Parent;
import com.projects.springboot.app.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ParentService {

  @Autowired
  ParentRepository parentRepository;

  public Mono<Parent> create(Parent parent) {
    return parentRepository.save(parent);
  }

  public Flux<Parent> findAll() {
    return parentRepository.findAll();
  }

  public Mono<Parent> findById(String id) {
    return parentRepository.findById(id);
  }

  /**
   * This method is created to update a Parent Object by id.
   */
  public Mono<Parent> update(String id, Parent parent) {
    return parentRepository.findById(id).flatMap(updatedParent -> {
      updatedParent.setGender(parent.getGender());
      updatedParent.setFirstName(parent.getFirstName());
      updatedParent.setMiddleName(parent.getMiddleName());
      updatedParent.setLastName(parent.getLastName());
      updatedParent.setOtherParentDetails(parent.getOtherParentDetails());
      return parentRepository.save(updatedParent);
    });

  }

  /**
   * This method is created to delete a Parent Object by id.
   */
  public Mono<Parent> deleteById(String id) {
    return parentRepository.findById(id)
        .flatMap(deletedParent -> parentRepository.delete(deletedParent)
        .then(Mono.just(deletedParent)));
  }
}
