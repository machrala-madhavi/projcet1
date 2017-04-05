
<html>
<head>

<title>SUPPLIER</title>
<%@ include file="links.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
</head>
<body background="resources/images/y.jpg" width="50%">

<nav class="navbar navbar-inverse">
  <div class="container">
   
    <ul class="nav navbar-nav">

      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Welcome supplier..<span class="caret"></span></a>
	     <ul class="dropdown-menu">
          <li><a href="#">Edit Profile</a></li>
          <li><a href="#">Change Password</a></li>
          <li><a href="home">Logout</a></li>
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
</nav>
Edit supplier
<form:form action="reqEditSupplierToDb" commandName="supplierObj" enctype="multipart/form-data" method="POST">
<form:hidden path="supplierid"/>

<br>Supplier Name : <form:input path="suppliername"/>

<br>Supplier Desc : <form:input path="supplierdesc"/>

<br>
Is Available  :   
True <form:radiobutton path="issupplieravailable" value="true" />         
False<form:radiobutton path="issupplieravailable" value="false" />

<br>
Select Image : <form:input type="file" path="imagefile"/>
<br>
<form:button>Edit Supplier</form:button>


</form:form>

</body>
</html>