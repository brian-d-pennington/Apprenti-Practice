USE StoredProc;

--  Create a stored procedure in either MySQL or SQL Server that selects all the
--  columns from a table named Customers where the Status is 'Active'.

DELIMITER //
CREATE PROCEDURE GetActiveCustomers()
BEGIN
 SELECT * FROM Customers
 WHERE Status = 'Active'; -- example script. No such field in StoredProc DB
END //
DELIMITER ;

CALL GetActiveCustomers();

-- Create a stored procedure that accepts an INT parameter for CustomerId and
-- returns the customer’s details from the Customers table.

DELIMITER //
CREATE PROCEDURE GetCustomerDetails(IN CustomerIdIn INT)
BEGIN
 SELECT * FROM Customers
 WHERE CustomerId = CustomerIdIn;
END //
DELIMITER ;

CALL GetCustomerDetails(1);

-- Create a stored procedure that takes two parameters: an INT for CustomerId and
-- a VARCHAR for CustomerName, then returns customer details where both
-- CustomerId and CustomerName match.


DELIMITER //
CREATE PROCEDURE GetCustomerNameInfo(IN CustomerIdIn INT, IN CustomerNameIn
VARCHAR(255))
BEGIN
 SELECT * FROM Customers
 WHERE CustomerId = CustomerIdIn AND LastName = CustomerNameIn;
END //
DELIMITER ;

CALL GetCustomerNameInfo(1, 'Smith');

--  Modify the stored procedure from Task 2 to include a check that only returns the
--  customer’s details if they are active (Status = 'Active').

DROP PROCEDURE IF EXISTS GetCustomerDetails;
DELIMITER //
CREATE PROCEDURE GetCustomerDetails(IN CustomerIdIn INT)
BEGIN
 SELECT * FROM Customers
 WHERE CustomerId = CustomerIdIn AND Status = 'Active'; -- won't work with my table with no Status field
END //
DELIMITER ;

CALL GetCustomerDetails(1);

-- Remove the stored procedure created in Task 3 from the database.

DROP PROCEDURE IF EXISTS GetCustomerInfo;

-- Reflection Questions
-- 1. Why are stored procedures useful in maintaining consistency across database
-- operations?

-- It can be a way to enforce rules and conventions when performing CRUD operations
-- on a DB.

-- 2. How can stored procedures improve performance and security in database
-- systems?

-- Avoiding hard-coded values in SQL queries prevents outside actors from seeing
-- db data, and StoredProcs can wrap functionality within one place and cache results.

-- 3. What are the key differences between writing stored procedures in MySQL and
-- SQL Server?

-- (AI answer:)

-- MySQL:

-- Uses LOOP, WHILE, REPEAT loops
-- CASE statements
-- IF-THEN-ELSE
-- SQL Server:

-- Uses WHILE loops primarily
-- CASE expressions
-- IF-ELSE statements
-- More extensive T-SQL control flow

--