package com.example.conference.persistence.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * by Iskortsev S.V.
 */

@Data
@Entity
@Table(name = "talks")
public class Talk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "report")
    private String report;
    @Column(name = "speaker")
    private Long speaker;

/*    @OneToMany(cascade = {CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE}
            ,mappedBy = "talks") // это связь ищи в классе department
    private List<Schedule> scheduleList;*/

    @Transient
    private String speakerName;



    public Talk() {
    }


    public Talk(long id,String report, String speakerName) {
        this.id = id;
        this.report = report;
        this.speakerName = speakerName;
    }
}

