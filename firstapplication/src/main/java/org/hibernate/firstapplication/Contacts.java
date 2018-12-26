package org.hibernate.firstapplication;

import javax.persistence.*;

@Entity(name="contacts")
@Table
public class Contacts{
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String fname;
    @Column
    private String lname;
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
}
