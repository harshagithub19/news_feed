package com.fetch.fbapp3.service;

import java.sql.PreparedStatement;
import com.fetch.fbapp3.model.comment;

public class AddCommentService {
	DBAccess db= new DBAccess();
	 public boolean addComment(comment c){
	        //String result;
			boolean check=false;
			try{
			  while(check!=true){
				  System.out.println("trying connection in addComment");
				 check= db.start();
			  }
			  String  comment_desc= c.getComment_desc();
			  int sID=c.getStatusID();
			  int uID=c.getUserID();
				 
				 String query = "insert into comments(comment_desc,uID,sID) values(?, ?,?)";
			 
			  PreparedStatement pstmnt=db.con.prepareStatement(query);
				 pstmnt.setString(1, comment_desc);
				 pstmnt.setInt(2, uID);
				 pstmnt.setInt(3, sID);
				 pstmnt.executeUpdate();
				 db.stop();
				 return true;
			  }
			  catch (Exception e) 
		      {
		          System.out.println(e.getMessage());
		      }
			 return false;  
			 
}
}