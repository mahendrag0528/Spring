package com.mahi.SpringJDBCdemo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mahi.SpringJDBCdemo.Model.Alien;
import com.mahi.SpringJDBCdemo.Repository.AlienRepo;

@SpringBootApplication
public class SpringJdbCdemoApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(SpringJdbCdemoApplication.class, args);
		
		Alien obj1=context.getBean(Alien.class);
		
		obj1.setId(1);
		obj1.setName("mahi");
		obj1.setTech("java");
		
		AlienRepo repo=context.getBean(AlienRepo.class);
		
		repo.save(obj1);
		
		List<Alien> x=repo.findAll();
		
		System.out.println(x);
		
		//delete obj1
		repo.delete(obj1);
		
		List<Alien> y=repo.findAll();
		System.out.println(y);
	}
}
