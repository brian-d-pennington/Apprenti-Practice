USE RetailStore;

-- Insert two new customers: Emma Rivera and Noah Gray into the Customer table.

INSERT INTO Customer (CustomerId, CustomerName)
VALUES 
    (1, 'Emma Rivera'),
    (2, 'Noah Gray');

-- to test:
-- SELECT *
-- FROM Customer;

-- Create an order for each customer with today’s date in the CustomerOrdertable.

INSERT INTO CustomerOrder (OrderId, CustomerId, OrderDate)
VALUES 
    (1, 1, CURDATE()),
    (2, 2, CURDATE());

-- Insert a payment of $49.99 for Emma's order using PaymentMethodId 1. Do not specify the PaymentId.
INSERT INTO Payment (OrderId, Amount)
VALUES (
    (SELECT co.OrderId 
     FROM CustomerOrder co
     JOIN Customer c ON co.CustomerId = c.CustomerId
     WHERE c.CustomerName = 'Emma Rivera'
     LIMIT 1),
    49.99
);

-- Try inserting a payment using PaymentMethodId = 999. What happens?

-- PaymentMethodId has constraints that prevent it from being updated

-- Insert three additional customers in a single INSERT statement:

INSERT INTO Customer (CustomerName)
VALUES 
    ('Liam Davis'),
    ('Olivia Brooks'),
    ('Sophia Martinez');

--  Insert a bulk list of two orders (use today’s date) for any two of the new customers.

INSERT INTO CustomerOrder (CustomerId, OrderDate)
VALUES 
    (3, CURDATE()),
    (4, CURDATE());

-- ● What happens if you try to insert a record that violates a foreign key constraint?

-- Error message saying those fields cannot be externally added

-- ● Why is using auto-increment helpful for primary keys?

-- Because one doesn't know the data that is currently there or their id values

-- ● What are the benefits of bulk inserting records?

-- More efficient, less querying.