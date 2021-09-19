package com.example.conference.persistence.model;

import lombok.Data;

import javax.persistence.*;

/**
 * by Iskortsev S.V.
 */

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "username")
    private String userName;
    @Column(name = "password")
    private String userPassword;
    @Column(name = "enabled")
    private String enabled;

    // @OneToOne(mappedBy = "user", cascade = {CascadeType.ALL})
    @Transient
    private Authority authority;



    public User() {
    }

    public User(String userName, String userPassword, String enabled) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.enabled = enabled;
    }
}
