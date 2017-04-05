create table Product
(
	productid char(10) primary key,
	productname char(40),
	productdesc char(50),
	isproductavailable boolean	
)

create table Supplier
(
	supplierid char(10) primary key,
	suppliername char(30),
	supplierdesc char(30),
	issupplieravailable boolean
)


create table Xmap_product_Supplier
(
psid char(10) primary key,
	productid char(10) references Product(productid),
	supplierid char(10) references Supplier(supplierid),
	productsupplierprice int,
	productsupplierstock int,
	isproductsupplieravailable boolean
)



create view Vw_Xmap_ps

as

select p.productid,p.productname,ps.psid, s.supplierid,s.suppliername,ps.productsupplierprice, ps.productsupplierstock
from product p join xmap_product_supplier ps on p.productid=ps.productid join supplier s on ps.supplierid=s.supplierid
where p.isproductavailable=true and
ps.isproductsupplieravailable=true and
s.issupplieravailable=true