package reports;

import models.Product;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class CSVExporter {
    public static void export(String reportPath, List<Product> products) throws IOException {
        Path path = Paths.get(reportPath, "productsReport.csv");

        String header = "Id,Description,Price" + System.lineSeparator();
        Files.writeString(path, header, StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        for(Product product : products) {
            String line = product.getId() + "," +
                    product.getDescription() + "," +
                    product.getPrice() + System.lineSeparator();
            Files.writeString(path, line, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        }
    }
}
