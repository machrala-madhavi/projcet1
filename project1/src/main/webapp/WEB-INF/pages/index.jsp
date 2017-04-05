<%@ include file="links.jsp"%>
<html>

<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 60%;
      height:400px;
      margin: auto;
  }
  
  video#bgvid { 
    position: fixed;
    top: 50%;
    left: 50%;
    min-width: 100%;
    min-height: 100%;
    width: auto;
    height: auto;
    z-index: -100;
    -ms-transform: translateX(-50%) translateY(-50%);
    -moz-transform: translateX(-50%) translateY(-50%);
    -webkit-transform: translateX(-50%) translateY(-50%);
    transform: translateX(-50%) translateY(-50%);
    background: url(clothing.jpg) no-repeat;
    background-size: cover; 
}
  </style>
  </head>
  
 

<body background="resources/images/img4.jpg">
<video autoplay loop muted poster="clothing.jpg" id="bgvid">
    <source src="resources/images/video1.mp4" type="video/mp4">
    </video>
   
<nav class="nav navbar-inverse">
<div class="container">
<div class ="navbar-header">
<a class="navbar-brand" href="#">joyeria</a>
</div>
<ul class="nav navbar-nav">
<li><img src="resources/images/Picture1.jpg" height="40px" width="60px"/></li>
<li class="active"><a href="home">HOME</a></li>
<li><a href="#">ABOUT US</a></li>
<li><a href="#">CONTACT US</a></li>

</ul>

<ul class="nav navbar-nav navbar-right">
      <!--  <li><a href="reqForSignupPage"><span class="glyphicon glyphicon-user"></span> SIGN UP</a></li>-->
        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModalSignUp" style="color:white;background-color:transparent;border:0px;">
        <span class="glyphicon glyphicon-user"></span>   SignUp</button>
   <!--    <li><a href="reqForsigninpage"><span class="glyphicon glyphicon-log-in"></span> SIGN IN</a></li>-->
   <li><a href="reqspringloginpage"><span class="glyphicon glyphicon-log-in"></span>SignIn</a></li>
    </ul>
</div>
</nav>
 ${logout}
<%@ include file="carosal.jsp"%>
<br><br><br>

<div class="container-fluid">
<div class="row" >
<c:forEach var="ps" items="${psdata}">
<div class="col-sm-3 zoom-effect-container" style="background-color:transparent; border-radius:15px; left-padding:5px;">
		<div  class="thumbnail image-card" style="height: 370px;background-color:transparent;border:3px solid green; border-radius:8px; padding:5px; border-style: none; text-align:center; font-size:15px; font-style:bold"> 
    <c:url value="/resources/images/products/${ps.productid}.jpg" var="tea"></c:url>
     <img id="boxshadow" src="${tea}"  style="width:220px; height:200px;"/>
		 <b><br>Name : ${ps.productname} 
		 <br>Supplier :${ps.suppliername}
		 <br>Price : ${ps.productsupplierprice}
		 </b>
		 </div>
		 </div>
		 </c:forEach>
</div>
</div>
  <!-- Modal starts - SignUp -->
  <div class="modal fade" id="myModalSignUp" role="dialog" >
  <br><br><br>
    <div class="modal-dialog">
        
      <!-- Modal content-->
      <div class="modal-content" style="background:rgba(90,90,30,0.2)">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" style="color:yellow">&times;</button>
          <h4 class="modal-title" style="color:yellow">SignUp Form</h4>
        </div>
        <div class="modal-body" style="align:center;background:rgba(90,90,30,0.6)">  
        
        	<form:form  class="form-horizontal" commandName="customerObject" method="POST" action="reqSendSignupDataToDB" encType="multipart/form-data">

			   
			      <div class="col-sm-3" style="background-color:transparent;color:yellow; vertical-align:baseline">Customer Name </div>
			      <div class="col-sm-8" style="background-color:transparent">
				       <form:input path="custname" class="form-control" placeholder="Enter Customer Name" style="background-color:transparent;color:yellow"/>
				      <form:errors path="custname"></form:errors>
				  </div>
			
			      <div class="col-sm-3" style="background-color:transparent;color:yellow">Email ID </div>
			      <div class="col-sm-8" style="background-color:transparent">
				       <form:input path="custemailid" class="form-control" placeholder="Enter Email ID" style="background-color:transparent;color:yellow"/>
				       <form:errors path="custemailid"></form:errors>
				  </div>		
				
			      <div class="col-sm-3" style="background-color:transparent;color:yellow">Mobile No. </div>
			      <div class="col-sm-8" style="background-color:transparent">
				       <form:input path="custmobileno" class="form-control" placeholder="Enter Mobile No." style="background-color:transparent;color:yellow"/>
                       <form:errors path="custmobileno"></form:errors>
				  </div>		
				
			      			
					<br> Authentication details <br>
			      <div class="col-sm-3" style="background-color:transparent;color:yellow">Password</div>
			      <div class="col-sm-8" style="background-color:transparent">
				       <form:password path="signUp1.Password" class="form-control" placeholder="Enter Password" style="background-color:transparent;color:yellow"/>
				 
				  </div>	
				  	
				  	 <div class="col-sm-3" style="background-color:transparent;color:yellow">Image</div>
			      <div class="col-sm-8" style="background-color:transparent">
				       <form:input type="file" path="signUp1.imagefile" class="form-control" style="background-color:transparent;color:yellow"/>
				  </div>		
				  			
				  			
				  			
						<br> Address <br>
			      <div class="col-sm-3" style="background-color:transparent;color:yellow">Hose No.</div>
			      <div class="col-sm-8" style="background-color:transparent">
				       <form:input path="shippingAddress.houseno" class="form-control" placeholder="Enter House No." style="background-color:transparent;color:yellow"/>
                       
				  </div>				
			
			  		 <div class="col-sm-3" style="background-color:transparent;color:yellow">Street</div>
			      <div class="col-sm-8" style="background-color:transparent">
				       <form:input path="shippingAddress.street" class="form-control" placeholder="Enter Street" style="background-color:transparent;color:yellow"/>
				      
				  </div>	
				  
			      <div class="col-sm-3" style="background-color:transparent;color:yellow">Area</div>
			      <div class="col-sm-8" style="background-color:transparent">
				       <form:input path="shippingAddress.area" class="form-control" placeholder="Enter Area" style="background-color:transparent;color:yellow"/>
                      
				  </div>				
		
		     	<div class="col-sm-3" style="background-color:transparent;color:yellow">City</div>
			      <div class="col-sm-8" style="background-color:transparent">
				       <form:input path="shippingAddress.city" class="form-control" placeholder="Enter City" style="background-color:transparent;color:yellow"/>
                       
				  </div>
				  
		     	<div class="col-sm-3" style="background-color:transparent;color:yellow">State</div>
			      <div class="col-sm-8" style="background-color:transparent">
				       <form:input path="shippingAddress.state" class="form-control" placeholder="Enter State" style="background-color:transparent;color:yellow"/>
                       
				  </div>
				  
	     		<div class="col-sm-3" style="background-color:transparent;color:yellow">Country</div>
			      <div class="col-sm-8" style="background-color:transparent">
				       <form:input path="shippingAddress.country" class="form-control" placeholder="Enter Country" style="background-color:transparent;color:yellow"/>
                      
				  </div>		
			
	     		<div class="col-sm-3" style="background-color:transparent;color:yellow">Pincode</div>
			      <div class="col-sm-8" style="background-color:transparent">
				       <form:input path="shippingAddress.pincode" class="form-control" placeholder="Enter Pincode" style="background-color:transparent;color:yellow"/>
                       
				  </div>
				  
		
				<br> 
				<form:button class="btn btn-primary active">SignUp</form:button>
	
			</form:form>        
     
          </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal" style="color:blue">Close</button>
        </div>
      </div>
      
    </div>
  </div>
   
 <!-- Modal ends - SignUp -->
         
    <c:if test="${message==1}">
    <div class="container">
    <br><br>
    <div col-sm-3></div>
    <div col-sm-6>
     <div class="alert alert-danger alert-dismissable fade in">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
    ${message1}
    </div>
  </div>
  </div>
  </c:if>     
 
  
    <c:if test="${message==0}">
    <div class="container">
    <br><br>
    <div col-sm-3></div>
    <div col-sm-6>
     <div class="alert alert-danger alert-dismissable fade in">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
    <strong>Error!</strong>       Login failed...Try again..
    </div>
  </div>
  </div>
  </c:if>
  

<a href="reqForsigninpage">SignIn </a>
<br>
<a href="reqForSignupPage">SignUp </a>
</body>
</html>
