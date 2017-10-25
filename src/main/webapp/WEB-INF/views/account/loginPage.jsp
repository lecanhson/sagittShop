<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng nhập</title>
</head>
<body>
	<h3>Đăng nhập</h3>
	<form:form action="/account/process-login" commandName="userSA" method="POST">
		<table>
			<tr>
				<td>Username:</td>
				<td><form:input path="user" id="user"/> </td>
			</tr>
			<tr>
				<td>Passoword:</td>
				<td><form:password path="password" id="password"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Login" /></td>    
			</tr>
		</table>
	</form:form>
</body>
</html>