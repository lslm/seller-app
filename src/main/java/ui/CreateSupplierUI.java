package ui;

import models.Supplier;
import repository.SupplierDB;

import java.util.Scanner;

public class CreateSupplierUI {
    SupplierDB supplierDB = new SupplierDB();

    public void show() {
        System.out.println("-------CRIANDO NOVO FORNECEDOR-------");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o ID do fornecedor: ");
        String id = scanner.nextLine();

        System.out.print("Informe o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Agora informe o telefone: ");
        String phoneNumber = scanner.nextLine();

        Supplier supplier = new Supplier(id, nome, phoneNumber);
        supplierDB.addSupplier(supplier);
    }
}
