package ui;

import models.Customer;
import models.Order;
import models.Product;
import repository.CustomerDB;
import repository.OrderDB;
import repository.ProductDB;

import java.util.Scanner;

public class CreateOrderUI implements IUserInterface {
    CustomerDB customerDB = new CustomerDB();
    ProductDB productsDb = new ProductDB();
    OrderDB orderDB = new OrderDB();

    public void show() {
        System.out.println("Criando pedido de venda");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o ID do pedido: ");
        String id = scanner.nextLine();

        System.out.print("Qual produto você deseja criar a venda: ");
        String productId = scanner.nextLine();

        System.out.print("Para qual cliente você deseja criar a venda: ");
        String customerId = scanner.nextLine();

        System.out.print("Qual a quantidade você deseja vender: ");
        int quantity = scanner.nextInt();

        Customer customer = customerDB.getCustomerById(customerId);
        Product product = productsDb.getProductById(productId);

        Order order = new Order(id, customer, product, quantity);

        orderDB.addOrder(order);
    }
}
