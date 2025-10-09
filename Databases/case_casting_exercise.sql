USE ShopSmart;

-- Write a query that standardizes the full customer name in Title Case (e.g., "John Doe").
SELECT
	CONCAT(
		UPPER(LEFT(First_Name, 1)), LOWER(SUBSTRING(First_Name, 2)), ' ',
        UPPER(LEFT(Last_Name, 1)), LOWER(SUBSTRING(Last_Name, 2))
	) AS formatted_name
FROM customers;

-- Identify which columns need casting in the orders table.

SELECT 
	order_total,
    CAST(order_total AS DECIMAL(10,2)) as formatted_total
FROM orders;

-- Format order_date to 'Month DD, YYYY' (e.g., "July 01, 2025").

SELECT
	order_date,
    DATE_FORMAT(order_date, '%M %d, %Y') as formatted_date_lower
FROM orders;

-- Using JOIN, write a final report query that returns:
-- ● Customer full name (in Title Case)
-- ● Formatted order date
-- ● Formatted order total with two decimal places and commas

SELECT
    CONCAT(
        UPPER(LEFT(c.First_Name, 1)), LOWER(SUBSTRING(c.First_Name, 2)), ' ',
        UPPER(LEFT(c.Last_Name, 1)), LOWER(SUBSTRING(c.Last_Name, 2))
    ) AS customer_name,
    DATE_FORMAT(o.order_date, '%M %d, %Y') AS formatted_order_date,
    FORMAT(CAST(o.order_total AS DECIMAL(10,2)), 2) AS formatted_order_total
FROM customers c
JOIN orders o ON c.customer_id = o.customer_id;

-- ● What potential issues could arise from leaving order_total as a string?

-- A problem could arrise if a person or program later tries to calculate those values
-- without handling conversions first.

-- ● How does your database's case sensitivity impact query design?

-- As good practice, I would assume case sensitivity was an issue and design queries
-- to filter data to be consistent.

-- ● What are the risks of relying solely on implicit casting?

-- one assumes the data will be converted in a predictable manner and we should be
-- strict with our logic.

-- ● Why is formatting critical in customer-facing reports?

-- Beyond presentation and aesthetics, formatting needs to be consistent in order to be more
-- useful for downstream business processes.
