package repository;

import models.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDB {
    private List<Product> products;

    public ProductDB() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        String query = "INSERT INTO products(id, description, price) VALUES (\"" + product.getId() + "\", \"" + product.getDescription() + "\"," + product.getPrice() + ");";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/sellerapp", "root", null);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Product getProductById(int productId) {
        for (Product product : products) {
            if (product.getId().equals(productId))
                return product;
        }

        return null;
    }

    public List<Product> getProducts() {
        List<Product> persistedProducts = new ArrayList<>();

        String query = "SELECT * FROM products;";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/sellerapp", "root", null);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                String id = resultSet.getString("id");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");

                Product product = new Product(id, description, price);
                persistedProducts.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return persistedProducts;
    }
}
