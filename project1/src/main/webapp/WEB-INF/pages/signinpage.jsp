<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="links.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>sign in </title>
</head>
<body background="resources/images/i.jpg" >
<nav class="navbar navbar-inverse">
<div class ="container-fluid">
<div class ="navbar-header">
<a class="navbar-brand" href="#">site name</a>
</div>
<ul class="nav navbar-nav">
   <li class="active"><a href="home">home</a></li>
   <li><a href="reqForsigninpage">signin</a></li>
   <li><a href="reqForSignupPage">signup</a></li>
   <li><a href="#">contact us</a></li>
   <li><a href="#">about us</a></li>
</ul>
</div>
</nav>
<div align="center">
<table>
<tr>Login
<br>
${message}
<br>
<form:form commandName="userObj" action="reqLoginCheck">
<table>
<tr>Enter User ID <form:input path="userid" style="background-color:transparent"/></tr>
<br><br>

<tr>Enter password <form:password path="password" style="background-color:transparent"/></tr>
<br><br>
</table>
<form:button>Login</form:button>
</tr>
</div>

</form:form>
</body>
</html>