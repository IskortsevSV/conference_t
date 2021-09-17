package com.example.conference.persistence.dao.repository.interfaces;

/**
 * by Iskortsev S.V.
 */

import com.example.conference.persistence.model.User;


import java.util.List;


public interface UserRepository  {

    List<User> findAll();

    void saveUser(User user);

    User getUser(int id);

    void deleteUser(int id);

}
