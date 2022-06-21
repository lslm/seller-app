package repository;

import models.Customer;
import models.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDB {
    public void addOrder(Order order) {
        String query = "INSERT INTO orders(id, customer_id, product_id, quantity) VALUES (?, ?, ?, ?)";

        try {
            Connection connection = Configuration.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, order.getId());
            statement.setString(2, order.getCustomer().getId());
            statement.setString(3, order.getProduct().getId());
            statement.setInt(4, order.getQuantity());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
