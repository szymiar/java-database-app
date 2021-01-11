package com.example.demo.dao;

import com.example.demo.model.Address;
import com.example.demo.model.Person;
import com.example.demo.model.Person2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Person2DAOTest {


    private Person2DAO person2Dao;



    @BeforeEach
    void setUP() throws Exception{
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:ORCL1");
        dataSource.setUsername("SYSTEM");
        dataSource.setPassword("1234");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        person2Dao = new Person2DAO(new JdbcTemplate(dataSource));

    }

    @Test
    void list() {
        List<Person2> listPersons=person2Dao.list();
        assertTrue(listPersons.isEmpty());

    }

    @Test
    void save() {
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date myDate;
        Person2 person = null;
        try {
            person = new Person2(0,"Jan","Koks",formatter.parse("25-07-2000"),1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        person2Dao.save(person);

    }

    @Test
    void get() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

}