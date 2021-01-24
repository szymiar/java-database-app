package com.example.demo.dao;

import com.example.demo.model.Address;

import com.example.demo.model.Animal;
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

    public List<Animal> listPerson(int id){
        Object[] args={id};
        String sql="select * from ANIMALS where PERSON_ID = "+args[0];
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
        Object[] args={id};
        String sql="SELECT * FROM ANIMALS WHERE ANIMAL_ID = "+args[0];
        Animal animal =jdbcTemplate.queryForObject(sql,BeanPropertyRowMapper.newInstance(Animal.class));
        return animal;


    }

    public void update(Animal animal){
        String sql = "UPDATE ANIMALS SET NAME=:NAME, SPECIES=:SPECIES, RACE=:RACE, DATE_OF_BIRTH=:DATE_OF_BIRTH WHERE ANIMAL_ID=:ANIMAL_ID";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(animal);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql,param);
    }

    public void delete(int id){

        String sql= "DELETE FROM ANIMALS WHERE ANIMAL_ID = ?";
        jdbcTemplate.update(sql,id);

    }





}
