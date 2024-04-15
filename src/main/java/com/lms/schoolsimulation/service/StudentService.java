package com.lms.schoolsimulation.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.lms.schoolsimulation.model.Student;
import com.lms.schoolsimulation.repository.StudentRepository;

@Service
public class StudentService {

  private StudentRepository studentRepository;
  private final MongoTemplate mongoTemplate;

  @Autowired
  public StudentService(StudentRepository studentRepository, MongoTemplate mongoTemplate) {
    this.studentRepository = studentRepository;
    this.mongoTemplate = mongoTemplate;
  }

  public List<Student> listAll() {
    List<Student> students = new ArrayList<>();
    studentRepository.findAll().forEach(students::add);
    return students;
  }

  public Student create(Student student) {
    Student newStudent = new Student();

    newStudent.setName(student.getName());
    newStudent.setCpf(student.getCpf());
    newStudent.setTelephone(student.getTelephone());
    newStudent.setEmail(student.getEmail());
    newStudent.setCreateDate(new Date());
    newStudent.setUpdateDate(new Date());

    return studentRepository.save(newStudent);
  }

  public Student update(String id, Student student) {
    Query query = new Query(Criteria.where("_id").is(id));
    Student existingStudent = mongoTemplate.findOne(query, Student.class);
    if (existingStudent != null) {
      existingStudent.setName(student.getName());
      existingStudent.setCpf(student.getCpf());
      existingStudent.setTelephone(student.getTelephone());
      existingStudent.setEmail(student.getEmail());
      existingStudent.setUpdateDate(new Date());
      mongoTemplate.save(existingStudent);
    }
    return existingStudent;
  }

  public Student delete(String id) {
    ObjectId _id = new ObjectId(id);
    Student student = studentRepository.findById(_id).get();
    studentRepository.delete(student);
    return student;
  }
}
