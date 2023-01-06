package com.ehealth.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ehealth.model.Doctor;
import com.ehealth.model.PatientRegistration;

public class PatientDao 
{
	private Configuration conn;
	private SessionFactory factory;
	private Session session;
	private Transaction t;
//--------------------------------------Patient Registration-----------------------------------------
	public void createPatient(PatientRegistration pr)
	{
		conn = new Configuration().configure("hibernate.cfg.xml");
		factory = conn.buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();
		session.save(pr);
		t.commit();
	}
//--------------------------------------Patient Registration success-----------------------------------------
	public List showUser(PatientRegistration pr)
	{
		conn = new Configuration().configure("hibernate.cfg.xml");
		factory = conn.buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();
		List list= session.createQuery("from PatientRegistration").list();
		
       return list;
	}
//--------------------------------------Patient Login-----------------------------------------
	public boolean patientlogin(PatientRegistration pr) 
	{
		boolean flag = false;
		conn = new Configuration().configure("hibernate.cfg.xml");
		factory = conn.buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();
		List lis = session.createQuery("from PatientRegistration").list();
		Iterator it = lis.iterator();
		while(it.hasNext())
		{
			PatientRegistration obj = (PatientRegistration)it.next();
			if(obj.getId()==pr.getId() && obj.getPassword().equals(pr.getPassword()))
			{
				flag = true;			
			}
		}
		return flag;
	}
//----------------------------------------Booking Appointment---------------------------------------------
//--------------------------------------Patient new booking submit-----------------------------------------
	public void updatePatientData(PatientRegistration p) 
	{
			conn = new Configuration().configure("hibernate.cfg.xml");
			factory = conn.buildSessionFactory();
			session = factory.openSession();
			t = session.beginTransaction();
			PatientRegistration obj=session.get(PatientRegistration.class,p.getId());
			
			obj.setId(p.getId());
			obj.setDoctorName(p.getDoctorName());
			obj.setCategory(p.getCategory());
			obj.setDate(p.getDate());
			obj.setAvailableSlot(p.getAvailableSlot());
			
			session.saveOrUpdate(obj);
			t.commit();
		}
//--------------------------------------view Booked Appointments--------------------------------------
//--------------------------------------Patient view booking-----------------------------------------
	public List searchPData(PatientRegistration p) 
	{	
		List li=new ArrayList();
		conn = new Configuration().configure("hibernate.cfg.xml");
		factory = conn.buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();
		List list= session.createQuery("from PatientRegistration").list();
		Iterator it=list.iterator();
		while(it.hasNext())
		{
			PatientRegistration pat=(PatientRegistration)it.next();
	if(p.getId()==pat.getId())
			{
		PatientRegistration obj=new PatientRegistration();
	obj.setId(pat.getId());
	obj.setDoctorName(pat.getDoctorName());
	obj.setCategory(pat.getCategory());
	obj.setDate(pat.getDate());
	obj.setAvailableSlot(pat.getAvailableSlot());
				li.add(obj);
			}
		}
		return li;
	}
	public List displayPatientData(PatientRegistration p) 
	{
		List li=new ArrayList();
		conn = new Configuration().configure("hibernate.cfg.xml");
		factory = conn.buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();
		List list= session.createQuery("from PatientRegistration").list();
		Iterator it=list.iterator();
		while(it.hasNext())
		{
			PatientRegistration pat=(PatientRegistration)it.next();
	if(p.getId()==pat.getId())
			{
		PatientRegistration obj=new PatientRegistration();
	obj.setId(pat.getId());
	obj.setDoctorName(pat.getDoctorName());
	obj.setCategory(pat.getCategory());
	obj.setDate(pat.getDate());
	obj.setAvailableSlot(pat.getAvailableSlot());
				li.add(obj);
			}
		}
		return li;
	}
//------------------------------------------cancel Booking---------------------------------------
	public List searchPatienttocancel(PatientRegistration p) 
	{	
		List li=new ArrayList();
		conn = new Configuration().configure("hibernate.cfg.xml");
		factory = conn.buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();
		List list= session.createQuery("from PatientRegistration").list();
		Iterator it=list.iterator();
		while(it.hasNext())
		{
			PatientRegistration pat=(PatientRegistration)it.next();
	if(p.getId()==pat.getId())
			{
		PatientRegistration obj=new PatientRegistration();
	obj.setId(pat.getId());
	obj.setCategory(pat.getCategory());
	obj.setDoctorName(pat.getDoctorName());
	obj.setDate(pat.getDate());
	obj.setAvailableSlot(pat.getAvailableSlot());
				li.add(obj);
			}
		}
		return li;
	}
	public void cancelBooking(PatientRegistration p) 
	{
		conn = new Configuration().configure("hibernate.cfg.xml");
		factory = conn.buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();
		PatientRegistration obj=session.get(PatientRegistration.class,p.getId());
		session.delete(obj);
		t.commit();
	}
//-----------------------------------Doctor views Appointments----------------------------------
	public List displayAppointments() 
	{
		conn = new Configuration().configure("hibernate.cfg.xml");
		factory = conn.buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();
		List list= session.createQuery("from PatientRegistration").list();
		
       return list;
	}
//-----------------------------------Doctor adds Description----------------------------------------------
	public List searchPatientData(PatientRegistration p) 
	{	
		List li=new ArrayList();
		conn = new Configuration().configure("hibernate.cfg.xml");
		factory = conn.buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();
		List list= session.createQuery("from PatientRegistration").list();
		Iterator it=list.iterator();
		while(it.hasNext())
		{
			PatientRegistration pat=(PatientRegistration)it.next();
	if(p.getId()==pat.getId())
			{
		PatientRegistration obj=new PatientRegistration();
	obj.setId(pat.getId());
	obj.setUserName(pat.getUserName());
	obj.setTreatment(pat.getTreatment());
	obj.setAddPrescription(pat.getAddPrescription());
	obj.setMedicalTest(pat.getMedicalTest());
				li.add(obj);
			}
		}
		return li;
	}
	public void updateAddDescription(PatientRegistration p) 
	{
		conn = new Configuration().configure("hibernate.cfg.xml");
		factory = conn.buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();
		PatientRegistration obj=session.get(PatientRegistration.class,p.getId());
		
		obj.setId(p.getId());
		obj.setUserName(p.getUserName());
		obj.setTreatment(p.getTreatment());
		obj.setAddPrescription(p.getAddPrescription());
		obj.setMedicalTest(p.getMedicalTest());
		
		session.saveOrUpdate(obj);
		t.commit();
	}
}
