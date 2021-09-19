package com.example.conference.persistence.dao.service;

import com.example.conference.persistence.dao.repository.interfaces.SchedulesRepository;
import com.example.conference.persistence.dao.service.intefaces.SchedulesService;
import com.example.conference.persistence.model.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * by Iskortsev S.V.
 */

@Service
public class ScheduleServiceImpl implements SchedulesService {

    @Autowired
    SchedulesRepository repository;

    @Override
    @Transactional
    public List<Schedule> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void saveSchedule(Schedule schedule) {
        repository.saveSchedule(schedule);
    }

    @Override
    @Transactional
    public Schedule getSchedule(long id) {
        return repository.getSchedule(id);
    }

    @Override
    @Transactional
    public void deleteSchedule(long id) {
        repository.deleteSchedule(id);
    }

    @Override
    @Transactional
    public List<Schedule> getAll() {
        return repository.getAll();
    }


}
