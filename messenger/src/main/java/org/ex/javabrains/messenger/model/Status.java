package org.ex.javabrains.messenger.model;

import java.util.Date;

public class Status {
	 private String statusID;
	   private String status_desc;
	   private Date created;
	   private String author_id;
	  
	private int flag;
	   public Status(){
		   
	   }
	   public Status(String statusID,String status_desc,String author_id){
		   this.statusID=statusID;
		   this.status_desc=status_desc;
		   this.author_id=author_id;
		   created=new Date();
		   flag=1;
		   }
	
	public String getStatusID() {
		return statusID;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public void setStatusID(String statusID) {
		this.statusID = statusID;
	}
	public String getStatus_desc() {
		return status_desc;
	}
	public void setStatus_desc(String status_desc) {
		this.status_desc = status_desc;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(String author_id) {
		this.author_id = author_id;
	}
}
