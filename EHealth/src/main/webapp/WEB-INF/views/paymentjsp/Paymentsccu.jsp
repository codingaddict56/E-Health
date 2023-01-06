<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment</title>
<style type="text/css">
h3 {
	color: orange;
}
</style>
</head>
<body>
<center>
	<h1 style="color: green">${msg}</h1>
	<h2>Welcome,</h2>
	<h2>Your Appointment ID:</h2>
	<h3>${bean.apid}</h3>
	<h2>Your Name:</h2>
	<h3>${bean.ahname}</h3>
	<h2>Your Paid Fees:</h2>
	<h3>${bean.amount}</h3>
</center>

<center>
<form:form action="patientHomepage" method="get"/>
<a href="patientHomepage">Home</a>
</center>

</body>
</html>