package com.projects.springboot.app.controllers;

import com.projects.springboot.app.config.exception.NotFoundException;
import com.projects.springboot.app.entity.Student;
import com.projects.springboot.app.service.StudentService;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
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
@RequestMapping("/api/students")
public class StudentController {

  @Autowired
  StudentService studentService;

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Service to create a student", notes = "Save the student's information")
  public Mono<Student> postStudent(@Valid @RequestBody Student student) {
    return studentService.create(student);
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Service to get all students", notes = "Get all students's information")
  public Flux<Student> getStudents() {
    return studentService.findAll();
  }

  @GetMapping(path = "/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Service to get a student", notes = "Get the student's information")
  public Mono<Student> getStudentById(@PathVariable String studentId) {
    return studentService.findById(studentId)
        .switchIfEmpty(Mono.error(new NotFoundException("Not found student by id " + studentId)));
  }

  @PutMapping(path = "/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Service to update a student", notes = "Update the student's information")
  public Mono<Student> updateStudent(@PathVariable String studentId, @RequestBody Student student) {
    return studentService.findById(studentId)
        .flatMap(findedStudent -> studentService.update(findedStudent,student))
        .switchIfEmpty(Mono.error(new NotFoundException("Not found student by id " + studentId)));
  }

  @DeleteMapping(path = "/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Service to delete a student", notes = "Delete the student's information")
  public Mono<Void> deleteStudent(@PathVariable String studentId) {
    return studentService.deleteById(studentId);
  }

}
