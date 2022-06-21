CREATE TABLE orders (
    id VARCHAR(30) PRIMARY KEY,
    customer_id VARCHAR(30) NOT NULL,
    product_id VARCHAR(30) NOT NULL,
    quantity INT NOT NULL
);