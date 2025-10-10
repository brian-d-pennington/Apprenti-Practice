USE SimpleSchool;

-- 1. Add a new subject named "Comp. Science."
INSERT INTO Subject (SubjectName)
VALUES ('Comp. Science.');

-- 2. Modify the subject's name to "Computer Science."
UPDATE Subject
SET SubjectName = 'Computer Science'
WHERE SubjectName = 'Comp. Science.';

-- 3. Add the four courses to the Computer Science subject
INSERT INTO Course (SubjectID, CourseName, CreditHours)
VALUES 
    ((SELECT SubjectID FROM Subject WHERE SubjectName = 'Computer Science'), 'Java', 3.00),
    ((SELECT SubjectID FROM Subject WHERE SubjectName = 'Computer Science'), 'C#', 3.00),
    ((SELECT SubjectID FROM Subject WHERE SubjectName = 'Computer Science'), 'JavaScript', 3.00),
    ((SELECT SubjectID FROM Subject WHERE SubjectName = 'Computer Science'), 'Advanced Java', 3.00);

-- 4. Rename the course "Java" to "Java 101."
UPDATE Course
SET CourseName = 'Java 101'
WHERE CourseName = 'Java'
  AND SubjectID = (SELECT SubjectID FROM Subject WHERE SubjectName = 'Computer Science');

-- 5. Rename "Advanced Java" to "Java 201" and change credit hours to 4 in one statement
UPDATE Course
SET CourseName = 'Java 201',
    CreditHours = 4.00
WHERE CourseName = 'Advanced Java'
  AND SubjectID = (SELECT SubjectID FROM Subject WHERE SubjectName = 'Computer Science');

-- 6. Delete the "Computer Science" subject.
-- a. What error message did you get?
-- b. Why did you get that error message?

-- You would get a foreign key constraint error because there are courses in the Course 
-- table that reference this subject.

-- 7. Delete the "Java 101" course
DELETE FROM Course
WHERE CourseName = 'Java 101'
  AND SubjectID = (SELECT SubjectID FROM Subject WHERE SubjectName = 'Computer Science');

-- 8. Delete the remaining Computer Science courses with one statement
DELETE FROM Course
WHERE SubjectID = (SELECT SubjectID FROM Subject WHERE SubjectName = 'Computer Science');

-- 9. Delete the "Computer Science" subject
DELETE FROM Subject
WHERE SubjectName = 'Computer Science';