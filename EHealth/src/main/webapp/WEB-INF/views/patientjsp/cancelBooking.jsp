<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="./pbase.jsp" %>
<%@ include file="patientHomepage.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cancel Booking</title>
</head>
<body>
	<center>
<h1>Cancel Booking </h1>
</br>
</br>
  <h1>Search Record</h1>
  <form:form action="dsearch" method="post" modelAttribute="bean">
  Enter  id:<form:input path="id"/>&nbsp;
  <input type="submit" value="Search">
  
  </form:form>
  
  <table border="1" width="80%">
  <tr>
      <th> Patient id</th>
      <th> Category</th>
      <th>Doctor name </th>
       <th>Date </th>
       <th>Time Slot </th>
  <th>Delete</th>
   
  </tr>
  <c:forEach var="tab" items="${li }">
  <tr>
  
 
 <td>${tab.id }</td>
  <td>${tab.category }</td>
  <td>${tab.doctorName }</td>
  <td>${tab.date }</td>
  <td>${tab.availableSlot }</td>

  <td align="center"><form method="post"  action="deleteBooking" modelAttribute="bean">
  <input type="hidden" value="${tab.id }" name="id">
  <input type="submit" value="Delete">
  
  </form></td>
  </tr>
  </c:forEach>
  </table>
  <h2>${msg} </h2>
</center>
</body>
</html>