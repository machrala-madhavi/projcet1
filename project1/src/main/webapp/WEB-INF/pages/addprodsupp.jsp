<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="links.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADD PRODUCTS</title>
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
<body background="resources/images/v.jpg"  width: 100%; height: 150px>
<%@ include file="adminnavbar.jsp" %>
<!--  <nav class="navbar navbar-inverse">
  <div class="container">
   
    <ul class="nav navbar-nav">

      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Welcome Admin..<span class="caret"></span></a>
	     <ul class="dropdown-menu">
          <li><a href="#">Edit Profile</a></li>
          <li><a href="#">Change Password</a></li>
          <li><a href="home">Logout</a></li>
        </ul>
      </li>  
     
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Products<span class="caret"></span></a>
	     <ul class="dropdown-menu">
          <li><a href="reqdisplaysupplieradmin">Display All products</a></li>
          <li><a href="reqaddsupplier">Add Product</a></li>          
        </ul>
      </li>  
     
     <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Suppliers<span class="caret"></span></a>
	     <ul class="dropdown-menu">
          <li><a href="reqdisplayproductadmin">Display All suppliers</a></li>
          <li><a href="reqproduct">Add Supplier</a></li>          
        </ul>
      </li>  
     
          <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">ProductSupplier<span class="caret"></span></a>
	     <ul class="dropdown-menu">
          <li><a href="reqdisplayXps">Display All ProductSuppliers</a></li>
          <li><a href="reqaddprodsuppForm">Add ProductSupplier</a></li>          
        </ul>
      </li>  
     
     
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="reqForSignupPage">About Us</a></li>
      <li><a href="reqForSigninPage">  Contact Us</a></li>
    </ul>
  </div>
</nav>-->
<br><br><br><br><br>
<form:form commandName="prodsuppObject" action="reqaddprodsuppDataToDb">
<form:hidden path="psid"/>
<div class="container" align="center">
 <h3>ADD PRODUCT SUPPLIER </h3>

<div class="form-group">
	 <label class="control-label col-sm-2" b style="color:DarkMagenta">Product </label>
      <div class="col-sm-6">
        <form:select path="productid" >
        <c:forEach var="prd" items="${products}">
<option value="${prd.productid}"> ${prd.productname}</option>
</c:forEach>
         </form:select>
      </div>
    </div>
    <br><br>
<!-- Product 
<form:select path="productid">
<c:forEach var="prd" items="${products}">
<option value="${prd.productid}"> ${prd.productname}</option>
</c:forEach>
</form:select>-->

<div class="form-group">
	 <label class="control-label col-sm-2" b style="color:DarkMagenta" >supplier </label>
      <div class="col-sm-6">
      <form:select path="supplierid">
<c:forEach var="sup" items="${suppliers}">
<option value="${sup.supplierid}">${sup.suppliername}</option>
</c:forEach>
</form:select>
</div>
</div>
<br><br>
<!--supplier
<form:select path="supplierid">
<c:forEach var="sup" items="${suppliers}">
<option value="${sup.supplierid}">${sup.suppliername}</option>
</c:forEach>
</form:select>-->
<br><br>

<div class="form-group">
	 <label class="control-label col-sm-2" b style="color:DarkMagenta" >Price </label>
      <div class="col-sm-6">
        <form:input path="productsupplierprice" class="form-control" placeholder="Enter product price"/>
      </div>
    </div>
    <br><br>
    <div class="form-group">
	 <label class="control-label col-sm-2" b style="color:DarkMagenta">Stock </label>
      <div class="col-sm-6">
        <form:input path="productsupplierstock" class="form-control" placeholder="Enter product stock"/>
      </div>
    </div>
    <br><br>
    <div class="form-group">
	 <label class="control-label col-sm-2" b style="color:DarkMagenta">IsAvailable</label>
      <div class="col-sm-6">
        True <form:radiobutton path="isproductsupplieravailable" value="true"/>
        False <form:radiobutton path="isproductsupplieravailable" value="false"/>
      </div>
    </div>
<br><br>
<!--  Price <form:input path="productsupplierprice"/>
Stock <form:input path="productsupplierstock"/>

IsAvailable
   True <form:radiobutton path="isproductsupplieravailable" value="true"/>
False <form:radiobutton path="isproductsupplieravailable" value="false"/>
<br>-->
<form:button>Add Record</form:button>
</form:form>


</body>
</html>