package com.fetch.fbapp3.resources; 
 
import java.io.FileOutputStream; 
import java.io.IOException; 
import java.io.InputStream; 
import java.io.PrintWriter; 
import java.util.Scanner; 

import javax.servlet.RequestDispatcher; 
import javax.servlet.ServletException; 
import javax.servlet.annotation.MultipartConfig; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpSession; 
import javax.servlet.http.Part; 

import com.fetch.fbapp3.model.User;

import java.sql.*; 
@WebServlet(name="UploadServlet", urlPatterns={"webapi1/upload"})     // specify urlPattern for servlet 
@MultipartConfig                                               // specifies servlet takes multipart/form-data 
public class UploadServlet extends HttpServlet { 
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException { 
        response.setContentType("text/html;charset=UTF-8"); 
        PrintWriter out = response.getWriter(); 
        System.out.println("i am right here");
        User u = new User();
        Cookie[] cookies = request.getCookies();
        String email=null;
        for (int i = 0; i < cookies.length; i++) {
          String name = cookies[i].getName();
          	if(name.equals("emailID"))
          		email=cookies[i].getValue();
        }	
        System.out.println("valur fetched from cookie"+email);
        try { 
            // get access to file that is uploaded from client 
            Part p1 = request.getPart("file"); 
            InputStream is = p1.getInputStream(); 
             
              // read filename from stream 
 
            
            Class.forName("com.mysql.jdbc.Driver"); 
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/facebook_database","root","diksha1994"); 
             
          
             
            PreparedStatement ps=con.prepareStatement("select userID from user where email=? "); 
             ps.setString(1,email); 
           
            ResultSet result=ps.executeQuery();      
            if (result != null) {
				while (result.next()) {
					 System.out.println("successful");
						u.setUserID(result.getInt(1));
						System.out.println(u.getUserID());
						
					}
            }
					else{
						System.out.println("Not found");
					}
				
			
             
              
             con.close();    
          
               
       
 
 
               
               
              // get filename to use on the server 
              java.io.File f=new java.io.File(this.getServletContext().getRealPath("/fbapp3/src/main/webapp/images/")); 
                f.mkdir(); 
              String outputfile = this.getServletContext().getRealPath("/images/"+u.getUserID()+".jpg"); 
            System.out.println("OUTPUT>>>>"+outputfile);   
            //String outputfile=""; 
               FileOutputStream os = new FileOutputStream (outputfile); 
             
            // write bytes taken from uploaded file to target file 
            int ch = is.read(); 
            while (ch != -1) { 
                 os.write(ch); 
                 ch = is.read(); 
            } 
            os.close(); 
             
           
             
             
            //out.println("<h3>File uploaded successfully!</h3>"); 
        } 
        catch(Exception ex) { 
           out.println("Exception -->" + ex.getMessage()); 
        } 
        finally {  
            out.close(); 
        } 
    } // end of doPost() 
    }
// end of UploadServlet 