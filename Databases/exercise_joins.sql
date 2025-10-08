-- 1. Write a SELECT query that gets all course names, hours, and subject names where the subject name is "History," without table aliases, using the INNER keyword, and ordered by course name.
use SimpleSchool;

SELECT Course.CourseName, Course.CreditHours, Subject.SubjectName
FROM Course
INNER JOIN Subject ON Course.SubjectID = Subject.SubjectID
WHERE Subject.SubjectName = 'History'
ORDER BY Course.CourseName;

-- 2. Write a SELECT query that gets all course names, hours, and subject names where the subject name is "History," with table aliases, without the INNER keyword, and ordered by course name.

SELECT c.CourseName, c.CreditHours, s.SubjectName
FROM Course c
JOIN Subject s ON c.SubjectID = s.SubjectID
WHERE s.SubjectName = 'History'
ORDER BY c.CourseName;

-- 3. Write a SELECT query that gets all course names, hours, and subject names where the subject name is "History," with table aliases, using the INNER keyword, and ordered by course name.

SELECT c.CourseName, c.CreditHours, s.SubjectName
FROM Course c
INNER JOIN Subject s ON c.SubjectID = s.SubjectID
WHERE s.SubjectName = 'History'
ORDER BY c.CourseName;

-- 4. Write a SELECT query that gets all course names, hours, and subject names where the subject name contains the word "Art" anywhere in the name, ordered by subject name then course name.

SELECT c.CourseName, c.CreditHours, s.SubjectName
FROM Course c
INNER JOIN Subject s ON c.SubjectID = s.SubjectID
WHERE s.SubjectName LIKE '%Art%'
ORDER BY s.SubjectName, c.CourseName;

-- 5. Write a SELECT query that gets all room numbers, descriptions, and building names for rooms missing description information.

SELECT r.RoomNumber, r.Description, b.BuildingName
FROM Room r
INNER JOIN Building b ON r.BuildingID = b.BuildingID
WHERE r.Description IS NULL
ORDER BY r.RoomNumber;

-- 6. Get all the course names that are more than three credit hours for the teacher named "Geno Booy."

SELECT c.CourseName
FROM Course c
INNER JOIN Section s ON c.CourseID = s.CourseID
INNER JOIN Teacher t ON s.TeacherID = t.TeacherID
WHERE c.CreditHours > 3.0
AND t.FirstName = 'Geno'
AND t.LastName = 'Booy';