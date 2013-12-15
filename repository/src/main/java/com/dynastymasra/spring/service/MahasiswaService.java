package com.dynastymasra.spring.service;

import com.dynastymasra.spring.domain.Mahasiswa;
import com.dynastymasra.spring.repository.MahasiswaRepository;
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
public class MahasiswaService {
    @Autowired
    private MahasiswaRepository mahasiswaRepository;

    @Transactional
    public Mahasiswa create(Mahasiswa mahasiswa) throws Exception {
        return mahasiswaRepository.save(mahasiswa);
    }

    @Transactional
    public Mahasiswa update(Integer id, Mahasiswa mahasiswa) throws Exception {
        Mahasiswa o = mahasiswaRepository.findOne(id);
        if (o == null) {
        } else {
            o.setDate(mahasiswa.getDate());
            o.setNim(mahasiswa.getNim());
            o.setGender(mahasiswa.getGender());
            o.setPhone(mahasiswa.getPhone());
            o.setEmail(mahasiswa.getEmail());
            o.setName(mahasiswa.getName());
            o = mahasiswaRepository.save(o);
        }
        return o;
    }

    @Transactional
    public Mahasiswa destroy(Integer id) throws Exception {
        Mahasiswa o = mahasiswaRepository.findOne(id);
        if (o == null) {
        } else {
            mahasiswaRepository.delete(o);
        }
        return o;
    }
}
