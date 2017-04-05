<html>
<head>

<%@ include file="links.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
</head>

<body background="resources/images/u.jpg" width="50%">
<%@ include file="adminnavbar.jsp" %>
<!-- <nav class="navbar navbar-inverse">
  <div class="container">
   
    <ul class="nav navbar-nav">

      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><img class="img-circle" src="resources/images/users/${userlogin}.jpg" height="30" width="30"/>Welcome${username} <span class="caret"></span></a>
	     <ul class="dropdown-menu">
          <li><a href="reqEditProfilePage?uid=${loginuserid}">Edit Profile</a></li>
          <li><a href="#">Change Password</a></li>
          <li><a href="j_spring_security_logout">Logout</a></li>
        </ul>
      </li>  
     
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Products<span class="caret"></span></a>
	     <ul class="dropdown-menu">
          <li><a href="reqdisplayproductadmin">Display All products</a></li>
          <li><a href="reqproduct">Add Product</a></li>          
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
          <li><a href="reqaddprodsupp">Add ProductSupplier</a></li>          
        </ul>
      </li>  
     
     
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="reqForSignupPage">About Us</a></li>
      <li><a href="reqForSigninPage">  Contact Us</a></li>
    </ul>
  </div>
</nav>-->


<br><br>
<div class="container" align="center">
<h2>Add product</h2>
<form:form action="addProductToDB" commandName="productObject" enctype="multipart/form-data" method="POST">

<div class="form-group">
	 <label class="control-label col-sm-2" >Product Name </label>
      <div class="col-sm-6">
        <form:input path="productname" class="form-control" placeholder="Enter product name"/>
       <form:errors path="productname"></form:errors>
      </div>
    </div>
    <br><br>
<!--  <br>Product Name : <form:input path="productname"/>-->
<div class="form-group">
	 <label class="control-label col-sm-2" >Product Desc </label>
      <div class="col-sm-6">
        <form:input path="productdes" class="form-control" placeholder="Enter product desc"/>
      </div>
    </div>
<!--<br>Product Desc : <form:input path="productdes"/>-->

<br><br>
<div class="form-group">
	 <label class="control-label col-sm-2" >Is Available  </label>
      <div class="col-sm-3">
True <form:radiobutton path="isproductavailable" value="true" />         
False<form:radiobutton path="isproductavailable" value="false" />
 </div>
 </div>
<br><br>
<div class="form-group">
	 <label class="control-label col-sm-2" >Select Image  </label>
      <div class="col-sm-3">
       <form:input type="file" path="imagefile"/>
 </div>
 </div>
<!--Select Image : <form:input type="file" path="imagefile"/>-->
<br><br>

<form:button>Add Product</form:button>


</form:form>
</body>
</html>