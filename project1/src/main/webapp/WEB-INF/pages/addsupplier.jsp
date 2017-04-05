
<html>
<head>

<title>SUPPLIER</title>

<%@ include file="links.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

<body background="resources/images/w.jpg" width="50%">
<%@ include file="adminnavbar.jsp" %>
<br><br>
<!--  <nav class="navbar navbar-inverse">
  <div class="container">
   
    <ul class="nav navbar-nav">

      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><img src="resources/images/users/${userlogin}.jpg" height="30" width="30" class="img-circle"/>Welcome ${username}<span class="caret"></span></a>
	     <ul class="dropdown-menu">
          <li><a href="#">Edit Profile</a></li>
          <li><a href="#">Change Password</a></li>
          <li><a href="j_spring_security_logout">Logout</a></li>
        </ul>
      </li>  
     
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Products<span class="caret"></span></a>
	     <ul class="dropdown-menu">
          <li><a href="reqdisplayXps">Display All products</a></li>
          <li><a href="reqaddprodsuppForm">Add Product</a></li>          
        </ul>
      </li>  
     
     <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Suppliers<span class="caret"></span></a>
	     <ul class="dropdown-menu">
          <li><a href="reqdisplaysupplieradmin">Display All suppliers</a></li>
          <li><a href="reqaddsupplier">Add Supplier</a></li>          
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
<div class="container" align="center">
<h2 style="color:white">Add supplier </h2>

<form:form action="addSupplierToDB" commandName="supplierObject" enctype="multipart/form-data" method="POST">
<div class="form-group">
	 <label class="control-label col-sm-2" style="color:white">Supplier Name </label>
      <div class="col-sm-6">
        <form:input path="suppliername" class="form-control" placeholder="Enter supplier name"/>
      </div>
    </div>
    <br><br>
<!-- <br>Supplier Name : <form:input path="suppliername"/>-->
<div class="form-group">
	 <label class="control-label col-sm-2" style="color:white"> Supplier Desc</label>
      <div class="col-sm-6">
        <form:input path="supplierdesc" class="form-control" placeholder="Enter supplier name"/>
      </div>
    </div>
    <br><br>
<!--<br>Supplier Desc : <form:input path="supplierdesc"/>-->

<div class="form-group">
	 <label class="control-label col-sm-2" style="color:white">Is Available  </label>
      <div class="col-sm-3">
<h6 style="color:white">True</h6> <form:radiobutton path="issupplieravailable" value="true" />         
<h6 style="color:white"> False</h6><form:radiobutton path="issupplieravailable" value="false" />
</div>
</div><br>
<br><br>
<div class="form-group">
	 <label class="control-label col-sm-2" style="color:white">Select Image  </label>
      <div class="col-sm-3">
      <form:input type="file" path="imagefile"/>
 </div>
 </div>
<br><br>
<form:button>Add Supplier</form:button>

</div>
</form:form>

</body>
</html>