-- User Table
CREATE TABLE User (
    UserID INT PRIMARY KEY,
    Name VARCHAR(255),
    Email VARCHAR(255) UNIQUE,
    Password VARCHAR(255),
    ContactNumber VARCHAR(20),
    Address TEXT
);

-- Courier Table
CREATE TABLE Courier (
    CourierID INT PRIMARY KEY,
    SenderName VARCHAR(255),
    SenderAddress TEXT,
    ReceiverName VARCHAR(255),
    ReceiverAddress TEXT,
    Weight DECIMAL(5, 2),
    Status VARCHAR(50),
    TrackingNumber VARCHAR(20) UNIQUE,
    DeliveryDate DATE,
    UserID INT,
    FOREIGN KEY (UserID) REFERENCES User(UserID)
);

-- CourierServices Table
CREATE TABLE CourierServices (
    ServiceID INT PRIMARY KEY,
    ServiceName VARCHAR(100),
    Cost DECIMAL(8, 2)
);

-- Employee Table
CREATE TABLE Employee (
    EmployeeID INT PRIMARY KEY,
    Name VARCHAR(255),
    Email VARCHAR(255) UNIQUE,
    ContactNumber VARCHAR(20),
    Role VARCHAR(50),
    Salary DECIMAL(10, 2)
);

-- Location Table
CREATE TABLE Location (
    LocationID INT PRIMARY KEY,
    LocationName VARCHAR(100),
    Address TEXT
);

-- Payment Table
CREATE TABLE Payment (
    PaymentID INT PRIMARY KEY,
    CourierID INT,
    LocationID INT,
    Amount DECIMAL(10, 2),
    PaymentDate DATE,
    FOREIGN KEY (CourierID) REFERENCES Courier(CourierID),
    FOREIGN KEY (LocationID) REFERENCES Location(LocationID)
);

-- Inserting data into User table
INSERT INTO User (UserID, Name, Email, Password, ContactNumber, Address)
VALUES
    (1, 'John Doe', 'john.doe@example.com', 'password123', '123-456-7890', '123 Main St, City'),
    (2, 'Jane Smith', 'jane.smith@example.com', 'pass456', '987-654-3210', '456 Oak St, Town'),
    (3, 'Bob Johnson', 'bob.johnson@example.com', 'pass789', '111-222-3333', '789 Pine St, Village'),
    (4, 'Alice Brown', 'alice.brown@example.com', 'secret', '555-555-5555', '456 Elm St, City'),
    (5, 'Charlie White', 'charlie.white@example.com', 'topsecret', '999-888-7777', '789 Maple St, Town');

-- Inserting data into Courier table
INSERT INTO Courier (CourierID, SenderName, SenderAddress, ReceiverName, ReceiverAddress, Weight, Status, TrackingNumber, DeliveryDate, UserID)
VALUES
    (1, 'Sender1', '123 Sender St, City', 'Receiver1', '456 Receiver St, Town', 3.5, 'In Transit', 'TN123', '2024-01-25', 1),
    (2, 'Sender2', '789 Sender St, Village', 'Receiver2', '456 Receiver St, City', 2.0, 'Delivered', 'TN456', '2024-01-23', 2),
    (3, 'Sender3', '987 Sender St, Town', 'Receiver3', '123 Receiver St, Village', 1.8, 'Processing', 'TN789', NULL, 3),
    (4, 'Sender4', '456 Sender St, City', 'Receiver4', '789 Receiver St, Town', 4.2, 'In Transit', 'TN101', '2024-01-26', 4),
    (5, 'Sender5', '654 Sender St, Village', 'Receiver5', '987 Receiver St, City', 2.5, 'Delivered', 'TN202', '2024-01-24', 5);

-- Inserting data into CourierServices table
INSERT INTO CourierServices (ServiceID, ServiceName, Cost)
VALUES
    (1, 'Standard Delivery', 10.99),
    (2, 'Express Delivery', 20.99),
    (3, 'Same-day Delivery', 30.99);

-- Inserting data into Employee table
INSERT INTO Employee (EmployeeID, Name, Email, ContactNumber, Role, Salary)
VALUES
    (1, 'Manager1', 'manager1@example.com', '111-111-1111', 'Manager', 50000.00),
    (2, 'CourierStaff1', 'courier1@example.com', '222-222-2222', 'Courier Staff', 30000.00),
    (3, 'CourierStaff2', 'courier2@example.com', '333-333-3333', 'Courier Staff', 30000.00),
    (4, 'Admin1', 'admin1@example.com', '444-444-4444', 'Admin', 60000.00),
    (5, 'Admin2', 'admin2@example.com', '555-555-5555', 'Admin', 60000.00);

-- Inserting data into Location table
INSERT INTO Location (LocationID, LocationName, Address)
VALUES
    (1, 'Location1', '123 Main St, City'),
    (2, 'Location2', '456 Oak St, Town'),
    (3, 'Location3', '789 Pine St, Village'),
    (4, 'Location4', '456 Elm St, City'),
    (5, 'Location5', '789 Maple St, Town');

-- Inserting data into Payment table
INSERT INTO Payment (PaymentID, CourierID, LocationID, Amount, PaymentDate)
VALUES
    (1, 1, 1, 15.99, '2024-01-26'),
    (2, 2, 2, 25.99, '2024-01-24'),
    (3, 3, 3, 35.99, '2024-01-23'),
    (4, 4, 4, 18.99, '2024-01-25'),
    (5, 5, 5, 28.99, '2024-01-27');
