<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="./base.jsp"%>
<%@ include file="./adminHomepage.jsp"%>
<meta charset="ISO-8859-1">
<title>View Doctors</title>
</head>
<body>
	<center>
		<h1>Doctor Records</h1>
		<table border="2" width="100%">
			<tr>
				<th>Doctor Id</th>
				<th>Doctor Name</th>
				<th>Category</th>
				<th>Email</th>
				<th>Phone Number</th>
				<th>Password</th>

			</tr>

			<c:forEach var="tab" items="${data}">

				<tr>
					<td>${tab.doctorid }</td>
					<td>${tab.doctorname  }</td>
					<td>${tab.category  }</td>
					<td>${tab.email }</td>
					<td>${tab.phno }</td>
					<td>${tab.password }</td>
				</tr>
			</c:forEach>
		</table>
		<br />

		<h2>${msg}</h2>
	</center>

</body>
</html>