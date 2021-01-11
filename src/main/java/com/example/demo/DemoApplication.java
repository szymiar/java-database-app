package com.example.demo;

import com.example.demo.model.Address;

import com.example.demo.model.Animal;
import com.example.demo.model.Person;
import com.example.demo.model.Person2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		String sql ="select * from PERSONS";

		//List<Person2> persons =jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Person2.class));

		//System.out.println(persons.get(0).getSURNAME());


	}


}