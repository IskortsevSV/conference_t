package com.example.conference.controllers;

import com.example.conference.persistence.dao.service.intefaces.SchedulesService;
import com.example.conference.persistence.dao.service.intefaces.UserService;
import com.example.conference.persistence.model.Authority;
import com.example.conference.persistence.model.Schedule;
import com.example.conference.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * by Iskortsev S.V.
 */

@Controller()
public class ListenerController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserService userService;

    @Autowired
    SchedulesService schedulesService;

    @RequestMapping(value = "/")
    public ModelAndView getAllSchedule(ModelAndView modelAndView) {
        List<Schedule> all = schedulesService.findAll();
        modelAndView.addObject("all", all);
        modelAndView.setViewName("main-page");
        return modelAndView;
    }

    @RequestMapping("/registration")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration-page";
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user) {
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        user.setEnabled("1");
        Authority authority = getAuthority(user);
        user.setAuthority(authority);
        userService.saveUser(user);
        return "redirect:/";
    }

    private Authority getAuthority(User user) {
        Authority authority = new Authority();
        authority.setUsername(user.getUserName());
        authority.setAuthority("ROLE_LISTENER");
        return authority;
    }
}
