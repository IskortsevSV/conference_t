package com.example.conference.utils;

import com.example.conference.persistence.dao.service.intefaces.SchedulesService;
import com.example.conference.persistence.model.Schedule;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.List;

/**
 * by Iskortsev S.V.
 */

public class OneTimeUtil {

    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final long HOUR = 3600000L;

    public static boolean checkBothEqualsTimeAndAudience(Schedule schedule, SchedulesService schedulesService) {
        List<Schedule> allSchedules = schedulesService.getAll();
        String checkDateTime = schedule.getDateTimeStart();
        long checkAudience = schedule.getAudience();


        try {
            Date checkDate = SDF.parse(checkDateTime);
            long a = checkDate.getTime();

            for (Schedule allSchedule : allSchedules) {
                String dateTime = allSchedule.getDateTimeStart();
                long b = SDF.parse(dateTime).getTime();
                long audience = allSchedule.getAudience();
                long range = Math.abs(a - b);
                if (range <= HOUR && audience == checkAudience) {
                    return true;
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return false;
    }


}
