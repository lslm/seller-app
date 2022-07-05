import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import repository.*;
import ui.*;

public class SellerApp {
    public static void main(String... args) {
        System.out.println("Boas vindas ao Seller App");

        int option;

        Map<Integer, IUserInterface> optionsUserInterfaces = new HashMap<>();
        optionsUserInterfaces.put(1, new CreateProductUI());
        optionsUserInterfaces.put(2, new ListProductsUI());
        optionsUserInterfaces.put(3, new FindProductUI());
        optionsUserInterfaces.put(4, new CreateSupplierUI());
        optionsUserInterfaces.put(5, new CreateCustomerUI());
        optionsUserInterfaces.put(6, new ListCustomersUI());
        optionsUserInterfaces.put(7, new FindCustomerUI());
        optionsUserInterfaces.put(8, new ExportProductsUI());
        optionsUserInterfaces.put(9, new CreateOrderUI());
        optionsUserInterfaces.put(10, new ListOrdersUI());

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

            if (option != 0) {
                IUserInterface ui = optionsUserInterfaces.get(option);
                ui.show();
            }
        } while (option != 0);

        Configuration.closeConnection();
    }
}
