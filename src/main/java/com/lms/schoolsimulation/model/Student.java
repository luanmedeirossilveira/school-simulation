package com.lms.schoolsimulation.model;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document
public class Student {
  
  @Id
  private String id;

  @Indexed(unique = true)
  private String name;

  @Indexed(unique = true)
  private String cpf;

  private String telephone;
  private String email;

  @CreatedDate
  private Date createDate;

  @LastModifiedDate
  private Date updateDate;

}
