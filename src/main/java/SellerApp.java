import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import models.Customer;
import models.Order;
import models.Supplier;
import reports.CSVExporter;
import repository.*;
import models.Product;

public class SellerApp {
    static ProductDB productsDb = new ProductDB();
    static SupplierDB supplierDB = new SupplierDB();
    static CustomerDB customerDB = new CustomerDB();
    static OrderDB orderDB = new OrderDB();

    public static void main(String... args) {
        System.out.println("Boas vindas ao Seller App");

        int option;

        do {
            System.out.println("-------MENU PRINCIPAL--------");
            System.out.println("1 - Cadastrar um novo produto");
            System.out.println("2 - Listar todos os produtos cadastrados");
            System.out.println("3 - Obter dados de um produto");
            System.out.println("4 - Criar um novo fornecedor");
            System.out.println("5 - Cadastrar um novo cliente");
            System.out.println("6 - Listar todos os clientes cadastrados");
            System.out.println("7 - Buscar cliente");
            System.out.println("8 - Exportar dados de produtos");
            System.out.println("9 - Criar pedido de venda");
            System.out.println("10 - Listar pedidos de vendas");
            System.out.println("0 - Sair do programa");

            System.out.print("Escolha uma operação: ");
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextInt();

            process(option);
        } while (option != 0);

        Configuration.closeConnection();
    }

    static void process(int option) {
        switch (option) {
            case 1: {
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

                break;
            }

            case 2: {
                System.out.println("----------LISTANDO PRODUTOS----------");
                for(Product product : productsDb.getProducts()) {
                    System.out.println("ID: " + product.getId());
                    System.out.println("Descrição: " + product.getDescription());
                    System.out.println("Preço: " + product.getPrice());
                    System.out.println("-----------------------------------------");
                }
                break;
            }

            case 3: {
                System.out.println("-------OBTENDO DADOS DE PRODUTO--------");
                Scanner scanner = new Scanner(System.in);

                System.out.print("Informe um ID do produto: ");
                String id = scanner.nextLine();

                Product product = productsDb.getProductById(id);

                System.out.println("ID: " + product.getId());
                System.out.println("Descrição: " + product.getDescription());
                System.out.println("Preço: " + product.getPrice());
                System.out.println("-----------------------------------------");

                break;
            }

            case 4: {
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

            case 5: {
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

                break;
            }

            case 6: {
                List<Customer> customers = customerDB.getCustomers();

                System.out.println("------LISTANDO CLIENTES CADASTRADOS------");
                for (Customer customer :  customers) {
                    System.out.println("ID: " + customer.getId() +
                            "\t - Nome: " + customer.getFirstName() + " " + customer.getLastName() +
                            "\t - Endereço: " + customer.getAddress() +
                            "\t - Telefone: " + customer.getPhoneNumber());
                }

                break;
            }

            case 7: {
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

                break;
            }

            case 8: {
                System.out.println("Exportando dados de produtos...");
                Scanner scanner = new Scanner(System.in);

                System.out.print("Para onde você deseja exportar o arquivo: ");
                String path = scanner.nextLine();

                List<Product> products = productsDb.getProducts();

                try {
                    CSVExporter.export(path, products);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;
            }

            case 9: {
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

                break;
            }

            case 10: {
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
    }
}
