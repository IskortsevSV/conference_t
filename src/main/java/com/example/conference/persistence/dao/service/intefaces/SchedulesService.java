package com.example.conference.persistence.dao.service.intefaces;

import com.example.conference.persistence.model.Schedule;

import java.util.List;

/**
 * by Iskortsev S.V.
 */

public interface SchedulesService {

    List<Schedule> findAll();

    void saveSchedule(Schedule schedule);

    Schedule getSchedule(long id);

    void deleteSchedule(long id);

    List<Schedule> getAll();

}
