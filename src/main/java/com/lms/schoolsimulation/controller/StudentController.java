package com.lms.schoolsimulation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.schoolsimulation.model.Student;
import com.lms.schoolsimulation.service.StudentService;

@RestController
@RequestMapping(value = "/api/students")
public class StudentController {
  
  @Autowired
  private StudentService studentService;

  @GetMapping
  public List<Student> listAll() {
    return studentService.listAll();
  }

  @PostMapping
  public Student create(@RequestBody Student student) {
    return studentService.create(student);
  }

  @PutMapping(value = "/{id}")
  public Student update(@PathVariable("id") String id, @RequestBody Student student) {
    return studentService.update(id, student);
  }

  @DeleteMapping(value = "/{id}")
  public Student delete(@PathVariable("id") String id) {
    return studentService.delete(id);
  }
}
