package db;

import models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDB {
    private List<Product> products;

    public ProductDB() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product getProductById(int productId) {
        for (Product product : products) {
            if (product.getId().equals(productId))
                return product;
        }

        return null;
    }

    public List<Product> getProducts() {
        return products;
    }
}
