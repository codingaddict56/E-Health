<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="./pbase.jsp" %>
</head>
<body>
	<div class="container mt-5" text-center>
		<h3 class="text-center">Registration Form</h3>
		
		<form action="processform" method="post">

			<div class="form-group">
				<label for="name">Full Name</label> <input type="text"
					class="form-control" id="name" aria-describedby="emailHelp"
					placeholder="Enter Full Name" name="userName">
			</div>


			<div class="form-group">
				<label for="mobile">Mobile No</label> <input 
					class="form-control" id="mobile" aria-describedby="emailHelp"
					placeholder="Enter mobile no" name="mobile">
			</div>


			<div class="form-group">
				<label for="exampleInputEmail1">Email address</label> <input
					type="email" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" placeholder="Enter email" name="email">
			</div>

			<div class="form-group">
				<label for="exampleInputPassword1"> Password</label> <input type="password"
					class="form-control" id="exampleInputPassword1" aria-describedby="emailHelp"
					placeholder="Enter Password" name="password" required>
			</div>
	<center>
				<button type="submit" class="btn-btm-success">Register</button>&nbsp; &nbsp;
				
	</center>		
		</form>
	</div>
	<br />
		<h2>${msg}</h2>
</body>
</html>