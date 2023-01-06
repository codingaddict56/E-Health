<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="./pbase.jsp" %>
<%@ include file="patientHomepage.jsp"%>
<meta charset="ISO-8859-1">
<title>View Doctors</title>
</head>
<body>
<center>
		<h1>Booking Records</h1><br/>
		<form:form action="vsearch" method="post" modelAttribute="bean">
  Enter Patient id:<form:input path="id" />&nbsp;
  <input type="submit" value="Search">
	</form:form>
		<table border="2" width="100%">
			<tr>
				<th>Doctor Name</th>
				<th>Category</th>
				<th>Date</th>
				<th>Time slot</th>
			</tr>

			<c:forEach var="tab" items="${li}">
				<tr>
					<td>${tab.doctorName  }</td>
					<td>${tab.category  }</td>
					<td>${tab.date }</td>
					<td>${tab.availableSlot}</td>
				</tr>
			</c:forEach>
		</table><br/>
		<h2>${msg}</h2>
	</center>

</body>
</html>