<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact List - Spring Boot Web Application Example</title>
</head>
<body>
<form action="saveUser" method="post">
			<table style="with: 50%">
				<tr>
					<td>First Name</td>
					<td><input type="text" name="firstname" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lastname" /></td>
				</tr>
				<tr>
					<td>UserName</td>
					<td><input type="text" name="username" /></td>
				</tr>
					<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" name="address" /></td>
				</tr>
				<tr>
					<td>Contact No</td>
					<td><input type="text" name="contactNo" /></td>
				</tr></table>
			<input type="submit" value="Submit" /></form>
</body>
</html>