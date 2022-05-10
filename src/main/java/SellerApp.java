import java.util.Scanner;

import models.Supplier;
import repository.ProductDB;
import models.Product;
import repository.SupplierDB;

public class SellerApp {
    static ProductDB productsDb = new ProductDB();
    static SupplierDB supplierDB = new SupplierDB();

    public static void main(String... args) {
        System.out.println("Boas vindas ao Seller App");

        int option;

        do {
            System.out.println("------- MENU PRINCIPAL --------");
            System.out.println("1 - Cadastrar um novo produto");
            System.out.println("2 - Listar todos os produtos cadastrados");
            System.out.println("3 - Criar um novo fornecedor");
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
                productsDb.addProduct(newProduct);

                break;
            }

            case 2: {
                System.out.println("---------- LISTANDO PRODUTOS ----------");
                for(Product product : productsDb.getProducts()) {
                    System.out.println("ID: " + product.getId());
                    System.out.println("Descrição: " + product.getDescription());
                    System.out.println("Preço: " + product.getPrice());
                    System.out.println("-----------------------------------------");
                }
            }

            case 3: {
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

                break;
            }
        }
    }
}
