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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ehealth.dao.DoctorDao;
import com.ehealth.model.AdminLogin;
import com.ehealth.model.Doctor;

@Controller
public class AdminController 
{
	private ApplicationContext con;
//----------------------------------------Admin Login-------------------------------------------
/*	@RequestMapping("/alogin")
	public String alogin(Model m)
	{
		con = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		AdminLogin obj = con.getBean("admininfo", AdminLogin.class);
		m.addAttribute("bean", obj);
		return "adminjsp/alogin";
	}	
	
	@RequestMapping(value = "/aloginpage", method = RequestMethod.POST)
	public String aloginpage(@ModelAttribute("bean") AdminLogin al, Model m)
	{
		con = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		AdminDao dao = con.getBean("adao", AdminDao.class);
		dao.adminLogin(al);
		if (false) 
		{
			return "adminjsp/adminHomepage";
		} 
		else 
		{	
			m.addAttribute("msg", "Invalid credentials.Try Again...");
			return "adminjsp/aloginpage";
		}
	}  */
	
	@RequestMapping("/alogin")
	public ModelAndView alogin() {
		return new ModelAndView("adminjsp/alogin", "command", new AdminLogin());
	}
 
	@RequestMapping(value = "/aloginpage", method = RequestMethod.POST)
	public ModelAndView processLogin(@ModelAttribute("login") AdminLogin al) {
 
		String username = al.getUsername();
		String password = al.getPassword();
 
		if ("admin".equalsIgnoreCase(username) && "admin".equalsIgnoreCase(password)) {
			ModelAndView mv = new ModelAndView("adminjsp/adminHomepage");
			return mv;
		} else {
			ModelAndView mv = new ModelAndView("adminjsp/error");
			return mv;
		}
 
	}
//----------------------------------------Add Doctor-------------------------------------------
	@RequestMapping("/addDoctor")
	public String view2(Model m )
	{
		con = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Doctor doc = con.getBean("info", Doctor.class);
		m.addAttribute("bean", doc);
		return "adminjsp/addDoctor";
	}
		

	@RequestMapping("/store")
	public String view3(@ModelAttribute("bean") Doctor d, Model m)
	{
		con = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		DoctorDao obj = con.getBean("dao", DoctorDao.class);
		obj.saveData(d);
		m.addAttribute("msg", "Doctor added successfully..."+"<br/>"+"Doctor Id is :"+d.getDoctorid()+"<br/>"+"Doctor password is :"+d.getPassword());
		return "adminjsp/addDoctor";
	}

//----------------------------------------View Doctors-------------------------------------------
	@RequestMapping("/viewDoctor")
	public String view4(Model m, HttpServletRequest request)
	{
		con=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		DoctorDao obj=con.getBean("dao",DoctorDao.class);
		List list=obj.displayData();
		if(!list.isEmpty())
		{
			m.addAttribute("data",list);
		}
		else
		{
			m.addAttribute("msg","OOPs! data not found");
		}
		//m.addAttribute("data",list);
		return "adminjsp/viewDoctor";
	}
	//----------------------------------------Search Doctors-------------------------------------------
	@RequestMapping("/searchDoctor")
	public String searchDoctor(Model m)
	{
		con=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Doctor p=con.getBean("info",Doctor.class);
		m.addAttribute("bean",p);
		return "adminjsp/searchDoctor";
	}

	@RequestMapping("/search")
	public String search(@ModelAttribute("bean") Doctor p,Model m)
	{
		con=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		DoctorDao obj=con.getBean("dao",DoctorDao.class);
		List list=obj.searchData(p);
		if(!list.isEmpty())
		{
			m.addAttribute("li",list);
		}
		else
		{
			m.addAttribute("msg","oops record not found");
		}
		return "adminjsp/searchDoctor";
	}
	//----------------------------------------Update Doctors-------------------------------------------
	@RequestMapping("/update")
	public String update(@ModelAttribute("bean")Doctor p,Model m)
	{
		con=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		DoctorDao obj=con.getBean("dao",DoctorDao.class);
		obj.updateData(p);
		m.addAttribute("msg","record updated successffully");
		return "adminjsp/searchDoctor";
	}
//---------------------------------------------Delete Doctors-------------------------------------------
	@RequestMapping("/delete")
	public String view7(@ModelAttribute("bean" )Doctor p,Model m)
	{
		con=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		DoctorDao obj=con.getBean("dao",DoctorDao.class);
		obj.deleteData(p);
		m.addAttribute("msg","Record deleted successfully....");
		return "adminjsp/searchDoctor";
	}

	@RequestMapping("/alogout")
	public String plogout(HttpServletRequest request)
	{
		HttpSession session = request.getSession(false);
		AdminLogin obj = (AdminLogin)session.getAttribute("login");
		if(session != null)
		{
			session.invalidate();
		}
		return "redirect:index.jsp";
	}
}
