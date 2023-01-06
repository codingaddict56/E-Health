package com.ehealth.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ehealth.model.Doctor;

public class DoctorDao 
{
	private Configuration conn;
	private SessionFactory factory;
	private Session session;
	private Transaction t;
	
	public void saveData(Doctor d) 
	{
		conn = new Configuration().configure("hibernate.cfg.xml");
		factory = conn.buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();
		session.save(d);
		t.commit();
	}
	public List displayData()
	{
		conn = new Configuration().configure("hibernate.cfg.xml");
		factory = conn.buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();
		List list= session.createQuery("from Doctor").list();
		
       return list;
	}
	public List searchData(Doctor p) {
		List li=new ArrayList();
		conn = new Configuration().configure("hibernate.cfg.xml");
		factory = conn.buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();
		List list= session.createQuery("from Doctor").list();
		Iterator it=list.iterator();
		while(it.hasNext())
		{
			Doctor pat=(Doctor)it.next();
	if(p.getDoctorid()==pat.getDoctorid())
			{
		Doctor obj=new Doctor ();
	obj.setDoctorid(pat.getDoctorid());
	obj.setDoctorname(pat.getDoctorname());
	obj.setCategory(pat.getCategory());
	obj.setEmail(pat.getEmail());
	obj.setPhno(pat.getPhno());
	obj.setPassword(pat.getPassword());
				
				li.add(obj);
			}
		}
		return li;
	}
	public void updateData(Doctor p) {
		conn = new Configuration().configure("hibernate.cfg.xml");
		factory = conn.buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();
		Doctor obj=session.get(Doctor.class,p.getDoctorid());
		obj.setDoctorname(p.getDoctorname());
		obj.setCategory(p.getCategory());
		
		obj.setEmail(p.getEmail());
		obj.setPhno(p.getPhno());
		obj.setPassword(p.getPassword());
		session.update(obj);
		t.commit();
	}
	public void deleteData(Doctor p) {
		conn = new Configuration().configure("hibernate.cfg.xml");
		factory = conn.buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();
		Doctor obj=session.get(Doctor.class,p.getDoctorid());
		session.delete(obj);
		t.commit();
	}
	public boolean doctorLogin(Doctor doc)
	{
		boolean flag = false;
		conn = new Configuration().configure("hibernate.cfg.xml");
		factory = conn.buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();
		List lst = session.createQuery("from Doctor").list();
		Iterator it = lst.iterator();
		while(it.hasNext())
		{
			Doctor obj = (Doctor)it.next();
			if(obj.getDoctorid()==doc.getDoctorid() && obj.getPassword().equals(doc.getPassword()))
			{
				flag = true;
			}
		}
	return flag;
	}
}
