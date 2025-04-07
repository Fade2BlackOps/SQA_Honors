-- Delete previous "books" table if it exists
DROP TABLE IF EXISTS books;

-- Customers
CREATE TABLE IF NOT EXISTS Customers (
    ID INTEGER PRIMARY KEY AUTOINCREMENT,
    Name TEXT NOT NULL,
    Email TEXT UNIQUE,
    Address TEXT,
    Phone TEXT
);

-- Authors
CREATE TABLE IF NOT EXISTS Authors (
    ID INTEGER PRIMARY KEY AUTOINCREMENT,
    Name TEXT NOT NULL,
    Email TEXT,
    Address TEXT,
    Phone TEXT
);

-- Publishers
CREATE TABLE IF NOT EXISTS Publishers (
    ID INTEGER PRIMARY KEY AUTOINCREMENT,
    Name TEXT NOT NULL,
    Email TEXT,
    Address TEXT,
    Phone TEXT
);

-- Logins
CREATE TABLE IF NOT EXISTS Logins (
    PersonID INTEGER PRIMARY KEY,
    Email TEXT NOT NULL UNIQUE,
    Password TEXT NOT NULL,
    Role TEXT NOT NULL CHECK (Role IN ('Customer', 'Author', 'Publisher'))
);

-- Stores
CREATE TABLE IF NOT EXISTS Stores (
    ID INTEGER PRIMARY KEY AUTOINCREMENT,
    Name TEXT NOT NULL,
    Address TEXT,
    Phone TEXT,
    BusinessLicense TEXT
);

-- Store_Items (many-to-many relationship between Stores and Books)
CREATE TABLE IF NOT EXISTS Store_Items (
    StoreID INTEGER NOT NULL,
    ItemID INTEGER NOT NULL,
    PRIMARY KEY (StoreID, ItemID),
    FOREIGN KEY (StoreID) REFERENCES Stores(ID),
    FOREIGN KEY (ItemID) REFERENCES Books(ID)
);

-- Books
CREATE TABLE IF NOT EXISTS Books (
    ID INTEGER PRIMARY KEY AUTOINCREMENT,
    Title TEXT NOT NULL,
    ISBN TEXT UNIQUE,
    AuthorID INTEGER,
    PublisherID INTEGER,
    PageCount INTEGER,
    Price REAL,
    Genre TEXT,
    BookType TEXT,
    FilePath TEXT,
    FOREIGN KEY (AuthorID) REFERENCES Authors(ID),
    FOREIGN KEY (PublisherID) REFERENCES Publishers(ID)
);

-- Orders
CREATE TABLE IF NOT EXISTS Orders (
    ID INTEGER PRIMARY KEY AUTOINCREMENT,
    CustomerID INTEGER,
    Date TEXT NOT NULL, -- use ISO date string (e.g., 2025-04-07)
    ShippingMethod TEXT,
    TotalCost REAL,
    PaymentID INTEGER,
    FOREIGN KEY (CustomerID) REFERENCES Customers(ID),
    FOREIGN KEY (PaymentID) REFERENCES Payments(ID)
);

-- Customer_Payments (a customer can have multiple payment methods)
CREATE TABLE IF NOT EXISTS Customer_Payments (
    ID INTEGER PRIMARY KEY AUTOINCREMENT,
    CustomerID INTEGER NOT NULL,
    PaymentID INTEGER NOT NULL,
    FOREIGN KEY (CustomerID) REFERENCES Customers(ID),
    FOREIGN KEY (PaymentID) REFERENCES Payments(ID)
);

-- Payments
CREATE TABLE IF NOT EXISTS Payments (
    ID INTEGER PRIMARY KEY AUTOINCREMENT,
    Date TEXT NOT NULL,
    DebitID INTEGER,
    CreditID INTEGER,
    GiftID INTEGER,
    TotalAmount REAL
);

-- Cards (used for both credit and debit)
CREATE TABLE IF NOT EXISTS Cards (
    ID INTEGER PRIMARY KEY AUTOINCREMENT,
    Number TEXT NOT NULL,
    HolderName TEXT NOT NULL,
    ExpireMonth INTEGER,
    ExpireYear INTEGER,
    CVV TEXT,
    CustomerID INTEGER,
    FOREIGN KEY (CustomerID) REFERENCES Customers(ID)
);

-- GiftCards
CREATE TABLE IF NOT EXISTS GiftCards (
    ID INTEGER PRIMARY KEY AUTOINCREMENT,
    Number TEXT NOT NULL,
    Balance REAL NOT NULL
);

-- Order_Items (many-to-many between Orders and Books)
CREATE TABLE IF NOT EXISTS Order_Items (
    OrderID INTEGER NOT NULL,
    BookID INTEGER NOT NULL,
    Quantity INTEGER NOT NULL DEFAULT 1,
    PRIMARY KEY (OrderID, BookID),
    FOREIGN KEY (OrderID) REFERENCES Orders(ID),
    FOREIGN KEY (BookID) REFERENCES Books(ID)
);
