-- Write a SELECT query that gets the StudentID, LastName, and FirstName of all Students with a LastName that starts with Cr.
USE SimpleSchool;

SELECT StudentID, LastName, FirstName
FROM Student
WHERE LastName LIKE 'Cr%';

-- Write a SELECT query that gets all Courses with one of the following SubjectIDs: 1, 2, 4. Use the OR keyword.

SELECT *
FROM Course
WHERE SubjectID = 1 OR SubjectID = 2 OR SubjectID = 4;


-- Write a SELECT query that gets all Courses with one of the following SubjectIDs: 1, 2, 4. Use the IN keyword.

SELECT *
FROM Course
WHERE SubjectID IN (1, 2, 4);


-- Write a SELECT query that gets the Student record with an id of 42.

SELECT *
FROM Student
WHERE StudentID = 42;


-- Write a SELECT query that gets the Student FirstNames that start with "C" using LIKE.

SELECT FirstName
FROM Student
WHERE FirstName LIKE 'C%';


-- Write a SELECT query that gets the Student FirstNames names that start with "Ce" using BETWEEN.

SELECT FirstName
FROM Student
WHERE FirstName BETWEEN 'Ce' AND 'Cf';


-- Write a SELECT query that gets the first 10 unique Student LastNames.

SELECT DISTINCT LastName
FROM Student
ORDER BY LastName
LIMIT 10;


-- Write a SELECT query that returns the first 10 Student records.

SELECT DISTINCT LastName
FROM Student
ORDER BY LastName ASC
LIMIT 10;


-- Write a SELECT query that returns the top five Students in reverse alphabetical order by LastName.

SELECT DISTINCT LastName
FROM Student
ORDER BY LastName DESC
LIMIT 5;

