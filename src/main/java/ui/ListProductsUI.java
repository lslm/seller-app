package ui;

import models.Product;
import repository.ProductDB;

public class ListProductsUI {
    ProductDB productsDb = new ProductDB();

    public void show() {
        System.out.println("----------LISTANDO PRODUTOS----------");
        for(Product product : productsDb.getProducts()) {
            System.out.println("ID: " + product.getId());
            System.out.println("Descrição: " + product.getDescription());
            System.out.println("Preço: " + product.getPrice());
            System.out.println("-----------------------------------------");
        }
    }
}
