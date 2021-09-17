package com.example.conference.persistence.dao.repository.interfaces;

import com.example.conference.persistence.model.Talk;

import java.util.List;


public interface TalkRepository {

    List<Talk> findAll();

    void saveTalk(Talk talk);

    Talk getTalk(int id);

    void deleteTalk(int id);

}
