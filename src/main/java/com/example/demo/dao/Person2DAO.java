package com.example.demo.dao;

import com.example.demo.model.Address;
import com.example.demo.model.Person2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class Person2DAO {



    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Person2DAO(JdbcTemplate jdbcTemplate){
        super();
        this.jdbcTemplate=jdbcTemplate;


    }


    public List<Person2> list(){
        String sql="select * from PERSONS";
        List<Person2> listPerson = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Person2.class));

        return listPerson;

    }

    public List<Person2> listPerson(int id){

        Object[] args={id};
        String sql1="select * from PERSONS where PERSON_ID = "+args[0];
        List<Person2> listPerson=jdbcTemplate.query(sql1, BeanPropertyRowMapper.newInstance(Person2.class));
        return listPerson;
    }

    public List<Person2> listAddress(int id){
        Object[] args={id};
        String sql="select * from PERSONS where ADDRESS_ID = "+args[0];
        List<Person2> listPerson = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Person2.class));

        return listPerson;

    }

    public void save(Person2 person){

        SimpleJdbcInsert insertActor=new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("PERSONS").usingColumns("NAME","SURNAME","BIRTH_DATE","ADDRESS_ID");


        BeanPropertySqlParameterSource param =new BeanPropertySqlParameterSource(person);
        insertActor.execute(param);

    }

    public Person2 get(int id){
        Object[] args={id};
        String sql="SELECT * FROM PERSONS WHERE PERSON_ID = "+args[0];
        Person2 person =jdbcTemplate.queryForObject(sql,BeanPropertyRowMapper.newInstance(Person2.class));
        return person;
    }

    public void update(Person2 person){
        String sql = "UPDATE PERSONS SET NAME=:NAME, SURNAME=:SURNAME, BIRTH_DATE=:BIRTH_DATE, ADDRESS_ID=:ADDRESS_ID WHERE PERSON_ID=:PERSON_ID";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(person);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql,param);
    }

    public void delete(int id){
        String sql= "DELETE FROM PERSONS WHERE PERSON_ID = ?";
        jdbcTemplate.update(sql,id);

    }
}
