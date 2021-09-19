package com.example.conference.persistence.dao.service.intefaces;

import com.example.conference.persistence.model.Talk;
import com.example.conference.persistence.model.User;

import java.util.List;

/**
 * by Iskortsev S.V.
 */

public interface TalkService {

    List<Talk> findAll();

    void saveTalk(Talk Talk);

    Talk getTalk(long id);

    void deleteTalk(long id);


}
