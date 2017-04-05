<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="links.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>sign up form</title>
</head>
<body>
<div align="center">
<table>
<tr><h3>Sign Up</h3>
<br><br>


	<div class="container-wrapper">
  <div class="container">
  <form:form class="form-horizontal" commandName="customerObject" method="POST" action="reqSingupDatatoDB" enctype="multipart/form-data">
	
	<div class="form-group">
	 <label class="control-label col-sm-2" >User Name </label>
      <div class="col-sm-6">
        <form:input path="username" class="form-control" placeholder="Enter User Name"/>
      </div>
    </div>
    <br><br>
    <div class="form-group">
	 <label class="control-label col-sm-2" >Password </label>
      <div class="col-sm-6">
        <form:password path="password" class="form-control" placeholder="Enter Password "/>
      </div>
    </div>
<br><br>
<div class="form-group">
	 <label class="control-label col-sm-2" >Email Id </label>
      <div class="col-sm-6">
        <form:input path="emailid" class="form-control" placeholder="Enter EmailId "/>
      </div>
    </div>
<br><br>
    <div class="form-group">
	 <label class="control-label col-sm-2" >Mobile No </label>
      <div class="col-sm-6">
        <form:input path="mobileno" class="form-control" placeholder="Enter Valid Cell No starts with 7/8/9" pattern="[789][0-9]{9}"/>
      </div>
    </div>
    <br><br>
    <div class="form-group">
	 <label class="control-label col-sm-2" >Address </label>
      <div class="col-sm-6">
        <form:input path="address" class="form-control" placeholder="Enter valid address  eg: door no with town and city" />
      </div>
    </div>
    <br><br>
    <div class="form-group">
	 <label class="control-label col-sm-2" >City </label>
      <div class="col-sm-6">
        <form:input path="city" class="form-control" placeholder="Enter City" />
      </div>
    </div>
    <br><br>
    <div class="form-group">
	 <label class="control-label col-sm-2" >State </label>
      <div class="col-sm-6">
        <form:input path="state" class="form-control" placeholder="Enter User State" />
      </div>
    </div>
    <br><br>
   
    
	<!-- -- --Enter user name : <form:input path="username"/>
<br>Enter password  : <form:password path="password"/>
<br>Enter Mobile no.  : <form:input path="mobileno" pattern="[789][0-9]{9}"/>
<br>Enter Email id : <form:input path="emailid"/>
<br>Enter Address : <form:input path="address"/>
<br>Enter City : <form:input path="city"/>
<br>Enter State : <form:input path="state"/>
<br>---->
<tr>Select Image <form:input type="file" path="imagefile"/></tr>
<br><br>
	
<br> <form:button class="btn btn-primary active">SignUp</form:button>

</form:form>
</div>
</div>
</div>
</tr>
</body>
</html>