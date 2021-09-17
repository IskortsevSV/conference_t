package com.example.conference.persistence.model;

import lombok.Data;

import javax.persistence.*;

/**
 * by Iskortsev S.V.
 */
@Data
@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "audience")
    private String audience;

    public Room() {
    }

    public Room(String audience) {
        this.audience = audience;
    }
}
