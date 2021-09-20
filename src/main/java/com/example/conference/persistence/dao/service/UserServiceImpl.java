package com.example.conference.persistence.dao.service;

import com.example.conference.persistence.dao.repository.interfaces.UserRepository;
import com.example.conference.persistence.dao.service.intefaces.UserService;
import com.example.conference.persistence.model.Authority;
import com.example.conference.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * by Iskortsev S.V.
 */


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userRepository.saveUser(user);
    }

    @Override
    @Transactional
    public User getUser(long id) {
        return   userRepository.getUser(id);
    }
    @Override
    @Transactional
    public User getUserByName(String name) {
        return   userRepository.getUserByName(name);
    }

    @Override
    @Transactional
    public void deleteUser(long id) {
        userRepository.deleteUser(id);
    }

    @Override
    @Transactional
    public void saveAuthority(Authority authority) {
        userRepository.saveAuthority(authority);
    }
}
