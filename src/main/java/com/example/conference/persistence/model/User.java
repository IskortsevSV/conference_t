package com.example.conference.persistence.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

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
    private int id;
    @Column(name = "username")
    private String userName;
    @Column(name = "userpassword")
    private String userPassword;
    @Column(name = "authority")
    private String authority;

    public User() {
    }

    public User(String userName, String userPassword, String authority) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.authority = authority;
    }
}
