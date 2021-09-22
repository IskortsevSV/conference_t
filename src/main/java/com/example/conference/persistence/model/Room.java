package com.example.conference.persistence.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

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
    private long id;

    @Column(name = "audience")
    private String audience;

    @OneToMany(cascade = {CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE}
            ,mappedBy = "rooms") // это связь ищи в классе department
    private List<Schedule> scheduleList;

    public Room() {
    }

    public Room(String audience) {
        this.audience = audience;
    }
}
