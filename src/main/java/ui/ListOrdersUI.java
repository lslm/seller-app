package ui;

import models.Order;
import repository.OrderDB;

import java.util.List;

public class ListOrdersUI {
    OrderDB orderDB = new OrderDB();

    public void show() {
        System.out.println("Listando pedidos de venda");

        List<Order> orders = orderDB.getAllOrders();

        for (Order order : orders) {
            System.out.println("----------------------------------------------------------------------");
            System.out.println("ID: " + order.getId() +
                    " - Produto: " + order.getProduct().getDescription() +
                    " - Cliente: " + order.getCustomer().getFirstName() + " " + order.getCustomer().getLastName() +
                    " - Quantidade: " + order.getQuantity());
            System.out.println("----------------------------------------------------------------------");
        }
    }
}
