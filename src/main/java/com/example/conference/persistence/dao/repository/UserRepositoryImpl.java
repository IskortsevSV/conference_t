package com.example.conference.persistence.dao.repository;

import com.example.conference.persistence.dao.repository.interfaces.UserRepository;
import com.example.conference.persistence.model.Authority;
import com.example.conference.persistence.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * by Iskortsev S.V.
 */

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<User> findAll() {
        Session session = sessionFactory.getCurrentSession();

        Query<User> query = session.createQuery("FROM User", User.class);

        return query.list();
    }

    @Override
    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }

    @Override
    public User getUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Override
    public void deleteUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("delete from User where id =:userId");
        query.setParameter("userId", id);
        query.executeUpdate();
    }

    @Override
    public void saveAuthority(Authority authority) {
        Session session = sessionFactory.getCurrentSession();
        System.out.println("-->" + authority);
        session.saveOrUpdate(authority);
    }


}
