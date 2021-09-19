package com.example.conference.persistence.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "authorities")
public class Authority {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long id;
  @Column(name = "username")
  private String username;
  @Column(name = "authority")
  private String authority;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id")
  private User user;


  public Authority() {
  }
}
