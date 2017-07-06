package model;

import java.sql.Date;

/**
 * Clase POJO (Plain Old Java Object) https://en.wikipedia.org/wiki/Plain_old_Java_object
 * Ideally speaking, a POJO is a Java object not bound by any restriction other than those 
 * 	forced by the Java Language Specification; i.e. a POJO should not have to:
 * 1.Extend prespecified classes, as in
 * 2.Implement prespecified interfaces
 * 3.Contain prespecified annotations
 * @author alumne
 *
 */

public class Comments extends Table{

	private int id;
	
	private String myUser;
	private String email;
	private String webpage;
	private Date datum;
	private String summary;
	private String comments;
	
	public Comments(){
		id = -1;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getMyUser() {
		return myUser;
	}
	
	public void setMyUser(String myUser) {
		this.myUser = myUser;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getWebpage() {
		return webpage;
	}
	
	public void setWebpage(String webpage) {
		this.webpage = webpage;
	}
	
	public Date getDatum() {
		return datum;
	}
	
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	
	public String getSummary() {
		return summary;
	}
	
	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getComments() {
		return comments;
	}
	
	public void setComments(String comments) {
		this.comments = comments;
	}
		
	
}
