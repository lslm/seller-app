package ui;

import models.Product;
import reports.CSVExporter;
import repository.ProductDB;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ExportProductsUI {
    ProductDB productsDb = new ProductDB();

    public void show() {
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
    }
}
