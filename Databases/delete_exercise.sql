USE DeleteDB;

-- 1 .Write a SELECT query to find the product with the name 'Calendar 2023'.

SELECT * 
FROM Product 
WHERE ProductName = 'Calendar 2023';

-- 2. Use a DELETE statement to remove that product from the table.

DELETE FROM Product 
WHERE ProductName = 'Calendar 2023';

-- 3. Write a SELECT query to preview all products in the 'Stationery' category.

SELECT p.ProductId, p.ProductName, p.CategoryId, p.Price, pc.CategoryName
FROM Product p
JOIN ProductCategory pc ON p.CategoryId = pc.CategoryId
WHERE pc.CategoryName = 'Stationery';

-- 4. Use a DELETE statement to remove all products in that category.

DELETE p 
FROM Product p
JOIN ProductCategory pc ON p.CategoryId = pc.CategoryId
WHERE pc.CategoryName = 'Stationery';

-- 5. Try to delete the 'Books' category from the ProductCategory table.
-- What happens? Record the error message (if any).

-- It would get an error message because the ID is being used by the Product table

-- 6. Now safely remove the 'Books' category by deleting its related products first.

DELETE p 
FROM Product p
JOIN ProductCategory pc ON p.CategoryId = pc.CategoryId
WHERE pc.CategoryName = 'Books';

DELETE FROM ProductCategory 
WHERE CategoryName = 'Books';

-- 7. Write a DELETE statement that removes any category from ProductCategory
-- only if no products are assigned to it.

DELETE FROM ProductCategory 
WHERE CategoryId NOT IN (
    SELECT DISTINCT CategoryId 
    FROM Product 
    WHERE CategoryId IS NOT NULL
);