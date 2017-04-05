<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="links.jsp" %>

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

 
<script>

$(document).ready(function(){
	var searchCondition='${searchCondition}';
	$('.table').DataTable({
		"lengthMenu" : [[5,10,15,-1],[5,10,15,"All"]],
		"oSearch":{"sSearch":searchCondition}		
	})	
});

</script>


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
<body background="resources/images/background/background${imagenum}.jpg">

<%@ include file="adminnavbar.jsp" %>
<br><br><br>

<div class="container">
<table border ="0" class="table table-stripped fixed_headers" style="font-weight:bold"  >
<thead>
<tr style="background:rgba(60,60,90,1);color:yellow;table-layout: fixed;">
<th style="text-align:center">Product Id</th>
<th style="text-align:center">Image</th>
<th style="text-align:center">Product Name</th>
<th style="text-align:center">Product Desc</th>
<th style="text-align:center">Is Available</th>
<th style="text-align:center">Options</th>
</tr>
</thead>
<%-- <c:url value="/resources/images/products/${ps.productid}.jpg" var="url1"></c:url>
     <img id="boxshadow" src="${url1}"  style="width:220px; height:200px;"/> --%>
<tbody>
<c:forEach var="prd" items="${products}">

<tr style="text-align:center;background:rgba(90,90,30,0.7)">
<td style="vertical-align: middle;font-weight:bold;color:yellow">${prd.productid}</td>
<td style="align:center">
<c:url value="/resources/images/products/${prd.productid}.jpg" var="q"></c:url> <img style="border-radius:15px" src="${q}" height="120" width="150" /></td>
<td style="vertical-align: middle;font-weight:bold;color:yellow">${prd.productname}</td>
<td style="vertical-align: middle;font-weight:bold;color:yellow">${prd.productdes}</td>
<td style="vertical-align: middle;font-weight:bold;color:yellow">${prd.isproductavailable}</td>
<td style="vertical-align: middle"><a href="reqEditProductPage?pid=${prd.productid}">Edit</a> / <a href="reqDeleteProduct?pid=${prd.productid}">Delete</a> </td>
</tr>
</c:forEach>
</tbody>

</table>
</div>
</body>
</html>