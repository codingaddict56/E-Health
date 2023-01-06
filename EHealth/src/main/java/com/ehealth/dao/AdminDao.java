package com.ehealth.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ehealth.model.AdminLogin;
import com.ehealth.model.PatientRegistration;

public class AdminDao 
{
	private Configuration conn;
	private SessionFactory factory;
	private Session session;
	private Transaction t;
	
	public boolean adminLogin(AdminLogin al)
	{
		boolean flag = false;
		conn = new Configuration().configure("hibernate.cfg.xml");
		factory = conn.buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();
		List lis = session.createQuery("from AdminLogin").list();
		Iterator it = lis.iterator();
		while(it.hasNext())
		{
			AdminLogin obj = (AdminLogin)it.next();
			if ((al.getUsername().equals("admin")) && (al.getPassword().equals("admin")))
			{
				flag = true;					
			}
		}
		return flag;
	}
}
