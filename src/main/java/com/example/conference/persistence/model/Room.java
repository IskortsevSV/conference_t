package com.example.conference.persistence.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
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


//(cascade = {CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE}
//            ,mappedBy = "rooms")
 /*   @OneToMany
    private List<Schedule> schedules;*/

    public Room() {
    }

    public Room(String audience) {
        this.audience = audience;
    }

/*    public void addRoomToSchedule(Schedule schedule) {
        if (schedules == null) {
            schedules = new ArrayList<>();
        }
        schedules.add(schedule);
        schedule.setRooms(this); //из-за того что эта Bi-direction связь (когда оба знают друг о друге) добавляем эту связь
    }*/
}
