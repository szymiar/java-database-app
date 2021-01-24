package com.example.demo.dao;

import com.example.demo.model.Person2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

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

    /*@Test
    void save() {
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date myDate;
        Person2 person = null;
        try {
            person = new Person2(0,"Jan","TTT",formatter.parse("25-07-2000"),1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        person2Dao.save(person);

    }
*/
    @Test
    void get() {
    }

   /* @Test
    void update() {

        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        Person2 person = new Person2();
        try {
            person.setBIRTH_DATE(formatter.parse("25-07-2000"));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        person.setADDRESS_ID(1);
        person.setSURNAME("Kowal");
        person.setNAME("Michal");
        person.setPERSON_ID(1);
        

        person2Dao.update(person);
    }
*/
    @Test
    void delete() {
        int id=2;
        person2Dao.delete(id);
    }

}