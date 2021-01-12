package com.example.demo.dao;

import com.example.demo.model.Address;
import com.example.demo.model.Person2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class Person2DAO {



    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Person2DAO(){}

    public Person2DAO(JdbcTemplate jdbcTemplate){
        super();
        this.jdbcTemplate=jdbcTemplate;


    }


    public List<Person2> list(){
        String sql="select * from PERSONS";
        List<Person2> listAddress = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Person2.class));

        return listAddress;

    }


    public void save(Person2 person){

        SimpleJdbcInsert insertActor=new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("PERSONS").usingColumns("NAME","SURNAME","BIRTH_DATE","ADDRESS_ID");


        BeanPropertySqlParameterSource param =new BeanPropertySqlParameterSource(person);
        insertActor.execute(param);

    }

    public Address get(int id){

        return null;
    }

    public void update(Address adress){

    }

    public void delete(int id){

    }
}
