package com.example.conference.utils;

import com.example.conference.persistence.dao.service.intefaces.SchedulesService;
import com.example.conference.persistence.model.Schedule;

import java.util.List;

/**
 * by Iskortsev S.V.
 */

public class OneTimeUtil {

    public static boolean doNotEqualsOneTime(Schedule schedule, SchedulesService schedulesService) {
        List<Schedule> allSchedules = schedulesService.getAll();
        String checkDateTime = schedule.getDateTimeStart();
        long checkAudience = schedule.getAudience();
        boolean result = false;

        for (Schedule allSchedule : allSchedules) {
            String dateTimeStart = allSchedule.getDateTimeStart();
            long audience = allSchedule.getAudience();
            if (dateTimeStart.equals(checkDateTime) && audience == checkAudience) {
                result = true;
            }
        }
        return result;
    }

}
