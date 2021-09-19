package com.example.conference.persistence.dao.repository;

import com.example.conference.persistence.dao.repository.interfaces.TalkRepository;
import com.example.conference.persistence.model.Talk;
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
public class TalkRepositoryImpl implements TalkRepository {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Talk> findAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Talk> query =
                currentSession.createQuery("SELECT new Talk (t.id,t.report,u.userName) " +
                        " FROM Talk t" +
                        " LEFT JOIN  User u ON (t.speaker=u.id)");
        return query.getResultList();
    }

    @Override
    public void saveTalk(Talk talk) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(talk);
    }

    @Override
    public Talk getTalk(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Talk.class, id);
    }

    @Override
    public void deleteTalk(long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Talk> query = session.createQuery("delete from Talk where id =:talkId");
        query.setParameter("talkId", id);
        query.executeUpdate();
    }
}
