package com.example.conference.persistence.dao.service.intefaces;

import com.example.conference.persistence.model.Authority;
import com.example.conference.persistence.model.User;

import java.util.List;

/**
 * by Iskortsev S.V.
 */

public interface UserService {

    List<User> findAll();

    void saveUser(User user);

    User getUser(long id);

    void deleteUser(long id);

    void saveAuthority(Authority authority);

}
