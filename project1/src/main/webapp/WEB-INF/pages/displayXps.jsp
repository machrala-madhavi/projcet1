<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
<head>
<%@ include file="links.jsp" %>
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
<body>
<!----${xpsdata}---->
<body background="resources/images/background/background${imagenum}.jpg">
<%@ include file="adminnavbar.jsp" %>
<br><br><br>
display xps
<br><br>
<div class="container">
<table border ="0" class="table table-stripped fixed_headers" style="font-weight:bold"  >
<thead>

<tr style="background:rgba(60,60,90,1);color:yellow;table-layout: fixed;">
<th style="text-align:center">Product ID</th>
<th style="text-align:center">Supplier ID</th>
<th style="text-align:center">XPS ID</th>
<th style="text-align:center">Price</th>
<th style="text-align:center">Stock</th>
<th style="text-align:center">Is Available</th>

<th style="text-align:center">Manage</th>
</tr>
</thead>
<tbody>

<c:forEach var="xps" items="${xpsdata }">
<tr style="text-align:center;background:rgba(90,90,30,0.7)">
<td style="vertical-align: middle;font-weight:bold;color:yellow"><img style="border-radius:15px" src="resources/images/products/${xps.productid}.jpg" height="70" width="90" /> ${xps.productid}</td>
<td style="vertical-align: middle;font-weight:bold;color:yellow"><img style="border-radius:15px" src="resources/images/suppliers/${xps.supplierid}.jpg" height="70" width="90" />${xps.supplierid}</td>
<td style="vertical-align: middle;font-weight:bold;color:yellow">${xps.psid}</td>
<td style="vertical-align: middle;font-weight:bold;color:yellow"><p>Price &#8360</p>${xps.productsupplierprice}</td>
<td style="vertical-align: middle;font-weight:bold;color:yellow">${xps.productsupplierstock}</td>
<td style="vertical-align: middle;font-weight:bold;color:yellow">${xps.isproductsupplieravailable}</td>

<td style="vertical-align: middle"><a href="reqeditXPS?psid=${xps.psid}"><span class="glyphicon glyphicon-pencil btn btn-warning btn-large"></span></a>/<a href="reqDeleteXmap_product_Supplier?psid=${xps.psid}"> <span class="glyphicon glyphicon-trash btn btn-warning btn-large"></a></td>
</tr>
</c:forEach>
</tbody>
</table>

</body>
</html>