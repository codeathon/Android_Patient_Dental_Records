BEGIN TRANSACTION;
CREATE TABLE login (uname TEXT, pswd TEXT);
INSERT INTO login VALUES('rohitain','rohitain');
CREATE TABLE patient (first_name TEXT, last_name TEXT, sex TEXT, dob TEXT, marital_status TEXT, address TEXT, cellno NUMERIC, id INTEGER PRIMARY KEY);
INSERT INTO patient VALUES('Rohit','Ainapure','M','04/10/2012','Single','12 Englewood Avenue',7168660215,1);
COMMIT;
