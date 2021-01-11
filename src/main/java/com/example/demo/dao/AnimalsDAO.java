package com.example.demo.dao;

import com.example.demo.model.Address;

import com.example.demo.model.Animal;
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
public class AnimalsDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AnimalsDAO(JdbcTemplate jdbcTemplate){
        super();
        this.jdbcTemplate=jdbcTemplate;
    }


    public List<Animal> list(){
        String sql="select * from ANIMALS";
        List<Animal> listAnimal=jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Animal.class));

        return listAnimal;

    }

    public void save(Animal animal){

        SimpleJdbcInsert insertActor=new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("ANIMALS").usingColumns("NAME","SPECIES","RACE","DATE_OF_BIRTH","PERSON_ID");


        BeanPropertySqlParameterSource param =new BeanPropertySqlParameterSource(animal);
        insertActor.execute(param);

    }

    public Animal get(int id){

        return null;
    }

    public void update(Animal animal){

    }

    public void delete(int id){

    }





}
