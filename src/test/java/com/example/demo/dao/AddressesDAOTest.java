package com.example.demo.dao;

import com.example.demo.model.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.DriverManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddressesDAOTest {

    private AddressesDAO addressesDao;



    @BeforeEach
    void setUP() throws Exception{
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:ORCL1");
        dataSource.setUsername("SYSTEM");
        dataSource.setPassword("1234");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        addressesDao = new AddressesDAO(new JdbcTemplate(dataSource));

    }

    @Test
    void list() {
        List<Address> listAddresses=addressesDao.list();
        assertTrue(listAddresses.isEmpty());

    }

    @Test
    void save() {

        Address address = new Address(0,"Chrobrego","4A","05-120","Legionowo");
        addressesDao.save(address);

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