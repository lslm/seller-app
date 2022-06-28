import java.util.Scanner;
import repository.*;
import ui.*;

public class SellerApp {
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
                CreateProductUI createProductUI = new CreateProductUI();
                createProductUI.show();
                break;
            }

            case 2: {
                ListProductsUI listProductsUI = new ListProductsUI();
                listProductsUI.show();
                break;
            }

            case 3: {
                FindProductUI findProductUI = new FindProductUI();
                findProductUI.show();
                break;
            }

            case 4: {
                CreateSupplierUI createSupplierUI = new CreateSupplierUI();
                createSupplierUI.show();
                break;
            }

            case 5: {
                CreateCustomerUI createCustomerUI = new CreateCustomerUI();
                createCustomerUI.show();
                break;
            }

            case 6: {
                ListCustomersUI listCustomersUI = new ListCustomersUI();
                listCustomersUI.show();
                break;
            }

            case 7: {
                FindCustomerUI findCustomerUI = new FindCustomerUI();
                findCustomerUI.show();
                break;
            }

            case 8: {
                ExportProductsUI exportProductsUI = new ExportProductsUI();
                exportProductsUI.show();
                break;
            }

            case 9: {
                CreateOrderUI createOrderUI = new CreateOrderUI();
                createOrderUI.show();
                break;
            }

            case 10: {
                ListOrdersUI listOrdersUI = new ListOrdersUI();
                listOrdersUI.show();
                break;
            }
        }
    }
}
