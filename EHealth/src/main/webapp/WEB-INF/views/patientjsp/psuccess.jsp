<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ page isELIgnored="false" %>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
h3 {
color:orange;
}
</style>
</head>
<body>
<center>
<h1 style="color:green">${msg}</h1>
<h2>Welcome,</h2><h3>${bean.userName}</h3>
<h2>Your Mobile no </h2><h3>${bean.mobile}</h3>
<h2>Your emailId </h2><h3>${bean.email}</h3>
<h2>Your Password is </h2><h3>${bean.password}</h3>


<a href="plogin">Back</a>
</center>
</body>
</html>