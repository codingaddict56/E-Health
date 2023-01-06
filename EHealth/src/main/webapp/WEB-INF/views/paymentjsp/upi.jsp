<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment</title>
<style type="text/css">
h2 {
	color: red;
}
</style>
</head>
<body>
	<center>
		<h1>UPI Payment</h1>
		<br />
		<form:form action="storee" method="post" modelAttribute="bean">
	Enter Name : <form:input path="ahname" />
			<br />
			<br />
	Enter UPI ID : <form:input path="upiid" />
			<br />
			<br />
	Appointment Fee:<form:input path="amount" Value="100" />
			<br />
			<br />
			<input type="submit" value="Pay">
		</form:form>
		<br />
		<h2>${msg}</h2>
	</center>
</body>
</html>