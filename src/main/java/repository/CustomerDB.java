package repository;

import models.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CustomerDB {
    public List<Customer> getCustomers() {
        return null;
    }

    public Customer getCustomerById() {
        return null;
    }

    public void addCustomer(Customer customer) {
        String query = "INSERT INTO customers(id, first_name, last_name, address, phone_number) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection connection = Configuration.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, customer.getId());
            preparedStatement.setString(2, customer.getFirstName());
            preparedStatement.setString(3, customer.getLastName());
            preparedStatement.setString(4, customer.getAddress());
            preparedStatement.setString(5, customer.getPhoneNumber());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
