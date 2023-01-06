package com.ehealth.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ehealth.dao.DoctorDao;
import com.ehealth.dao.PatientDao;
import com.ehealth.model.Doctor;
import com.ehealth.model.PatientLogin;
import com.ehealth.model.PatientRegistration;


@Controller
public class PatientController 
{
	private ApplicationContext con;
	
	@RequestMapping("/plogin")
	public String plogin(Model m)
	{
		con = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		PatientRegistration obj = con.getBean("prinfo", PatientRegistration.class);
		m.addAttribute("bean", obj);
		return "patientjsp/patientlogin";
	}
	
	@RequestMapping("/ploginpage")
	public String login(@ModelAttribute("bean") PatientRegistration pr,  HttpServletRequest request,Model m)
	{	
		con = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		PatientDao obj = con.getBean("pdao", PatientDao.class);
		boolean flag = obj.patientlogin(pr);
		if(flag)
		{
			PatientLogin pl = con.getBean("patientinfo", PatientLogin.class);
			pl.setId(pr.getId());
			pl.setPassword(pr.getPassword());
			pl.setFlag(1);
			HttpSession session = request.getSession();
			session.setAttribute("data", pl);
			return "patientjsp/patientHomepage";
		}
		else
		{
			m.addAttribute("msg", "invalid credentials.Try Again!!!");
			return "patientjsp/patientlogin";
		}
	}
	
	@RequestMapping("/register")
	public String view2(Model m)
	{
		con = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		PatientRegistration pr = con.getBean("prinfo", PatientRegistration.class);
		m.addAttribute("bean", pr);
		return "patientjsp/pregistration";
	}

	@RequestMapping(path="/processform",method=RequestMethod.POST)
	public String view3(@ModelAttribute("bean") PatientRegistration pr, Model m)
	{
		con = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		PatientDao obj = con.getBean("pdao", PatientDao.class);
		obj.createPatient(pr);
		m.addAttribute("msg", "Patient Registered successfully,Patient Id is "+pr.getId());
		return "patientjsp/psuccess";
	}
//--------------------------------------------newBooking-------------------------------------------	
	@RequestMapping("/bookappointment")
	public String bookappointment(Model m)
	{
		con=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		PatientRegistration p=con.getBean("prinfo",PatientRegistration.class);
		m.addAttribute("bean",p);
		return "patientjsp/patientbooking";
	}
//--------------------------------------------submit booking -------------------------------------------
	@RequestMapping("/pupdate")
	public String pupdate(@ModelAttribute("bean") PatientRegistration p, Model m)
	{
		con=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		PatientDao obj=con.getBean("pdao",PatientDao.class);
		obj.updatePatientData(p);
		m.addAttribute("msg","record submited successfully");
		return "paymentjsp/payment";
	}
//--------------------------------------------view booking -------------------------------------------
	@RequestMapping("/vsearch")
	public String vsearch(@ModelAttribute("bean") PatientRegistration p,Model m)
	{
		con=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		PatientDao obj=con.getBean("pdao",PatientDao.class);
		List list=obj.searchPData(p);
		if(!list.isEmpty())
		{
			m.addAttribute("li",list);
		}
		else
		{
			m.addAttribute("msg","oops record not found");
		}
		return "patientjsp/viewbookinghistory";
	}
	@RequestMapping("/viewBooking")
	public String viewBooking(@ModelAttribute("bean") PatientRegistration p, Model m)
	{
		con=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		PatientDao obj=con.getBean("pdao",PatientDao.class);
		List list=obj.displayPatientData(p);
		if(!list.isEmpty())
			{
				m.addAttribute("li",list);
			}
			return "patientjsp/viewbookinghistory";
	}
//-----------------------------------------Cancel Booking------------------------------------------
	@RequestMapping("/cancelBooking")
	public String cancelBooking(Model m)
	{
		con = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		PatientRegistration pr = con.getBean("prinfo", PatientRegistration.class);
		m.addAttribute("bean", pr);
		return "patientjsp/cancelBooking";
	}
	
	@RequestMapping("/dsearch")
	public String dsearch(@ModelAttribute("bean") PatientRegistration p,Model m)
	{
		con=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		PatientDao obj=con.getBean("pdao",PatientDao.class);
		List list=obj.searchPatienttocancel(p);
		if(!list.isEmpty())
		{
			m.addAttribute("li",list);
		}
		else
		{
			m.addAttribute("msg","oops record not found");
		}
		return "patientjsp/cancelBooking";
	}
	
	@RequestMapping("/deleteBooking")
	public String deleteBooking(@ModelAttribute("bean" )PatientRegistration p, Model m)
	{
		con=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		PatientDao obj=con.getBean("pdao",PatientDao.class);
		obj.cancelBooking(p);
		m.addAttribute("msg","Booking cancelled successfully....");
		return "patientjsp/cancelBooking";
	}
//----------------------------------------Patient Logout-------------------------------------------	
	@RequestMapping("/plogout")
	public String plogout(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		PatientLogin obj = (PatientLogin)session.getAttribute("data");
		obj.setFlag(0);
		return "redirect:index.jsp";
	}
}
