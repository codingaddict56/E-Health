package com.ehealth.model;
import  com.ehealth.model.Doctor;
public class DoctorLogin 
{
	private int doctorid;
	private String password;
	private int flag;
	
	public int getDoctorid() {
		return doctorid;
	}
	public void setDoctorid(int doctorid) {
		this.doctorid = doctorid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
}
