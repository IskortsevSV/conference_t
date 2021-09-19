package com.example.conference.persistence.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Data
@Entity
@Table(name = "authorities")
public class Authority {

  @Id
  @Column(name = "id")
  private long id;
  @Column(name = "username")
  private String username;
  @Column(name = "authority")
  private String authority;

 /* @OneToOne(cascade = CascadeType.ALL) // тип отношения один к одному , cascade - связь со связанными Entity
  @JoinColumn(name = "authority_id")
  private User user;*/


  public Authority() {
  }
}