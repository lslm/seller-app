package repository;

import models.Supplier;

import java.util.ArrayList;
import java.util.List;

public class SupplierDB {
    private List<Supplier> suppliers;

    public SupplierDB() {
        this.suppliers = new ArrayList<>();
    }

    public void addSupplier(Supplier supplier) {
        suppliers.add(supplier);
    }
}
