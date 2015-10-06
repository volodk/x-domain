
INSERT INTO Salespeoples VALUES (1001,	'Peel',		'London',		.12);
INSERT INTO Salespeoples VALUES (1002,	'Serres',	'San Jose',		.13);
INSERT INTO Salespeoples VALUES (1003,	'Axelrod',	'New York',		.10);
INSERT INTO Salespeoples VALUES (1004,	'Motika',	'London',		.11);
INSERT INTO Salespeoples VALUES (1005,	'Rifkin',	'Barcelona',	.15);

INSERT INTO Customers VALUES (2001,  'Hoffman',		'London',	100,	1001);
INSERT INTO Customers VALUES (2002,  'Giovanni', 	'Rome',		200, 	1003);
INSERT INTO Customers VALUES (2003,  'Liu',			'SanJose',	200,	1002);
INSERT INTO Customers VALUES (2004,  'Grass', 		'Berlin',	300,	1002);
INSERT INTO Customers VALUES (2006,  'Clemens', 	'London',	100,	1001);
INSERT INTO Customers VALUES (2008,  'Cisneros', 	'SanJose',	300,	1005);
INSERT INTO Customers VALUES (2007,  'Pereira', 	'Rome',		100, 	1004);

INSERT INTO Orders VALUES (3001,    18.69,  '1990-03-10', 	2008, 	1005 );
INSERT INTO Orders VALUES (3002,  1900.10,  '1990-04-10', 	2007, 	1004 );
INSERT INTO Orders VALUES (3003,   767.19,  '1990-03-10', 	2001, 	1001 );
INSERT INTO Orders VALUES (3005,  5160.45,  '1990-04-10', 	2003, 	1002 ); 
INSERT INTO Orders VALUES (3006,  1098.16,  '1990-04-10', 	2008,	1005 ); 
INSERT INTO Orders VALUES (3007,    75.75,  '1990-05-10', 	2004, 	1002 ); 
INSERT INTO Orders VALUES (3008,  4723.00,  '1990-06-10', 	2006, 	1001 );
INSERT INTO Orders VALUES (3009,  1713.23,  '1990-05-10', 	2002, 	1003 );
INSERT INTO Orders VALUES (3010,  1309.95,  '1990-07-10', 	2004, 	1002 ); 
INSERT INTO Orders VALUES (3011,  9891.88,  '1990-07-10', 	2006, 	1001 );

COMMIT;