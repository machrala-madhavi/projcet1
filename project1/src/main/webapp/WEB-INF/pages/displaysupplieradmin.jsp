<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="links.jsp" %>
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
supplier display<br>
<!--${suppliers}--> 
<div class="container">
<table border ="0" class="table table-stripped fixed_headers" style="font-weight:bold"  >
<thead>
<tr style="background:rgba(60,60,90,1);color:yellow;table-layout: fixed;">
<th style="text-align:center">Supplier ID</th>
<th style="text-align:center">Supplier Logo</th>
<th style="text-align:center">Supplier Name</th>
<th style="text-align:center">Supplier Desc</th>
<th style="text-align:center">Supplier Availability</th>
<th style="text-align:center">Manage</th>
</tr>
</thead>
<tbody>
<%-- <c:url value="/resources/images/products/${ps.productid}.jpg" var="url1"></c:url>
     <img id="boxshadow" src="${url1}"  style="width:220px; height:200px;"/> --%>

<c:forEach var="sup" items="${suppliersData}">

<tr style="text-align:center;background:rgba(90,90,30,0.7)">
<td style="vertical-align: middle;font-weight:bold;color:yellow">${sup.supplierid}</td>
<td style="align:center">
<c:url value="/resources/images/suppliers/${sup.supplierid}.jpg" var="w"></c:url>
<img style="border-radius:15px" src="${w}" height="120" width="150"/></td>
<td style="vertical-align: middle;font-weight:bold;color:yellow">${sup.suppliername}</td>
<td style="vertical-align: middle;font-weight:bold;color:yellow">${sup.supplierdesc}</td>
<td style="vertical-align: middle;font-weight:bold;color:yellow">${sup.issupplieravailable}</td>

<td style="vertical-align: middle"><a href="reqEditSupplierpage?Sid=${sup.supplierid}"> <span class="glyphicon glyphicon-pencil btn btn-warning btn-large"></span></a> /  <a href="reqdeleteSupplier?Sid=${sup.supplierid}"><span class="glyphicon glyphicon-trash btn btn-warning btn-large"></span></a> </td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
</body>
</html>