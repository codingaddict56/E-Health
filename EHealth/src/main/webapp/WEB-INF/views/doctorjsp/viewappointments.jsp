<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="./dbase.jsp" %>
<%@ include file="doctorHomepage.jsp" %>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>View Appointments</h1>
<table border="2" width="100%">
<tr>
<th>Patient Id</th>
<th>Patient Name</th>
<th>Date</th>
<th>Slot</th>

</tr>

  <c:forEach var="tab" items="${information}">

<tr>
<td>${tab.id }</td>
<td>${tab.userName }</td>
<td>${tab.date }</td>
<td>${tab.availableSlot } </td>
</tr>
</c:forEach>
</table>
<br/>

<h2 >${msg}</h2>
</center>

</body>
</html>