package com.example.conference.controllers;

import com.example.conference.persistence.dao.service.intefaces.TalkService;
import com.example.conference.persistence.dao.service.intefaces.UserService;
import com.example.conference.persistence.model.Authority;
import com.example.conference.persistence.model.User;
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
@Controller()
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    TalkService talkService;

    @RequestMapping(value = "/allUsers")
    public String getAllUsers(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "all-users";
    }

    @RequestMapping("/updateInfo")
    public String updateUser(@RequestParam("userId") int id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "registration-page";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") int id) {
        talkService.updateSpeakerToNull(id);
        userService.deleteUser(id);
        return "redirect:/admin/allUsers";
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user) {
        Authority authority = user.getAuthority();
        authority.setUsername(user.getUserName());
        user.setAuthority(authority);
        userService.saveUser(user);
        return "redirect:/admin/allUsers";
    }


}
