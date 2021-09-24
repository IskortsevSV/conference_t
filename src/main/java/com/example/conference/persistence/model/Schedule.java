package com.example.conference.persistence.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * by Iskortsev S.V.
 */

@Data
@Entity
@Table(name = "schedules")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "audience")
    private long audience;
    @Column(name = "date_time_start")
    private String dateTimeStart;
    @Column(name = "report")
    private long report;


/*    @ManyToOne(cascade = CascadeType.ALL)
    private Talk talks;

//{CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE}
    @ManyToOne
    private Room rooms;*/

    @Transient
    private String audienceName;
    @Transient
    private String reportName;
    @Transient
    private String userName;

    public Schedule() {
    }


    public Schedule(long audience, String dateTimeStart, long report) {
        this.audience = audience;
        this.dateTimeStart = dateTimeStart;
        this.report = report;
    }

    public Schedule(long id,String dateTimeStart, String audienceName, String reportName, String userName) {
        this.id = id;
        this.dateTimeStart = dateTimeStart;
        this.audienceName = audienceName;
        this.reportName = reportName;
        this.userName = userName;
    }
}
