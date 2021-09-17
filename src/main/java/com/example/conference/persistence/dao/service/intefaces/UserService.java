package com.example.conference.persistence.dao.service.intefaces;

import com.example.conference.persistence.model.User;

import java.util.List;

/**
 * by Iskortsev S.V.
 */

public interface UserService {

    List<User> findAll();

    void saveUser(User user);

    User getUser(int id);

    void deleteUser(int id);

}
