package com.ehealth.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ehealth.dao.PaymentDao;
import com.ehealth.model.Payment;

@Controller
public class PaymentController {
	private ApplicationContext con;

	@RequestMapping("/payment")
	public String View1() 
	{
		return "paymentjsp/payment";
	}
	@RequestMapping("/ccard")
	public String view8(Model m1)
	{
		con = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Payment c = con.getBean("pinfo", Payment.class);
		m1.addAttribute("bean", c);
		return "paymentjsp/creditPayment";
	}
	@RequestMapping("/dcard")
	public String view9(Model m1)
	{
		con = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Payment c = con.getBean("pinfo", Payment.class);
		m1.addAttribute("bean", c);
		return "paymentjsp/debitPayment";
	}
	@RequestMapping("/upi")
	public String view7(Model m1)
	{
		con = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Payment c = con.getBean("pinfo", Payment.class);
		m1.addAttribute("bean", c);
		return "paymentjsp/upi";
	}
	@RequestMapping("/net")
	public String view6(Model m1)
	{
		con = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Payment c = con.getBean("pinfo", Payment.class);
		m1.addAttribute("bean", c);
		return "paymentjsp/netBanking";
	}
	@RequestMapping("/storee")
	public String view9(@ModelAttribute("bean") Payment c, Model m1)
	{
		con = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		PaymentDao obj = con.getBean("paydao", PaymentDao.class);
				obj.saveData(c);
				m1.addAttribute("msg", "Payment Successfull...");
				return "paymentjsp/Paymentsccu";
	}
	@RequestMapping("/patientHomepage")
	public String patientHomepage(Model m1)
	{
		return "patientjsp/patientHomepage";
	}
}	