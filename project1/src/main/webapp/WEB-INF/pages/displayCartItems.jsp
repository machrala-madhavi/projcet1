<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="links.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<!-- <script>
var app = angular.module('myApp', []);

function MyController($scope, $http) {

	  $scope.sortType     = 'name'; // set the default sort type
	  $scope.sortReverse  = false;  // set the default sort order
	  $scope.searchDeviceName   = '';     // set the default search/filter term

        $scope.getCartItems = function() {
                $http({
                        method : 'GET',
                        url : 'getCartItemsData?cartid=${cartid}'
                }).success(function(data, status, headers, config) {
                        $scope.cartitems = data; alert(data);
                }).error(function(data, status, headers, config) {
                        
                });

        };
};

</script>
 -->
</head>
<body>

<div class="container">
<div class="row">

<div class="col-md-2" style=" background-color:transparent; border:none">
<c:url value="/reqClearCart/${customerid}" var="joe"></c:url>
<a href="${joe}" style="color:yellow" class="btn btn-warning btn-large">Clear Cart</a>
 </div>
 
 
 <div class="col-md-6" style=" background-color:transparent; border:none"></div>
 
  <div class="col-md-4" align="right" style=" background-color:transparent; border:none">
   <c:if test="${cartsize==0}">
  Cart is Empty
  </c:if>
  <c:if test="${cartsize>=1}">
  <b>Order Total : ${grandtotal}</b>
  <c:url value="/order/${customer.cart.cartid}" var="mini"></c:url>
 <a href="${mini}" style="color:yellow" class="btn btn-warning btn-large">Check Out</a>
 </c:if>
  
  <%-- <c:url value="/checkout?cartId=${customerid}" var="bag"></c:url>
 <a href="${bag}" style="color:yellow" class="btn btn-warning btn-large">Check Out</a> --%>
 </div>
 </div>
 
 </div>
 
 <div class ="container">
 
 	<table border ="0" class="table table-stripped fixed_headers" style="font-weight:bold"  >
<thead>
<tr style="background:rgba(60,60,90,1);color:yellow;table-layout: fixed;">
<th style="text-align:center">Product</th>
<th style="text-align:center">Supplier</th>
<th style="text-align:center">Quantity</th>
<th style="text-align:center">Price</th>
<th style="text-align:center">Item wise Total</th>
<th style="text-align:center">Option</th>
</tr>
</thead>

<tbody>
<c:forEach var="cartitem" items="${cartItems}">
<tr style="text-align:center;background:rgba(90,90,30,0.7)">

<td style="vertical-align: middle;font-weight:bold;color:yellow">
<c:url value="/resources/images/products/${cartitem.xmap_product_supplier.productid}.jpg" var="d"></c:url>
<img src="${d}"style="border-radius:15px"  height="120" width="150" /></td>

<td style="vertical-align: middle;font-weight:bold;color:yellow">
<c:url value="/resources/images/suppliers/${cartitem.xmap_product_supplier.supplierid}.jpg" var="a"></c:url>
<img style="border-radius:15px" src="${a}" height="120" width="150" /></td>

<td style="vertical-align: middle;font-weight:bold;color:yellow">${cartitem.quantity}</td>
<td style="vertical-align: middle;font-weight:bold;color:yellow">${cartitem.xmap_product_supplier.productsupplierprice}</td>
<td style="vertical-align: middle;font-weight:bold;color:yellow">${cartitem.itemwisetotal}</td>
<td style="vertical-align: middle;"> 
 <c:url value="/reqDeleteCartItem/${cartitem.cartitemid}" var="u"></c:url>
<a href="${u}" style="color:yellow;font-weight:bold" class="btn btn-warning btn-large">Delete</a>

</td>

</tr>
</c:forEach>
</tbody>

</table>
 
 </div>
<br><br>

</body>
</html>