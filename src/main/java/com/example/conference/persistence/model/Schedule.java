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
    private int id;
    @Column(name = "audience")
    private int audience;
    @Column(name = "date_time_start")
    private String dateTimeStart;
    @Column(name = "report")
    private int report;

    @Transient
    private String audienceName;
    @Transient
    private String reportName;
    @Transient
    private String userName;

    public Schedule() {
    }


    public Schedule(int audience, String dateTimeStart, int report) {
        this.audience = audience;
        this.dateTimeStart = dateTimeStart;
        this.report = report;
    }

    public Schedule(int id,String dateTimeStart, String audienceName, String reportName, String userName) {
        this.id = id;
        this.dateTimeStart = dateTimeStart;
        this.audienceName = audienceName;
        this.reportName = reportName;
        this.userName = userName;
    }
}
