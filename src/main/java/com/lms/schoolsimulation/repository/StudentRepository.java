package com.lms.schoolsimulation.repository;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

import com.lms.schoolsimulation.model.Student;

public interface StudentRepository extends CrudRepository<Student, ObjectId> {

}
