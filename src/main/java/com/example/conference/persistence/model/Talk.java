package com.example.conference.persistence.model;

import lombok.Data;
import net.bytebuddy.implementation.bind.annotation.Empty;
import org.hibernate.annotations.SQLDelete;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.*;

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
    private int id;
    @Column(name = "report")
    private String report;

    @Column(name = "speaker")
    private Integer speaker;

    @Transient
    private String speakerName;

    public Talk() {
    }


    public Talk(int id,String report, String speakerName) {
        this.id = id;
        this.report = report;
        this.speakerName = speakerName;
    }
}

