<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="links.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="resources/images/x.jpg" width="50%">

Edit Product
<form:form action="reqEditProductToDb" commandName="productObj" enctype="multipart/form-data" method="POST">

<br>Product Id :<form:hidden path="productid"/>
<br>Product Name : <form:input path="productname"/>
<br>Product Des :<form:input path="productdes"/>
<br>
<br>
Is Available  :   
True <form:radiobutton path="isproductavailable" value="true" />         
False<form:radiobutton path="isproductavailable" value="false" />

<br>
Select Image : <form:input type="file" path="imagefile"/>
<br>
<form:button>Edit Product</form:button>

</form:form>
</body>
</html>