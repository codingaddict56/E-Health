package com.ehealth.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ehealth.dao.DoctorDao;
import com.ehealth.dao.PatientDao;
import com.ehealth.model.Doctor;
import com.ehealth.model.DoctorLogin;
import com.ehealth.model.PatientRegistration;

@Controller
public class DoctorController 
{
	private ApplicationContext con;
	
	@RequestMapping("/dlogin")
	public String dlogin(Model m)
	{
		con = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Doctor obj = con.getBean("info", Doctor.class);
		m.addAttribute("bean", obj);
		return "doctorjsp/doctorlogin";
	}
	
	@RequestMapping("/dloginpage")
	public String dloginpage(@ModelAttribute("bean") Doctor doc, HttpServletRequest request, Model m)
	{
		con = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		DoctorDao obj = con.getBean("dao", DoctorDao.class);
		boolean flag = obj.doctorLogin(doc);
		if(flag)
		{
			DoctorLogin dl = con.getBean("doctorinfo", DoctorLogin.class);
			dl.setDoctorid(doc.getDoctorid());
			dl.setPassword(doc.getPassword());
			dl.setFlag(1);
			HttpSession session = request.getSession();
			session.setAttribute("data", dl);
			return "doctorjsp/doctorHomepage";
		}
		else
		{
			m.addAttribute("msg", "invalid credentials.Try Again!!!");
			return "doctorjsp/doctorlogin";
		}
	}	
//-----------------------------------------------Doctor views Appointments--------------------------------------------------------
	
	@RequestMapping("/viewappoint")
	public String viewAppoint(Model m)
	{
		con=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		PatientDao obj=con.getBean("pdao",PatientDao.class);
		List list=obj.displayAppointments();
		if(!list.isEmpty())
		{
			m.addAttribute("information",list);
		}
		else
		{
			m.addAttribute("msg","OOPs! data not found");
		}
		return "doctorjsp/viewappointments";
	}
//-----------------------------------------------Add Description--------------------------------------------------------
	
	@RequestMapping("/description")
	public String description(Model m)
	{
		con = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		PatientRegistration obj = con.getBean("prinfo", PatientRegistration.class);
		m.addAttribute("bean", obj);
		return "doctorjsp/addDescription";
	}
	
	@RequestMapping("/psearch")
	public String psearch(@ModelAttribute("bean") PatientRegistration p,Model m)
	{
		con=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		PatientDao obj=con.getBean("pdao",PatientDao.class);
		List list=obj.searchPatientData(p);
		if(!list.isEmpty())
		{
			m.addAttribute("li",list);
		}
		else
		{
			m.addAttribute("msg","oops record not found");
		}
		return "doctorjsp/addDescription";
	}
	@RequestMapping("/addupdate")
	public String addupdate(@ModelAttribute("bean") PatientRegistration p, Model m)
	{
		con=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		PatientDao obj=con.getBean("pdao",PatientDao.class);
		obj.updateAddDescription(p);
		m.addAttribute("msg","record submited successfully");
		return "doctorjsp/addDescription";
	}
//-----------------------------------------------Doctor Logout----------------------------------------------------------
	@RequestMapping("/dlogout")
	public String dlogout(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		DoctorLogin obj = (DoctorLogin)session.getAttribute("data");
		obj.setFlag(0);
		return "redirect:index.jsp";
	}
}
