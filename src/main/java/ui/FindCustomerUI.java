package ui;

import models.Customer;
import repository.CustomerDB;

import java.util.Scanner;

public class FindCustomerUI {
    CustomerDB customerDB = new CustomerDB();

    public void show() {
        System.out.println("-------OBTENDO DADOS DE CLIENTE--------");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o ID do cliente: ");
        String id = scanner.nextLine();

        Customer customer = customerDB.getCustomerById(id);

        if (customer != null) {
            System.out.println("Primeiro nome: " + customer.getFirstName());
            System.out.println("Último nome: " +  customer.getLastName());
            System.out.println("Endereço: " +  customer.getAddress());
            System.out.println("Telefone de contato: " + customer.getPhoneNumber());
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }
}
