package ui;

import models.Customer;
import repository.CustomerDB;

import java.util.Scanner;

public class CreateCustomerUI {
    CustomerDB customerDB = new CustomerDB();

    public void show() {
        System.out.println("-------CRIANDO NOVO CLIENTE-------");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o identificador do cliente: ");
        String id = scanner.nextLine();

        System.out.print("Informe o primeiro nome do cliente: ");
        String firstName = scanner.nextLine();

        System.out.print("Informe o último nome: ");
        String lastName = scanner.nextLine();

        System.out.print("Informe o endereço (até 100 caracteres): ");
        String address = scanner.nextLine();

        System.out.print("Informe o telefone de contato: ");
        String phoneNumber = scanner.nextLine();

        Customer customer = new Customer(id, firstName, lastName, address, phoneNumber);

        customerDB.addCustomer(customer);
    }
}
