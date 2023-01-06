<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="./pbase.jsp"%>
<%@ include file="patientHomepage.jsp"%>
<meta charset="ISO-8859-1">
<title>Patient Booking</title>
</head>
<body>
	<center>
		<h1>New Booking</h1>
		<br />
		<form:form action="pupdate" method="post" modelAttribute="bean">
	Enter Patient Id : <form:input path="id" />
			<br />
			<br />
	Enter Category : <form:select path="category" name="Search">
				<form:option value="Dermotologist" label="Dermotologist" />
				<form:option value="Pediatrician" label="Pediatrician" />
				<form:option value="Psychiatrist" label="Psychiatrist" />
				<form:option value="Ophthalmologist" label="Ophthalmologist" />
			</form:select>
			<br />
			<br />
					Doctor Name : <select path="doctorName" name="doctorName">
				<option value="Ramu" label="Ramu" />
				<option value="Krishna" label="Krishna" />
				<option value="Vishnu" label="Vishnu" />
			</select>
			<br />
			<br />
	
	
	Enter Date : <form action="slot">
				<label for="select">Select:</label> <input type="date" id="date"
					name="date" /> <br /> <br /> Available Slot : <select
					path="availableSlot" name="availableSlot">
					<option value="9:00 AM-10:00 AM" label="9:00 AM-10:00AM" />
					<option value="10:00 AM-11:00 AM" label="10:00 AM-11:00 AM" />
					<option value="11:00 AM-12:00 PM" label="11:00 AM-12:00 PM" />
					<option value="2:00 PM-3:00 PM" label="2:00 PM-3:00 PM" />
					<option value="3:00 PM-4:00 PM" label="3:00 PM-4:00 PM" />
					<option value="4:00 PM-5:00 PM" label="4:00 PM-5:00 PM" />
					<option value="5:00 PM-6:00 PM" label="5:00 PM-6:00 PM" />
				</select><br /> <br /> <br /> 
				<input type="submit" value="Check" name="Check">
			</form>
		</form:form>

		<br />
		<h2>${msg}</h2>
	</center>
</body>
</html>