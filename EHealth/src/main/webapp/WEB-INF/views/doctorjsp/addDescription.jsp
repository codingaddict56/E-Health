<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="./dbase.jsp"%>
<%@ include file="doctorHomepage.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>search Record</h1>
		<br />
		<form:form action="psearch" method="post" modelAttribute="bean">
  Enter Patient id:<form:input path="id" />&nbsp;
  <input type="submit" value="Search">
		</form:form>
	
	<c:forEach var="tab" items="${li }">
		<h1>Add Description</h1>
		<br />
		<form:form action="addupdate" method="post" modelAttribute="bean">
	Enter Patient Id : <input type="text" name="id" value="${tab.id }" readonly />
			<br />
			<br />
	Patient Name : <input  id="userName" name="userName" value="${tab.userName}" readonly />
			<br />
			<br />
	Treatment : <input type="text" name="treatment" value="${tab.treatment}" />
			<br />
			<br />
	Add Prescription : <input type="text" name="addPrescription" value="${tab.addPrescription}" />
			<br />
			<br />
	Medical Test : <input type="text" name="medicalTest" value="${tab.medicalTest}" />
			<br />
			<br />
			<input type="submit" value="Check" name="Check">
		</form:form>
		</c:forEach>

		<br />
		<h2>${msg}</h2>

	</center>
</body>
</html>