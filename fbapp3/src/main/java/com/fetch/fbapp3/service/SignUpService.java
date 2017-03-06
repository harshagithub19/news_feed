package com.fetch.fbapp3.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.fetch.fbapp3.model.User;

public class SignUpService {

	public boolean addUserService(User u1)
	{
		Statement stmt = null;
        try 
        {
            DBAccess connect = new DBAccess();
            boolean check=false;
            while(check==false)
            {
            	check=connect.start();
            	System.out.println("trying connection");
            }
        	String query = "insert into user(email,password) values (?,?)";
           
            PreparedStatement ps = connect.con.prepareStatement(query);
            //ResultSet rs = stmt.getGeneratedKeys();
            
            //ps.setInt(1,110);
           
			ps.setString(1,u1.getEmailID());
			ps.setString(2,u1.getPassword());
            ps.executeUpdate();
            
            check=connect.stop();
            return true;
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
        return false;
    }//method ends here
	public boolean UpdateUserService(User u1)
	{
		Statement stmt = null;
        try 
        {
        	  DBAccess connect = new DBAccess();
              boolean check=false;
              while(check==false)
              {
              	check=connect.start();
              	System.out.println("trying connection in update");
              }
              System.out.println("here="+u1.getDob());
            String query = "UPDATE user SET name=?,town=?,dob=? where email = ?";
           
            PreparedStatement ps = connect.con.prepareStatement(query);
            //ResultSet rs = stmt.getGeneratedKeys();
            
            //ps.setInt(1,110);
           
			ps.setString(1,u1.getName());
			
			ps.setString(2,u1.getTown());
			
			ps.setString(3, u1.getDate());
			
			ps.setString(4, u1.getEmailID());
			
			ps.executeUpdate();
			check=connect.stop();
            return true;
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
        return false;
    }//method ends here

	
	
}//class ends here
