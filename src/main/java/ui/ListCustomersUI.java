package ui;

import models.Customer;
import repository.CustomerDB;

import java.util.List;

public class ListCustomersUI {
    CustomerDB customerDB = new CustomerDB();

    public void show() {
        List<Customer> customers = customerDB.getCustomers();

        System.out.println("------LISTANDO CLIENTES CADASTRADOS------");
        for (Customer customer :  customers) {
            System.out.println("ID: " + customer.getId() +
                    "\t - Nome: " + customer.getFirstName() + " " + customer.getLastName() +
                    "\t - Endereço: " + customer.getAddress() +
                    "\t - Telefone: " + customer.getPhoneNumber());
        }
    }
}
