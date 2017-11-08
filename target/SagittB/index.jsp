<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sagitt Gems Jewelry</title>
</head>
<body>
	<h1>Sagitt Gems Jewelry</h1>
	<ul>
		<li><a href="homePage.html">Home Page</a></li>
	</ul>
	<ul>
		<li><a href="simpleForm.html">Simple Form</a></li>
	</ul>
	<ul>
		<li><a href="validationform.html">Validation Form</a></li>
	</ul>
	<ul>
		<c:url var="loginPage" value="/account/login"></c:url>
		<li><a href="${loginPage }">Login Page</a></li>
	</ul>
	<ul>
		<li><a href="registrationform.html">Registration Form</a></li>
	</ul>
	<ul>
		<li><a href="uploadfileindex.html">File Upload</a></li>
	</ul>
</body>
</html>