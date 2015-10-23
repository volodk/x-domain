CREATE SEQUENCE	salespeople_seq START WITH 1006;
CREATE SEQUENCE	customer_seq START WITH 2008;
CREATE SEQUENCE	order_seq START WITH 3012;

CREATE TABLE Salespeoples
(
	snum  integer NOT NULL PRIMARY KEY, 
	sname varchar(10) NOT NULL, 
	city  varchar(10), 
	comm  float
); 

CREATE TABLE Customers
( 
	cnum   integer NOT NULL PRIMARY KEY, 
	cname  varchar(10) NOT NULL, 
	city   varchar(10), 
	rating integer, 
	snum   integer, 
	FOREIGN KEY (snum) REFERENCES Salespeoples(snum), 
	UNIQUE (cnum, snum)
); 

CREATE TABLE Orders
(
	onum  integer NOT NULL PRIMARY KEY, 
	amt   float, 
	odate date NOT NULL,
	cnum  integer NOT NULL,
	snum  integer NOT NULL, 
	FOREIGN KEY (cnum, snum) REFERENCES CUSTOMERS (cnum, snum)
);
