package com.fetch.fbapp3.model;

import java.util.Date;

public class comment {

	private int commentID;
	private int statusID;
	private int userID;
	
	private int flag;
	private String comment_desc;
	private Date comment_Date;
	
	public comment(int commentID,int statusID,int flag,String comment_desc,String comment_Date,int userID){
		this.commentID=commentID;
		this.statusID=statusID;
		this.flag=flag;
		this.userID=userID;
		this.comment_desc=comment_desc;
		this.comment_Date=new Date();
	}

	public comment() {
		// TODO Auto-generated constructor stub
	}
	public int getCommentID() {
		return commentID;
	}
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}


	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}

	public int getStatusID() {
		return statusID;
	}

	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getComment_desc() {
		return comment_desc;
	}

	public void setComment_desc(String comment_desc) {
		this.comment_desc = comment_desc;
	}

	public Date getComment_Date() {
		return comment_Date;
	}

	public void setComment_Date(Date comment_Date) {
		this.comment_Date = comment_Date;
	}
	
}