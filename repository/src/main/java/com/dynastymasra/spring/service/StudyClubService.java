package com.dynastymasra.spring.service;

import com.dynastymasra.spring.domain.StudyClub;
import com.dynastymasra.spring.repository.StudyClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author   : Dynastymasra
 * Name     : Dimas Ragil T
 * Email    : dynastymasra@gmail.com
 * LinkedIn : http://www.linkedin.com/in/dynastymasra
 * Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
 */

@Service
public class StudyClubService {
    @Autowired
    private StudyClubRepository studyClubRepository;

    @Transactional
    public StudyClub create(StudyClub studyClub) throws Exception {
        return studyClubRepository.save(studyClub);
    }

    @Transactional
    public StudyClub update(Integer id, StudyClub studyClub) throws Exception {
        StudyClub o = studyClubRepository.findOne(id);
        if (o == null) {
        } else {
            o.setDate(studyClub.getDate());
            o.setMahasiswa(studyClub.getMahasiswa());
            o = studyClubRepository.save(o);
        }
        return o;
    }

    @Transactional
    public StudyClub destroy(Integer id) throws Exception {
        StudyClub o = studyClubRepository.findOne(id);
        if (o == null) {
        } else {
            studyClubRepository.delete(o);
        }
        return o;
    }
}
