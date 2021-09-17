package com.example.conference.persistence.dao.repository;

import com.example.conference.persistence.dao.repository.interfaces.SchedulesRepository;
import com.example.conference.persistence.model.Schedule;
import com.example.conference.persistence.model.Talk;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * by Iskortsev S.V.
 */

@Repository
public class SchedulesRepositoryImpl implements SchedulesRepository{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Schedule> findAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Schedule> query =
                currentSession.createQuery("SELECT new Schedule(sch.id,sch.dateTimeStart,r.audience,t.report,u.userName) " +
                        " FROM Schedule sch" +
                        " JOIN Room r ON (sch.audience=r.id)" +
                        " JOIN Talk t ON (sch.report = t.id)" +
                        " JOIN User u ON (t.speaker=u.id) ORDER BY sch.dateTimeStart");
        return query.getResultList();
    }

    @Override
    public void saveSchedule(Schedule schedule) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(schedule);
    }

    @Override
    public Schedule getSchedule(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Schedule.class,id);
    }

    @Override
    public void deleteSchedule(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Schedule> query = session.createQuery("delete from Schedule where id =:scheduleId");
        query.setParameter("scheduleId", id);
        query.executeUpdate();
    }


}
