package com.mahi.SpringJDBCdemo.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mahi.SpringJDBCdemo.Model.Alien;

@Repository
public class AlienRepo {
	
	//spring jdbc provide jdbctemplate can run the query
	
	private JdbcTemplate template;
	
	public JdbcTemplate getTemplate() {
		return template;
	}

	//by using autowired annotation it will handle by spring for creating or destroying the objects
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	//insert method
	public void save(Alien obj) {
		//write insert query
		String query="insert into Alien (id,name,tech) values(?,?,?)";
		//for run this query use template.update method
		//this mathod return integer value means how many rows are effected
		
		int rowsAffect=template.update(query, obj.getId(),obj.getName(),obj.getTech());
		System.out.println("No of rows affected "+ rowsAffect);
	}
	
	//select all data
	public List<Alien> findAll(){
		String str="select * from Alien";
		
		//RowMapper collect every obj and add to list;
		RowMapper<Alien> obj=new RowMapper<Alien>() {

			@Override
			public Alien mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Alien a=new Alien();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setTech(rs.getString(3));
				return a;
			}
			
		};
		//return type this method is list
		List<Alien> x=template.query(str, obj);
		return new ArrayList<Alien>(x);
	}
	
	
	//delete query
	public void delete(Alien obj) {
		String str="delete from Alien where id=?";
		template.update(str,obj.getId());
	}
	
}
