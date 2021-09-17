package com.example.conference.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

/**
 * by Iskortsev S.V.
 */

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource);

    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").hasAnyRole("ADMIN", "SPEAKER", "LISTENER")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/").hasRole("LISTENER")
                .antMatchers("/speaker/**").hasRole("SPEAKER")
                .and().formLogin().permitAll(); // форма логина и пароля будет запрашиватся у всех

       // .antMatchers("/manager_info/**").hasRole("MANAGER");
    }
}