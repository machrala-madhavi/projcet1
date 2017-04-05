<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="links.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Edit XPS
<form:form action="reqEditXpsToDb" commandName="xpsObj" enctype="multipart/form-data"  method="POST">

<br><form:hidden path="psid"/>
<br>Product ID:<form:input path="productid" readonly="true"/>
<br>Price:<form:input path="productsupplierprice"/>
<br>Stock:<form:input path="productsupplierstock"/>
<br>Supplier ID:<form:input path="supplierid" readonly="true"/>
<br>Is Available:<form:input path="isproductsupplieravailable"/>

<br><form:button>Edit XPS</form:button>
</form:form>
</body>
</html>