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

-- in the future, use:
-- use SimpleSchool

SELECT * 
FROM SimpleSchool.Building;

-- What are the period name, start, and end times?

SELECT PeriodName, StartTime, EndTime
FROM SimpleSchool.Period;

-- Which table is empty?

SELECT * 
FROM SimpleSchool.Grade;

-- List all courses and credit hours in the format: CourseName (CreditHours)

SELECT CONCAT(CourseName, ' (', CreditHours, ')')
FROM SimpleSchool.CourseHours;

-- What are the teachers' full names (first names and last initials) for the first five teachers?

SELECT FirstName, LEFT(LastName, 1)
FROM SimpleSchool.Teacher
LIMIT 5;

-- How many rooms are there?

SELECT COUNT(DISTINCT(roomID)) 
FROM SimpleSchool.Room;

-- RoomNumber is an integer type. What is the range of room numbers? (Hint:Consider BuildingID too.)

SELECT MIN(roomNumber) AS Start, MAX(roomNumber) AS End
BuildingId FROM SimpleSchool.Room GROUP BY BuildingId;

-- Examine the Description field of the Room table. What are your observations ofthe description field?

SELECT Description 
FROM SimpleSchool.Room;

-- How many unique SubjectIDs appear in the Course table?

SELECT DISTINCT(subjectId)
AS SubjectId 
FROM SimpleSchool.Course;

-- How many grade types are there?

SELECT COUNT(DISTINCT(gradeTypeID)
FROM SimpleSchool.GradeType;

-- What are the IDs and Names of the grade types? (Hint: Name the columnsappropriately in the ResultSet)

SELECT gradeTypeId AS Id, gradeTypeName AS name
FROM SimpleSchool.GradeType;

-- What grade types appear in the GradeItem table?

SELECT gradeTypeName 
FROM SimpleSchool.GradeType 
WHERE gradeTypeId IN (SELECT gradeTypeId FROM gradeItem);

-- What grade types are not utilized in the GradeItem table? (Hint: You can't  You have to utilize the pre

SELECT gradeTypeName 
FROM SimpleSchool.GradeType 
WHERE gradeTypeId NOT IN (SELECT gradeTypeId FROM gradeItem);

