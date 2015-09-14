INSERT INTO Salespeoples VALUES (1001,'Peel','London',.12);
INSERT INTO Salespeoples VALUES (1002,'Serres','San Jose',.13);
INSERT INTO Salespeoples VALUES (1004,'Motika','London',.11 );
INSERT INTO Salespeoples VALUES (1007,'Rifkin','Barcelona',.15 );
INSERT INTO Salespeoples VALUES (1003,'Axelrod','New York',.10 );

INSERT INTO Customers VALUES (2001,  'Hoffman', 'London',100,1001);
INSERT INTO Customers VALUES (2002,  'Giovanni', 'Rome',200, 1003);
INSERT INTO Customers VALUES (2003,  'Liu', 'SanJose',200,1002);
INSERT INTO Customers VALUES (2004,  'Grass', 'Berlin',300,1002);
INSERT INTO Customers VALUES (2006,  'Clemens', 'London',100,1001);
INSERT INTO Customers VALUES (2008,  'Cisneros', 'SanJose',300,1007);
INSERT INTO Customers VALUES (2007,  'Pereira', 'Rome',100, 1004);

INSERT INTO Orders VALUES (3001,    18.69,  STR_TO_DATE('10/03/1990','%m/%d/%Y'), 2008, 1007 );
INSERT INTO Orders VALUES (3003,   767.19,  STR_TO_DATE('10/03/1990','%m/%d/%Y'), 2001, 1001 );
INSERT INTO Orders VALUES (3002,  1900.10,  STR_TO_DATE('10/03/1990','%m/%d/%Y'), 2007, 1004 );
INSERT INTO Orders VALUES (3005,  5160.45,  STR_TO_DATE('10/03/1990','%m/%d/%Y'), 2003, 1002 ); 
INSERT INTO Orders VALUES (3006,  1098.16,  STR_TO_DATE('10/03/1990','%m/%d/%Y'), 2008, 1007 ); 
INSERT INTO Orders VALUES (3009,  1713.23,  STR_TO_DATE('10/04/1990','%m/%d/%Y'), 2002, 1003 );
INSERT INTO Orders VALUES (3007,    75.75,  STR_TO_DATE('10/04/1990','%m/%d/%Y'), 2004, 1002 ); 
INSERT INTO Orders VALUES (3008,  4723.00,  STR_TO_DATE('10/05/1990','%m/%d/%Y'), 2006, 1001 );
INSERT INTO Orders VALUES (3010,  1309.95,  STR_TO_DATE('10/06/1990','%m/%d/%Y'), 2004, 1002 ); 
INSERT INTO Orders VALUES (3011,  9891.88,  STR_TO_DATE('10/06/1990','%m/%d/%Y'), 2006, 1001 );

COMMIT;