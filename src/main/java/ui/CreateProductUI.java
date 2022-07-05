package ui;

import models.Product;
import repository.ProductDB;

import java.util.Scanner;

public class CreateProductUI implements IUserInterface {
    ProductDB productsDb = new ProductDB();

    public void show() {
        System.out.println("-------CRIANDO NOVO PRODUTO-------");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe a descrição do produto: ");
        String description = scanner.nextLine();

        System.out.print("Informe um ID do produto: ");
        String id = scanner.nextLine();

        System.out.print("Informe o preço: ");
        double price = scanner.nextDouble();

        Product newProduct = new Product(id, description, price);
        productsDb.addProduct(newProduct);
    }
}
