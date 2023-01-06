<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta chars et=ISO-8859-1">
<title>Patient Login</title>
<style>
	h1{color:mediumblue;}   
</style> 
</head>
<body>
	<center>
		<h1>Patient Login</h1>
		<form:form method="post" action="ploginpage" modelAttribute="bean">
		
		<h3>Enter ID : <form:input path="id" /></h3>
		<h3>Password : <form:password path="password" />
		
		<form:errors path="password" cssClass="error"/><br /><br />
		
		<a href="forgotpassword">Forgot password?</a><br /><br />
		<button type="submit" value="Login">Login</button>&nbsp; &nbsp;
							<button type="reset" value="cancel">cancel</button><br/><br/>

			<a href="register">Register</a>
		</form:form>
		<h5 style="color:red" >${msg }</h5>
	</center>
</body>
</html>