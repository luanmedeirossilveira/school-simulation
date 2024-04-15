package com.lms.schoolsimulation.model;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Student {
  
  @Id
  private ObjectId _id;

  private String name;
  private String cpf;
  private String telephone;
  private String email;

  @CreatedDate
  private Date createDate;

  @LastModifiedDate
  private Date updateDate;
}
