package com.dynastymasra.spring.domain;

import com.dynastymasra.core.domain.Base;
import com.dynastymasra.spring.domain.enums.Gender;
import com.dynastymasra.spring.json.JsonDateDeserializer;
import com.dynastymasra.spring.json.JsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

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
@Table(name = "sc_mahasiswa")
public class Mahasiswa extends Base<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mahasiswa_id")
    private Integer id;
    @Column(name = "mahasiswa_nim", nullable = false, length = 30)
    private String nim;
    @Column(name = "mahasiswa_name", nullable = false, length = 255)
    private String name;
    @Column(name = "mahasiswa_email", nullable = false, length = 50)
    private String email;
    @Column(name = "mahasiswa_number", nullable = false, length = 20)
    private String phone;
    @Column(name = "mahasiswa_sex", nullable = false)
    private Gender gender;
    @Column(name = "mahasiswa_birth")
    @Temporal(value = TemporalType.DATE)
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Mahasiswa{" +
                "id=" + id +
                ", nim='" + nim + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", gender=" + gender +
                ", date=" + date +
                '}';
    }
}
