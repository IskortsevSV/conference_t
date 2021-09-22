package com.example.conference.persistence.dao.service;

import com.example.conference.persistence.dao.repository.interfaces.TalkRepository;
import com.example.conference.persistence.dao.service.intefaces.TalkService;
import com.example.conference.persistence.model.Talk;
import com.example.conference.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * by Iskortsev S.V.
 */

@Service
public class TalkServiceImpl implements TalkService {

    @Autowired
    TalkRepository talkRepository;

    @Override
    @Transactional
    public List<Talk> findAll() {
        return talkRepository.findAll();
    }

    @Override
    @Transactional
    public void saveTalk(Talk talk) {
        talkRepository.saveTalk(talk);
    }

    @Override
    @Transactional
    public Talk getTalk(long id) {
        return talkRepository.getTalk(id);
    }

    @Override
    @Transactional
    public void deleteTalk(long id) {
        talkRepository.deleteTalk(id);
    }

    @Override
    @Transactional
    public void updateSpeakerToNull(long id) {
        talkRepository.updateSpeakerToNull(id);
    }
}
