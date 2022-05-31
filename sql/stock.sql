CREATE TABLE stock (
    id VARCHAR(30) PRIMARY KEY,
    product_id VARCHAR(30) NOT NULL,
    supplier_id VARCHAR(30) NOT NULL,
    quantity INT NOT NULL,
    entry_date DATE NOT NULL
);