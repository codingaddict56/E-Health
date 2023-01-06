package com.ehealth.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class PatientRegistration {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String userName;
	private long mobile;
	private String email; 
	private String password;
	private String treatment;
	private String addPrescription;
	private String medicalTest;
	private String availableSlot;
	private String category;
	private String date;
	private String doctorName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTreatment() {
		return treatment;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	public String getAddPrescription() {
		return addPrescription;
	}
	public void setAddPrescription(String addPrescription) {
		this.addPrescription = addPrescription;
	}
	public String getMedicalTest() {
		return medicalTest;
	}
	public void setMedicalTest(String medicalTest) {
		this.medicalTest = medicalTest;
	}
	
	public String getAvailableSlot() {
		return availableSlot;
	}
	public void setAvailableSlot(String availableSlot) {
		this.availableSlot = availableSlot;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	
	public PatientRegistration() {
		super();
	}
	
	public PatientRegistration(int id, String userName, long mobile, String email, String password, 
			String treatment, String addPrescription, String medicalTest, String availableSlot, String category,
			String date, String doctorName) {
		super();
		this.id = id;
		this.userName = userName;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
		this.treatment = treatment;
		this.addPrescription = addPrescription;
		this.medicalTest = medicalTest;
		this.availableSlot = availableSlot;
		this.category = category;
		this.date = date;
		this.doctorName = doctorName;
	}
	@Override
	public String toString() {
		return "PatientRegistration [id=" + id + ", userName=" + userName + ", mobile=" + mobile + ", email=" + email
				+ ", password=" + password + ", cpassword=" + ", treatment=" + treatment
				+ ", addPrescription=" + addPrescription + ", medicalTest=" + medicalTest + ", availableSlot="
				+ availableSlot + ", category=" + category + ", date=" + date + ", doctorName=" + doctorName + "]";
	}
	
}
