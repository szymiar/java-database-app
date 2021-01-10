package com.example.demo.dao;

import com.example.demo.model.Address;

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
public class AddressesDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AddressesDAO(JdbcTemplate jdbcTemplate){
        super();
        this.jdbcTemplate=jdbcTemplate;
    }


    public List<Address> list(){
        String sql="select * from ADDRESSES";
        List<Address> listAddress=jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Address.class));

        return listAddress;

    }

    public void save(Address address){

        SimpleJdbcInsert insertActor=new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("ADDRESSES").usingColumns("STREET","APT_NUMBER","CODE","CITY");


        BeanPropertySqlParameterSource param =new BeanPropertySqlParameterSource(address);
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
