CREATE TABLE orders (
    id VARCHAR(30) PRIMARY KEY,
    customer_id VARCHAR(30) NOT NULL,
    product_id VARCHAR(30) NOT NULL,
    quantity INT NOT NULL,
    total_price DECIMAL NOT NULL,
    order_date DATE NOT NULL
);