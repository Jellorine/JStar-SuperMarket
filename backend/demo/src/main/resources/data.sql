-- Insert Categories
INSERT INTO category (id, name, description) VALUES
(1, 'Beverages', 'Drinks, juices, and more'),
(2, 'Snacks', 'Chips, biscuits, and other snacks'),
(3, 'Personal Care', 'Soaps, shampoos, and more');

-- Insert Suppliers
INSERT INTO supplier (id, name, contact_person, phone, email, address) VALUES
(1, 'ABC Distributors', 'John Doe', '0771234567', 'abc@example.com', 'Colombo'),
(2, 'Snack World', 'Jane Smith', '0777654321', 'snacks@example.com', 'Jaffna'),
(3, 'Daily Essentials Inc', 'Vaanithasan', '0778965324', 'essentials@example.com', 'Batticaloa');

-- Insert Customers
INSERT INTO customer (id, name, email, phone, loyalty_points) VALUES
(1, 'John Doe', 'john.doe@example.com', '0771234567', 100),
(2, 'Jane Smith', 'jane.smith@example.com', '0777654321', 150);

-- Insert Products
INSERT INTO product (id, name, item_code, description, category_id, supplier_id, price, cost_price, quantity_in_stock, unit, status) VALUES
(1, 'Coca Cola 1L', '1234567890001', 'Soft drink', 1, 1, 200.00, 150.00, 50, 'bottle', true),
(2, 'Pepsi 1L', '1234567890002', 'Carbonated beverage', 1, 1, 190.00, 145.00, 40, 'bottle', true),
(3, 'Sun Chips 200g', '1234567890003', 'Wheat snacks', 2, 2, 130.00, 90.00, 60, 'packet', true),
(4, 'KitKat 4 Finger', '1234567890004', 'Chocolate wafer', 2, 2, 180.00, 140.00, 30, 'bar', true),
(5, 'Lifebuoy Soap 100g', '1234567890005', 'Health soap', 3, 3, 80.00, 60.00, 100, 'piece', true),
(6, 'Sunlight Detergent 1kg', '1234567890006', 'Washing powder', 3, 3, 320.00, 250.00, 25, 'packet', true),
(7, 'Sprite 500ml', '1234567890007', 'Lemon-lime drink', 1, 1, 120.00, 90.00, 70, 'bottle', true),
(8, 'Milo 200ml', '1234567890008', 'Chocolate milk drink', 1, 2, 90.00, 70.00, 80, 'box', true),
(9, 'Chocolate Cookies 150g', '1234567890009', 'Cookies with chocolate chips', 2, 2, 160.00, 110.00, 55, 'packet', true),
(10, 'Lux Soap 100g', '1234567890010', 'Beauty soap', 3, 3, 85.00, 65.00, 95, 'piece', true);

--Insert Users
INSERT INTO user (id, username, password, name, role, status) VALUES
(1, 'admin', 'admin123', 'Admin User', 'ADMIN', true),
(2, 'Rahul', 'rahul123', 'Rahul', 'CASHIER', true),
(3, 'John', 'john123', 'John', 'MANAGER', true),
(4, 'Mark', 'mark123', 'Mark', 'CASHIER', false),
(5, 'Sara', 'sara123', 'Sara', 'STOCK_MANAGER', true);

-- Insert Sales
INSERT INTO sale (
    id, 
    invoice_number, 
    customer_id, 
    user_id, 
    total_amount, 
    payment_method, 
    discount, 
    net_amount, 
    sale_date
) VALUES (
    1, 
    'INV001', 
    1, 
    1, 
    1000.00, 
    'CASH', 
    50.00, 
    950.00, 
    '2024-05-04 10:30:00'
);

-- Insert Sale Items
INSERT INTO sale_item (id, sale_id, product_id, quantity, price, total) VALUES
(1, 1, 1, 1, 200.00, 200.00),
(2, 1, 2, 1, 120.00, 120.00);
