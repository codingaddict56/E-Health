<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="./dbase.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Doctor Login</title>
</head>
<body>
<center>
	<h1>Doctor Login</h1>
	<form:form method="post" action="dloginpage" modelAttribute="bean">
		Enter ID : <form:input path="doctorid" /> <br/><br/>
        Password : <form:password path="password" required /> <br/><br/>
						<input type="submit" value="Login">&nbsp; &nbsp;
						<input type="Reset" value="Cancel">
	</form:form>
<br/><br/>
<h5 style="color:red" >${msg }</h5>
</center>	
</body>
</html>