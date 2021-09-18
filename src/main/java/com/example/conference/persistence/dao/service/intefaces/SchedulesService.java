package com.example.conference.persistence.dao.service.intefaces;

import com.example.conference.persistence.model.Schedule;
import com.example.conference.persistence.model.Talk;
import com.example.conference.persistence.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * by Iskortsev S.V.
 */

public interface SchedulesService {

    List<Schedule> findAll();

    void saveSchedule(Schedule schedule);

    public Schedule getSchedule(int id);

    public void deleteSchedule(int id);

    public List<Schedule> getAll();

}
