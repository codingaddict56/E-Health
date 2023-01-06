package com.ehealth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Doctor 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "doctorid", length = 5)
	private int doctorid;
	@Column(name="doctorname", length = 20)
	private String doctorname;
	@Column(name="category", length = 20)
	private String category;
	@Column(name="email", length = 20)
	private String email;
	@Column(name="phno", length = 10)
	private long phno;
	@Column(name="password", length = 10)
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getDoctorid() {
		return doctorid;
	}
	public void setDoctorid(int doctorid) {
		this.doctorid = doctorid;
	}
	public String getDoctorname() {
		return doctorname;
	}
	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhno() {
		return phno;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}
	public Doctor(int doctorid, String doctorname, String category, String email, long phno, String password) {
		super();
		this.doctorid = doctorid;
		this.doctorname = doctorname;
		this.category = category;
		this.email = email;
		this.phno = phno;
		this.password = password;
	}
	public Doctor() {
		super();
	}
	@Override
	public String toString() {
		return "Doctor [doctorid=" + doctorid + ", doctorname=" + doctorname + ", category=" + category + ", email="
				+ email + ", phno=" + phno + ", password=" + password + "]";
	}	
	
}
