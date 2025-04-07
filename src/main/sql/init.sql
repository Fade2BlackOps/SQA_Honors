-- Authors
INSERT INTO Authors (Name, Email, Address, Phone) VALUES 
('James Dashner', 'dashner@example.com', '123 Dystopia Ln', '555-0101'),
('Suzanne Collins', 'collins@example.com', '456 Capitol Blvd', '555-0102'),
('Jack Carr', 'carr@example.com', '789 Thriller St', '555-0103'),
('Sarah J. Maas', 'maas@example.com', '321 Fantasy Ave', '555-0104');

-- Publishers
INSERT INTO Publishers (Name, Email, Address, Phone) VALUES 
('Delacorte Press', 'delacorte@example.com', 'New York, NY', '555-0201'),
('Scholastic Press', 'scholastic@example.com', 'New York, NY', '555-0202'),
('Atria/Emily Bestler Books', 'atria@example.com', 'New York, NY', '555-0203'),
('Bloomsbury Publishing', 'bloomsbury@example.com', 'London, UK', '555-0204');

-- Books
INSERT INTO Books (Title, ISBN, AuthorID, PublisherID, PageCount, Price, Genre, BookType, FilePath) VALUES 
('The Maze Runner', '9780385737951', 1, 1, 384, 9.99, 'Science Fiction', 'Paperback', 'books/maze_runner.pdf'),
('The Hunger Games', '9780439023528', 2, 2, 374, 10.99, 'Teen', 'Hardcover', 'books/hunger_games.pdf'),
('The Terminal List', '9781982151258', 3, 3, 416, 11.99, 'Thriller', 'Paperback', 'books/terminal_list.pdf'),
('Throne of Glass', '9781619630345', 4, 4, 432, 12.99, 'Fantasy', 'Paperback', 'books/throne_of_glass.pdf');

-- Customers
INSERT INTO Customers (Name, Email, Address, Phone) VALUES 
('Alex Johnson', 'alexj@example.com', '789 Reader Ln', '555-0301'),
('Emily Rivera', 'emilyr@example.com', '456 Bookworm Rd', '555-0302');

-- Stores
INSERT INTO Stores (Name, Address, Phone, BusinessLicense) VALUES 
('Downtown Bookstore', '100 Main St', '555-0401', 'LIC-123456');

-- Store Items (linking books to the store)
INSERT INTO Store_Items (StoreID, ItemID) VALUES 
(1, 1),
(1, 2),
(1, 3),
(1, 4);

-- Logins with roles
-- IDs match the ones in Customers, Authors, and Publishers tables
INSERT INTO Logins (PersonID, Email, Password, Role) VALUES 
(1, 'alexj@example.com', 'HASHED_PASSWORD_1', 'Customer'),
(2, 'emilyr@example.com', 'HASHED_PASSWORD_2', 'Customer'),
(3, 'dashner@example.com', 'HASHED_PASSWORD_3', 'Author'),
(4, 'delacorte@example.com', 'HASHED_PASSWORD_4', 'Publisher');

-- GiftCards
INSERT INTO GiftCards (Number, Balance) VALUES 
('GIFT123456', 25.00),
('GIFT987654', 50.00);

-- Cards (used as credit or debit)
INSERT INTO Cards (Number, HolderName, ExpireMonth, ExpireYear, CVV, CustomerID) VALUES 
('4111111111111111', 'Alex Johnson', 12, 2026, '123', 1),
('5500000000000004', 'Emily Rivera', 8, 2025, '456', 2);

-- Payments
-- Let's say: Payment 1 used Alex's debit card and a $25 gift card
-- Payment 2 used only Emily's credit card
INSERT INTO Payments (Date, DebitID, CreditID, GiftID, TotalAmount) VALUES 
('2025-04-07', 1, NULL, 1, 34.99),  -- Alex's payment
('2025-04-07', NULL, 2, NULL, 10.99); -- Emily's payment

-- Customer_Payments (link payment methods to customers)
INSERT INTO Customer_Payments (CustomerID, PaymentID) VALUES 
(1, 1),
(2, 2);

-- Orders
INSERT INTO Orders (CustomerID, Date, ShippingMethod, TotalCost, PaymentID) VALUES 
(1, '2025-04-07', 'USPS Priority', 34.99, 1),
(2, '2025-04-07', 'FedEx 2-Day', 10.99, 2);

-- Order_Items (which books are in each order)
INSERT INTO Order_Items (OrderID, BookID, Quantity) VALUES 
(1, 1, 1),  -- Alex bought Maze Runner
(1, 3, 1),  -- Alex bought Terminal List
(2, 2, 1);  -- Emily bought Hunger Games
