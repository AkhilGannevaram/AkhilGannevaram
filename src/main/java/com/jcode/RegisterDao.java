package com.jcode;

import java.sql.*;
public class RegisterDao {

	public static int save(String id,String name,String email,String password,String gender,String dob,String addressLine,String city,String state,String country,String contact){
		int status=0;
		java.sql.Date sqlDOB=Formatter.getSqlDate(dob);
		try{
			Connection con=ConProvider.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into company_mailer_user(id,name,email,password,gender,dob,addressLine,city,state,country,contact,registereddate,authorized) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,id);
			ps.setString(2,name);
			ps.setString(3,email);
			ps.setString(4,password);
			ps.setString(5,gender);
			ps.setDate(6,sqlDOB);
			ps.setString(7,addressLine);
			ps.setString(8,city);
			ps.setString(9,state);
			ps.setString(10,country);
			ps.setString(11,contact);
			ps.setDate(12,Formatter.getCurrentDate());
			ps.setString(13,"yes");
			
			status=ps.executeUpdate();
						
		}catch(Exception e){System.out.println(e);}
		
		
		
		return status;
	}
}
