package com.example.conference.controllers;

import com.example.conference.configuration.MyConfig;
import com.example.conference.configuration.MySecurityConfig;
import com.example.conference.persistence.model.User;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * by Iskortsev S.V.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyConfig.class, MySecurityConfig.class})
@WebAppConfiguration
@FixMethodOrder
public class ControllerTester {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                .apply(springSecurity())
                .build();
    }

    @Test
    public void testController() throws Exception {
        mockMvc.perform(get("/")).andDo(print()).andExpect(view().name("main-page"));
    }

    @Test
    public void testController2() throws Exception {
        mockMvc.perform(get("/schedules")).andDo(print())
                .andExpect(status().isOk());

    }

    /*integration*/
    @Test
    public void testController3() throws Exception {
        mockMvc.perform(post("/saveUser").flashAttr("user", new User("Tim", "123", "1")))
                .andExpect(view().name("redirect:/"))
                .andDo(print());
    }


    @Test
    public void testController10() throws Exception {
        System.out.println(mockMvc.perform(get("/"))
                .andExpect(status().is2xxSuccessful()).andDo(print())
                .andReturn()
                .getModelAndView().getModel().get("all"));
    }


}
