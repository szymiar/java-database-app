package com.example.demo.dao;

import com.example.demo.model.Address;
import com.example.demo.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsersDaoTest {


    private UsersDao usersDao;



    @BeforeEach
    void setUP() throws Exception{
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:ORCL1");
        dataSource.setUsername("SYSTEM");
        dataSource.setPassword("1234");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        usersDao = new UsersDao(new JdbcTemplate(dataSource));

    }
    @Test
    void list() {
        List<User> listAddresses=usersDao.list();

        assertTrue(listAddresses.isEmpty());
    }
    @Test
    void getPersonId(){
        int a=usersDao.getPERSON_ID("user4");
        System.out.println(a);

    }
}