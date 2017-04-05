<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="links.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>products to user</title>

<style>

#boxshadow {
    position: relative;
    -moz-box-shadow: 1px 2px 4px rgba(0, 0, 0,0.5);
    -webkit-box-shadow: 1px 2px 4px rgba(0, 0, 0, .5);
    box-shadow: 10px 20px 10px rgba(0, 0, 0, .5);
    padding: 1px;
    /* background: white; */
}
#boxshadow img {
    width: 100%;
    border: 1px solid #8a4419;
    border-style: inset;
}


#boxshadow::after {
    content: '';
    position: absolute;
    z-index: -1; /* hide shadow behind image */
    -webkit-box-shadow: 0 15px 20px rgba(0, 0, 0, 0.3);
    -moz-box-shadow: 0 15px 20px rgba(0, 0, 0, 0.3);
    box-shadow: 0 15px 20px rgba(0, 0, 0, 0.3);                
    width: 70%; 
    left: 15%; /* one half of the remaining 30% */
    height: 100px;
    bottom: 0;
}
.zoom-effect-container {
   /* float: left;
    position: relative; 
    width: 640px;
    height: 360px;
    margin: 0 auto;
    overflow: hidden; */
}

.image-card {
 
  top: 0;
  left: 0;
}

.image-card img {
  -webkit-transition: 0.8s ease;
  transition: 0.8s ease;
}

.zoom-effect-container:hover .image-card img {
  -webkit-transform: scale(1.1);
  transform: scale(1.1);
}
body { 
    background-size: contain;
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-position: center;
    background-size: 100% 100%;    
}

</style>
</head>
<!--<body background="resources/images/backgrounds/background${imagenum}.jpg">-->
<c:url value="/resources/images/backgrounds/background${imagenum}.jpg" var="img"></c:url>
<body background="${img}">
<!-- -${psdata}---->



<nav class="navbar navbar-inverse">
  <div class="container">
   
    <ul class="nav navbar-nav">
    <%-- <c:url value="/resources/images/products/${ps.productid}.jpg" var="url1"></c:url>
     <img id="boxshadow" src="${url1}"  style="width:220px; height:200px;"/> --%>

      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><c:url value="/resources/images/users/${userid}.jpg" var="add"></c:url>
      <img src="${add}" height="30" width="30"/>
     <%--  <img src="resources/images/users/${userid}.jpg" height="30" width="30"/>--%>Welcome ${username}<span class="caret"></span></a>
	     <ul class="dropdown-menu">
          <li><a href="reqEditProfilePage?uid=${userid}">Edit Profile</a></li>
          <li><a href="#">Change Password</a></li>
          <li><a href="j_spring_security_logout">Logout</a></li>
        </ul>
      </li>  
     
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Products<span class="caret"></span></a>
	     <ul class="dropdown-menu">
          <!--<li><a href="reqDisplayProductsUser">Display All products</a></li>-->
          <c:url value="/reqDisplayProductsUser" var="sun"></c:url>
          <li><a href="${sun}">Display All Products</a></li>
          <li><a href="#">Display wishlist</a></li>          
        </ul>
      </li>  
     
       <!--  <li><a href="#">Orders</a></li>-->
     <c:url value="/reqDisplayCart" var="url"></c:url>
        <li><a href="${url}"> <span class="glyphicon glyphicon-shopping-cart"></span>  ${cartsize}</a></li>
     
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="reqForSignupPage">About Us</a></li>
      <li><a href="reqForsigninpage">  Contact Us</a></li>
    </ul>
  </div>
</nav>

<br><br><br>
<c:if test="${cartmessage!=null}">
    <div class="container">
    <br><br>
    <div col-sm-3></div>
    <div col-sm-6>
     <div class="alert alert-danger alert-dismissable fade in">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
    ${cartmessage}
    </div>
  </div>
  </div>
  </c:if>


<div class="container-fluid">
<div class="row" >


<c:forEach var="ps" items="${psdata}">
<div class="col-sm-3 zoom-effect-container" style="background-color:transparent; border-style:none; left-padding:5px;">
		<div  class="thumbnail image-card" style="height: 370px;background-color:transparent;border:3px solid green; border-radius:8px; padding:5px; border-style: none; text-align:center; font-size:15px; font-style:bold"> 
    <c:url value="/resources/images/products/${ps.productid}.jpg" var="url1"></c:url>
     <img id="boxshadow" src="${url1}"  style="width:220px; height:200px;"/>
		 <b><br>Name : ${ps.productname} 
		 <br>Supplier :${ps.suppliername}
		 <br>Price : Rs. ${ps.productsupplierprice}
		 <!-- --- --<br>Stock : ${ps.productsupplierstock}-------->  
		    </b>
		    <c:if test="${ps.productsupplierstock >= 8}">
		 		<b><br>Stock : ${ps.productsupplierstock}</b>
		  </c:if>  
		   <c:if test="${ps.productsupplierstock < 8}">
		 		<b style="color:yellow"><br>Out of stock</b>
		  </c:if>  
		  <br>
		  <a href="reqAllSuppProduct?pid=${ps.productid}">All Suppliers</a>
		   <c:if test="${ps.productsupplierstock >= 8}">
		 <br> 
		 
		 <c:url value="/reqAddItemToCart/${ps.psid}" var="mad"></c:url>
<!--<form action="reqAddCart/${ps.psid}"--->
<form action="${mad}">
		 
          <!-- <form action="${url}">-->
		  <select name="qty" id="qty">
      	<option value="1">1</option>
      	<option value="2">2</option>
      	<option value="3">3</option>
      	<option value="4">4</option>
      	<option value="5">5</option>
      		
      	</select>
		<button type="submit" class="btn btn-warning btn-large"> 
         <span class="glyphicon glyphicon-shopping-cart"></span>Add to cart
         </button>  
		  </form>
		  
		 </c:if>
		 	
		</div>
		
		</div>
		
</c:forEach>
		    
		    
		    
		    <!---- <a href="reqAddCart"><span class="glyphicon glyphicon-shopping-cart"></span>Add to cart</a>---->		
<!-- -</div>--->
		<!-- --- -</div>--->
		


 </div><!--  row closing -->

</div> <!--  container closing -->

</body>
</html>