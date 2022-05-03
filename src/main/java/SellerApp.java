import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.Product;

public class SellerApp {
    static List<Product> productsDb = new ArrayList<>();

    public static void main(String... args) {
        System.out.println("Boas vindas ao Seller App");

        int option;

        do {
            System.out.println("------- MENU PRINCIPAL --------");
            System.out.println("1 - Cadastrar um novo produto");
            System.out.println("2 - Listar todos os produtos cadastrados");
            System.out.println("0 - Sair do programa");

            System.out.print("Escolha uma operação: ");
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextInt();

            process(option);
        } while (option != 0);
    }

    static void process(int option) {
        switch (option) {
            case 1: {
                Scanner scanner = new Scanner(System.in);

                System.out.print("Informe a descrição do produto: ");
                String description = scanner.nextLine();

                System.out.print("Informe um ID do produto: ");
                String id = scanner.nextLine();

                System.out.print("Informe o preço: ");
                double price = scanner.nextDouble();

                Product newProduct = new Product(id, description, price);
                productsDb.add(newProduct);

                break;
            }

            case 2: {
                System.out.println("---------- LISTANDO PRODUTOS ----------");
                for(Product product : productsDb) {
                    System.out.println("ID: " + product.getId());
                    System.out.println("Descrição: " + product.getDescription());
                    System.out.println("Preço: " + product.getPrice());
                    System.out.println("-----------------------------------------");
                }
            }
        }
    }
}
