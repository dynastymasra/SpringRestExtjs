package com.dynastymasra.spring.domain;

import com.dynastymasra.core.domain.Base;
import com.dynastymasra.spring.json.JsonDateDeserializer;
import com.dynastymasra.spring.json.JsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.data.domain.Page;

import javax.persistence.*;
import java.util.Date;

/**
 * Author   : Dynastymasra
 * Name     : Dimas Ragil T
 * Email    : dynastymasra@gmail.com
 * LinkedIn : http://www.linkedin.com/in/dynastymasra
 * Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
 */

@Entity
@Table(name = "sc_jsc")
public class StudyClub extends Base<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "jsc_id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "mahasiswa_id", nullable = false)
    private Mahasiswa mahasiswa;
    @Column(name = "jsc_join_date")
    @Temporal(value = TemporalType.DATE)
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Mahasiswa getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
    }

    @Override
    public String toString() {
        return "StudyClub{" +
                "id=" + id +
                ", mahasiswa=" + mahasiswa +
                ", date=" + date +
                '}';
    }
}
