package com.example.demo.dao;

import com.example.demo.model.Address;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UsersDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UsersDao(JdbcTemplate jdbcTemplate){
        super();
        this.jdbcTemplate=jdbcTemplate;
    }


    public List<User> list(){
        String sql="select * from USERS";
        List<User> listUser=jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(User.class));

        return listUser;

    }

    public int getPERSON_ID(String username){
        Object[] args={username};
        System.out.println(username);
        String sql="SELECT * FROM USERS WHERE USERNAME = '"+args[0]+"'";
        User user =jdbcTemplate.queryForObject(sql,BeanPropertyRowMapper.newInstance(User.class));
        return user.getPERSON_ID();
    }
}
