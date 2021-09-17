package com.example.conference.controllers;

import com.example.conference.persistence.dao.service.intefaces.SchedulesService;
import com.example.conference.persistence.dao.service.intefaces.TalkService;
import com.example.conference.persistence.model.Schedule;
import com.example.conference.persistence.model.Talk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * by Iskortsev S.V.
 */

@Controller
@RequestMapping("/speaker")
public class SpeakerController {

    @Autowired
    TalkService talkService;

    @Autowired
    SchedulesService schedulesService;

    @RequestMapping(value = "/all")
    public String getAllTalksAndSchedules(Model model) {
        List<Talk> talks = talkService.findAll();
        model.addAttribute("talks", talks);
        List<Schedule> schedules = schedulesService.findAll();
        model.addAttribute("schedules", schedules);
        return "talks-list";
    }

    @RequestMapping("/add")
    public String addUser(Model model) {
        Talk talk = new Talk();
        model.addAttribute("talk", talk);
        return "talk-update";
    }

    @RequestMapping("/updateTalk")
    public String updateTalk(@RequestParam("talkId") int id, Model model) {
        Talk talk = talkService.getTalk(id);
        model.addAttribute("talk", talk);
        return "talk-update";
    }

    @RequestMapping("/deleteTalk")
    public String deleteTalk(@RequestParam("talkId") int id) {
        talkService.deleteTalk(id);
        return "redirect:/speaker/all";
    }

    @RequestMapping(value = "/saveTalk")
    public String saveTalk(@ModelAttribute("talk") Talk talk) {
/*        User user = (User) request.getSession().getAttribute("user");
        talk.setSpeaker(user.getId());*/
        talkService.saveTalk(talk);
        return "redirect:/speaker/all";
    }

    @RequestMapping("/updateSchedule")
    public String updateSchedule(@RequestParam("scheduleId") int id, Model model) {
        Schedule schedule = schedulesService.getSchedule(id);
        model.addAttribute("schedule", schedule);
        return "schedule-update";
    }

/*    @RequestMapping("/deleteSchedule")
    public String deleteSchedule(@RequestParam("scheduleId") int id) {
        schedulesService.deleteSchedule(id);
        return "redirect:/speaker/all";
    }*/

    @RequestMapping(value = "/saveSchedule", method = RequestMethod.POST)
    public String saveSchedule(@ModelAttribute("schedule") Schedule schedule) {
       schedulesService.saveSchedule(schedule);
        return "redirect:/speaker/all";
    }



}
