package com.ehealth.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.ehealth.model.Payment;

public class PaymentDao {
	private Configuration conn;
	private SessionFactory factory;
	private Session session;
	private Transaction t;
	

	public void saveData(Payment c) {

		conn = new Configuration().configure("hibernate.cfg.xml");
		factory = conn.buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();
		session.save(c);
		t.commit();
	}
		
}