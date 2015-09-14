DROP TABLE if exists Orders;
DROP TABLE if exists Customers;
DROP TABLE if exists Salespeoples;

CREATE TABLE Salespeoples
(
	snum  integer NOT NULL PRIMARY KEY, 
	sname char(10) NOT NULL, 
	city  char(10), 
	comm  decimal
); 

CREATE TABLE Customers
( 
	cnum   integer NOT NULL PRIMARY KEY, 
	cname  char(10) NOT NULL, 
	city   char(10), 
	rating integer, 
	snum   integer, 
	FOREIGN KEY (snum) REFERENCES Salespeoples(snum), 
	UNIQUE (cnum, snum)
); 

CREATE TABLE Orders
(
	onum  integer NOT NULL PRIMARY KEY, 
	amt   decimal, 
	odate date NOT NULL,
	cnum  integer NOT NULL,
	snum  integer NOT NULL, 
	FOREIGN KEY (cnum, snum) REFERENCES CUSTOMERS (cnum, snum)
);
