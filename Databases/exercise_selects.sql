-- Write a SELECT query that uses the string All for one, and one for all.

SELECT 'All for one, and one for all.';

--  Write a SELECT query that uses the CONCAT function to combine All for one, and one for all.

SELECT Concat('All for one,', ' and one for all');

-- Write a SELECT query that adds 6 and 6.

SELECT 6 + 6;

-- Write a SELECT query that divides 5 by 2.

SELECT 5 / 2;

-- Write a SELECT query that divides 5.0 by 2.0.

SELECT 5.0 / 2.0;

-- Write a SELECT query with 2 values - 6 divided by 4 and the remainder.

SELECT 6 / 4, 6 % 4;

-- Write a SELECT query for 6 squared.

SELECT POWER(6, 2);

-- Select all the rows from the Building table.

SELECT * 
FROM SimpleSchool.Building;

-- What are the period name, start, and end times?

SELECT PeriodName, StartTime, EndTime
FROM SimpleSchool.PeriodName;

-- Which table is empty?

SELECT table_name
FROM information_schema.tables 
WHERE table_schema = 'SimpleSchool' 
    AND table_rows = 0 
    AND table_type = 'BASE TABLE';

-- List all courses and credit hours in the format: CourseName (CreditHours)

SELECT CONCAT(CourseName, ' (', CreditHours, ')')
FROM SimpleSchool.CourseHours;

-- What are the teachers' full names (first names and last initials) for the first five teachers?

SELECT FirstName, LEFT(LastName, 1)
FROM SimpleSchool.Teacher
LIMIT 5;

