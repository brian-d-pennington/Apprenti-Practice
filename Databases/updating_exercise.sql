USE Inventory;

-- Update the price of 'Notebook' to $6.25.

UPDATE Product
SET Price = 6.25
WHERE ProductName = 'Notebook';

-- Update 'Pen Set' to:
-- ○ New name: 'Executive Pen Set'
-- ○ New price: $8.99

UPDATE Product
SET ProductName = 'Executive Pen Set',
    Price = 8.99
WHERE ProductName = 'Pen Set';

-- Set the EndDate to '2024-12-31' for all products in the 'Stationery' category.

UPDATE Product p
JOIN ProductCategory pc ON p.CategoryId = pc.CategoryId
SET p.EndDate = '2024-12-31'
WHERE pc.CategoryName = 'Stationery';

--  Try to update the CategoryId of 'Calendar 2023' to a value that does not exist (e.g., 999).

-- the error will say the value doesn't exist.

UPDATE Product
SET CategoryId = 3
WHERE ProductName = 'Calendar 2023';

--  Write a single UPDATE statement to change 'Classic Fiction' to:
-- ○ New name: 'Vintage Novel'
-- ○ New category: 'Clearance'
-- ○ New price: $10.00

UPDATE Product p
JOIN ProductCategory pc ON p.CategoryId = pc.CategoryId
SET p.ProductName = 'Vintage Novel',
    p.CategoryId = 3,
    p.Price = 10.00
WHERE p.ProductName = 'Classic Fiction';

-- ● Why is it important to run a SELECT query before updating?

-- to verify the fields and values to be updated

-- ● What risks are associated with forgetting a WHERE clause?

-- overwriting every field with the same name

-- ● How do foreign keys protect data consistency during updates?

-- by maintaining established data relationships


