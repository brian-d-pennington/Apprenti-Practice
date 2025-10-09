-- CREATE DATABASE BookBarn;

USE BookBarn;

-- Create the Book table
CREATE TABLE Book (
    BookId INT PRIMARY KEY,
    GenreId INT,
    Title VARCHAR(255),
    Price DECIMAL(10, 2)
);

-- Insert data into the Book table
INSERT INTO Book (BookId, GenreId, Title, Price) VALUES
(1, 1, 'Into the Woods', 14.99),
(2, 2, 'Startup Fundamentals', 22.00),
(3, 1, 'Ghost Leaves', 11.50);

-- Create the Genre table
CREATE TABLE Genre (
    GenreId INT PRIMARY KEY,
    GenreName VARCHAR(100)
);

-- Insert data into the Genre table
INSERT INTO Genre (GenreId, GenreName) VALUES
(1, 'Fiction'),
(2, 'Business');

-- Create the Book table
CREATE TABLE Book (
    BookId INT PRIMARY KEY,
    GenreId INT,
    Title VARCHAR(255),
    Price DECIMAL(10, 2),
    FOREIGN KEY (GenreId) REFERENCES Genre(GenreId)
);

-- Insert data into the Book table
INSERT INTO Book (BookId, GenreId, Title, Price) VALUES
(1, 1, 'Into the Woods', 14.99),
(2, 2, 'Startup Fundamentals', 22.00),
(3, 1, 'Ghost Leaves', 11.50);

-- Create the Staff table
CREATE TABLE Staff (
    StaffId INT PRIMARY KEY,
    LastName VARCHAR(100),
    HireDate DATE
);

-- Insert data into the Staff table
INSERT INTO Staff (StaffId, LastName, HireDate) VALUES
(1, 'Nguyen', '2020-01-01'),
(2, 'Smith', '2021-03-15');

-- Create the Sale table
CREATE TABLE Sale (
    SaleId INT PRIMARY KEY,
    StaffId INT,
    Total DECIMAL(10, 2),
    FOREIGN KEY (StaffId) REFERENCES Staff(StaffId)
);

-- Insert data into the Sale table
INSERT INTO Sale (SaleId, StaffId, Total) VALUES
(101, 1, 295.75),
(102, 2, 840.20);

-- Calculate minimum, maximum, and average book price:

SELECT 
    MIN(Price) AS minimum_price,
    MAX(Price) AS maximum_price,
    AVG(Price) AS average_price
FROM Book;

-- Group books by GenreName and find the average price per genre:

SELECT 
    g.GenreName,
    AVG(b.Price) AS average_price
FROM Book b
JOIN Genre g ON b.GenreId = g.GenreId
GROUP BY g.GenreName;

-- Filter to show only genres where the average price exceeds $15:

SELECT 
    g.GenreName,
    AVG(b.Price) AS average_price
FROM Book b
JOIN Genre g ON b.GenreId = g.GenreId
GROUP BY g.GenreName
HAVING AVG(b.Price) > 15;

-- Count the total number of sales made by each staff member:

SELECT 
    st.StaffId,
    st.LastName,
    COUNT(sa.SaleId) AS total_sales_count
FROM Staff st
LEFT JOIN Sale sa ON st.StaffId = sa.StaffId
GROUP BY st.StaffId, st.LastName;

-- Calculate total sales value per staff using SUM:

SELECT 
    st.StaffId,
    st.LastName,
    SUM(sa.Total) AS total_sales_value
FROM Staff st
LEFT JOIN Sale sa ON st.StaffId = sa.StaffId
GROUP BY st.StaffId, st.LastName;

-- Show only staff whose sales exceed $800:

SELECT 
    st.StaffId,
    st.LastName,
    SUM(sa.Total) AS total_sales_value
FROM Staff st
JOIN Sale sa ON st.StaffId = sa.StaffId
GROUP BY st.StaffId, st.LastName
HAVING SUM(sa.Total) > 800;

-- Sort staff by total sales descending:

SELECT 
    st.StaffId,
    st.LastName,
    SUM(sa.Total) AS total_sales_value
FROM Staff st
LEFT JOIN Sale sa ON st.StaffId = sa.StaffId
GROUP BY st.StaffId, st.LastName
ORDER BY total_sales_value DESC;

-- Group staff by HireDate and return a comma-separated list of last names hired on each date.

SELECT 
    HireDate,
    GROUP_CONCAT(LastName ORDER BY LastName SEPARATOR ', ') AS staff_last_names
FROM Staff
GROUP BY HireDate;



