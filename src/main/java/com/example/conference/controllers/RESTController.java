package com.example.conference.controllers;

import com.example.conference.persistence.dao.service.intefaces.SchedulesService;
import com.example.conference.persistence.model.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * by Iskortsev S.V.
 */
@RestController
public class RESTController {

    @Autowired
    SchedulesService schedulesService;

    @GetMapping("/schedules")
    public List<Schedule> showAllEmployees() {
        List<Schedule> allSchedules = schedulesService.findAll();
        return allSchedules;
    }




}
