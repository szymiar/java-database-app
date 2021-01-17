package com.example.demo.dao;

import com.example.demo.model.Address;
import com.example.demo.model.Animal;
import com.example.demo.model.Person2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

class AnimalsDAOTest {

    private AnimalsDAO animalsDAO;



    @BeforeEach
    void setUP() throws Exception{
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:ORCL1");
        dataSource.setUsername("SYSTEM");
        dataSource.setPassword("1234");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        animalsDAO = new AnimalsDAO(new JdbcTemplate(dataSource));

    }

    @Test
    void list() {
    }

   /* @Test
    void save() {
        Animal animal = new Animal();
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try {
            animal.setDATE_OF_BIRTH(formatter.parse("25-07-2000"));

        } catch (ParseException e) {
            e.printStackTrace();
        }

        animal.setANIMAL_ID(2);
        animal.setNAME("Janek");
        animal.setPERSON_ID(1);
        animal.setRACE("Wiewiorka");
        animal.setSPECIES("k");

        animalsDAO.save(animal);
    }

    @Test
    void get() {
    }

    @Test
    void update() {
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Animal animal = new Animal();
        animal.setANIMAL_ID(1);
        animal.setNAME("Janek");
        animal.setPERSON_ID(1);
        animal.setRACE("Koks");
        animal.setSPECIES("koks");
        try {
            animal.setDATE_OF_BIRTH(formatter.parse("25-07-2000"));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        animalsDAO.update(animal);


    }
*/
    @Test
    void delete() {
        int id=1;
        animalsDAO.delete(id);

    }
}