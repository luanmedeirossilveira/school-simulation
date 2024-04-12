package com.lms.schoolsimulation.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document
public class Activity {
  @Id
  private String id;
  private String title;
  private String statement;
  
  @CreatedDate
  private Date createDate;

  @LastModifiedDate
  private Date updateDate;

  @DBRef
  private List<Grade> grades;
}
