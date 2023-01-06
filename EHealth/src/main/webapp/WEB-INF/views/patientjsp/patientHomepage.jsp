<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="./pbase.jsp" %>
<title>Patient Homepage</title>
</head>
<style type="text/css">
a {
	background-color: #4CAF50;
	border: name;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}
</style>
</head>
<body>
<center><br/>
	<a href = "bookappointment">Book Appointment</a>&nbsp; &nbsp;
	<a href = "viewBooking">View Booking</a>&nbsp; &nbsp;
	<a href = "cancelBooking">Cancel Booking</a>&nbsp; &nbsp;
	<a href="plogout">Logout</a>
</center>
</body>
</html>