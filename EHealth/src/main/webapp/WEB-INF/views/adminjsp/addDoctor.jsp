<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.ehealth.model.Doctor"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="./base.jsp" %>
<%@ include file="adminHomepage.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Doctor Page</title>
</head>
<body>
	<center>
		<h1>Add Doctor</h1>
		<form:form action="store" method="post" modelAttribute="bean">
		Enter Name : <form:input path="doctorname" /><br /><br />
		Category : <form:select path="category" name="Search" >
				<form:option value="Dermotologist" label="Dermotologist" />
				<form:option value="Pediatrician" label="Pediatrician" />
				<form:option value="Psychiatrist" label="Psychiatrist" />
				<form:option value="Ophthalmologist" label="Ophthalmologist" />
			</form:select><br /><br />
		Enter E-mail : <form:input path="email"/><br /><br />
		Enter PH.No : <form:input path="phno"/><br /><br />
		Enter password : <form:password path="password" /><br /><br />
		
			<input type="submit" value="Add"><br/>
			
		</form:form>
		<h2>${msg}</h2>
	</center>
</body>
</html>
