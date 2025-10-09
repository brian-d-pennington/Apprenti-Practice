USE SimpleSchool;

-- Part 1: Using NOT EXISTS
--  Write a query to list all Students that are not registerd for a class 
-- Hint(Check the Section Roster) 

SELECT 
    StudentID,
    FirstName,
    LastName,
    ClassYear
FROM Student s
WHERE NOT EXISTS (
    SELECT 1
    FROM SectionRoster sr
    WHERE sr.StudentID = s.StudentID
);

-- Part 2: Subqueries in the WHERE Clause
-- Find the name(s) of classes that have the most students registered

SELECT 
    c.CourseName,
    COUNT(sr.StudentID) AS StudentCount
FROM Course c
JOIN Section sec ON c.CourseID = sec.CourseID
JOIN SectionRoster sr ON sec.SectionID = sr.SectionID
GROUP BY c.CourseID, c.CourseName
HAVING COUNT(sr.StudentID) = (
    SELECT COUNT(sr2.StudentID) AS MaxStudents
    FROM Course c2
    JOIN Section sec2 ON c2.CourseID = sec2.CourseID
    JOIN SectionRoster sr2 ON sec2.SectionID = sr2.SectionID
    GROUP BY c2.CourseID
    ORDER BY MaxStudents DESC
    LIMIT 1
);

-- Part 3: Subquery in the SELECT Clause
-- Select all Classes Show:
-- The Teacher That is assigned to Instruct
-- The Room That the class is in
-- No Joins Allowed

SELECT 
    c.CourseName AS ClassName,
    (SELECT CONCAT(t.FirstName, ' ', t.LastName)
     FROM Teacher t
     WHERE t.TeacherID = s.TeacherID) AS TeacherName,
    (SELECT CONCAT(b.BuildingName, ' ', r.RoomNumber)
     FROM Room r, Building b
     WHERE r.RoomID = s.RoomID 
     AND b.BuildingID = r.BuildingID) AS RoomLocation
FROM Section s, Course c
WHERE c.CourseID = s.CourseID;

-- Part 4: Subquery in the HAVING Clause
-- Use the Query from Part 2. Use Having to determine which class(s)
-- Has the least amount of Students (Must Be in a Subquery)

SELECT 
    c.CourseName,
    COUNT(sr.StudentID) AS StudentCount
FROM Course c
JOIN Section sec ON c.CourseID = sec.CourseID
JOIN SectionRoster sr ON sec.SectionID = sr.SectionID
GROUP BY c.CourseID, c.CourseName
HAVING COUNT(sr.StudentID) = (
    SELECT COUNT(sr2.StudentID) AS MinStudents
    FROM Course c2
    JOIN Section sec2 ON c2.CourseID = sec2.CourseID
    JOIN SectionRoster sr2 ON sec2.SectionID = sr2.SectionID
    GROUP BY c2.CourseID
    ORDER BY MinStudents ASC
    LIMIT 1
);


-- Part 5: Correlated Subquery
-- Return the top 3 Teachers that have the most students to teach 
-- across all classes and semesters

SELECT 
    t.TeacherID,
    CONCAT(t.FirstName, ' ', t.LastName) AS TeacherName,
    (SELECT COUNT(DISTINCT sr.StudentID)
     FROM Section s
     JOIN SectionRoster sr ON s.SectionID = sr.SectionID
     WHERE s.TeacherID = t.TeacherID) AS TotalStudents
FROM Teacher t
WHERE (SELECT COUNT(DISTINCT sr.StudentID)
       FROM Section s
       JOIN SectionRoster sr ON s.SectionID = sr.SectionID
       WHERE s.TeacherID = t.TeacherID) > 0
ORDER BY TotalStudents DESC
LIMIT 3;

