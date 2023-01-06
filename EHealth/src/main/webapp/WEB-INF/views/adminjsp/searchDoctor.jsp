<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file = "./base.jsp"%>
<%@ include file="./adminHomepage.jsp"%>
<meta charset="ISO-8859-1">
<title>Search Doctor page</title>
</head>
<body>
	<center>
		<h1>Search Record</h1>
		<form:form action="search" method="post" modelAttribute="bean">
  Enter Doctor id:<form:input path="doctorid" />&nbsp;
 
  
  <input type="submit" value="Search">
  

		</form:form>

		<table border="2" width="100%">
			<tr>
				<th>Doctor id</th>
				<th>Doctor name</th>
				<th>Category</th>
				<th>Email</th>
				<th>Phone Number</th>
				<th>Password</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
			<c:forEach var="tab" items="${li }">
				<tr>

					<td>
						<form action="update" method="post" modelAttribute="bean">
							<input type="text" value=" ${tab.doctorid }" name="doctorid"
								readonly>
					</td>
					<td><input type="text" value="${tab.doctorname }"
						name="doctorname"></td>
					<td><input type="text" value="${tab.category }"
						name="category"></td>
					<td><input type="text" value="${tab.email }" name="email"></td>
					<td><input type="text" value="${tab.phno }" name="phno"></td>
					<td><input type="text" value="${tab.password }" name="password"></td>
					<td align="center"><input type="submit" value="Update">
						</form></td>

					<td align="center"><form method="post" action="delete"
							modelAttribute="bean">
							<input type="hidden" value="${tab.doctorid }" name="doctorid">
							<input type="submit" value="Delete">
						</form></td>
				</tr>
			</c:forEach>
		</table><br/>
		<h2>${msg}</h2>
	</center>
</body>
</html>