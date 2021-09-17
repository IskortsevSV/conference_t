package com.example.conference.persistence.dao.repository.interfaces;

import com.example.conference.persistence.model.Schedule;

import java.util.List;

/**
 * by Iskortsev S.V.
 */


public interface SchedulesRepository {
    List<Schedule> findAll();

    void saveSchedule(Schedule schedule);

    Schedule getSchedule(int id);

    void deleteSchedule(int id);
}
