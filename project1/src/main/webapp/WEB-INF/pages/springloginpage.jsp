<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="links.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>

body { 
    background-size: contain;
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-position: center;
    background-size: 100% 100%;    
}

</style>
</head>
<body background="resources/images/j.jpg">
<form action="<c:url value="/j_spring_security_check"></c:url>" method="post">
${message1}

<br><br>
<div class="container">
<div align="center">
<table>
<br>
<tr><h5 style="color:white"> UserId:<input type="text" name="j_username"/></h5></tr>
<br>
<tr><h5 style="color:white"> Password:<input type="password" name="j_password"/></h5></tr>
<br>
</table>
<input type="submit" value="Login"/><br>
${error}
</div>
</div>
</form>

</body>
</html>