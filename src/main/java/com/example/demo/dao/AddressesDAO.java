package com.example.demo.dao;

import com.example.demo.model.Address;

import com.example.demo.model.Person2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.object.UpdatableSqlQuery;
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

    public List<Address> listPerson(int id){

        Object[] args={id};
        String sql1="select * from PERSONS where PERSON_ID = "+args[0];
        List<Person2> a=jdbcTemplate.query(sql1, BeanPropertyRowMapper.newInstance(Person2.class));
        Person2 person=a.get(0);
        int value=person.getADDRESS_ID();
        Object[] args2={value};
        String sql="select * from ADDRESSES where ADDRESS_ID = "+args2[0];
        List<Address> listAddress=jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Address.class));

        return listAddress;

    }
    public List<Person2> listPerson2(int id){

        Object[] args={id};
        String sql1="select * from PERSONS where ADDRESS_ID = "+args[0];
        List<Person2> a=jdbcTemplate.query(sql1, BeanPropertyRowMapper.newInstance(Person2.class));


        return a;

    }

    public void save(Address address){

        SimpleJdbcInsert insertActor=new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("ADDRESSES").usingColumns("STREET","APT_NUMBER","CODE","CITY");


        BeanPropertySqlParameterSource param =new BeanPropertySqlParameterSource(address);
        insertActor.execute(param);

    }
    public List<Person2> listAddressId(int id){

        Object[] args={id};
        String sql1="select * from ADDRESSES where ADDRESS_ID = "+args[0];
        List<Person2> a=jdbcTemplate.query(sql1, BeanPropertyRowMapper.newInstance(Person2.class));


        return a;

    }


    public Address get(int id){
    Object[] args={id};
    String sql="SELECT * FROM ADDRESSES WHERE ADDRESS_ID = "+args[0];
    Address address =jdbcTemplate.queryForObject(sql,BeanPropertyRowMapper.newInstance(Address.class));

        return address;
    }

    public void update(Address address){
        String sql = "UPDATE ADDRESSES SET STREET=:STREET, APT_NUMBER=:APT_NUMBER, CODE=:CODE, CITY=:CITY WHERE ADDRESS_ID=:ADDRESS_ID";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(address);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql,param);

    }

    public void delete(int id){
        String sql= "DELETE FROM ADDRESSES WHERE ADDRESS_ID = ?";
        jdbcTemplate.update(sql,id);

    }





}
