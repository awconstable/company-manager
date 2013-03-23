package uk.ltd.crossfire.companymanager.shared.entities;

public class Product {

    private int id;
    private String productRef;
    private String description;
    private double retailCost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductRef() {
        return productRef;
    }

    public void setProductRef(String productRef) {
        this.productRef = productRef;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRetailCost() {
        return retailCost;
    }

    public void setRetailCost(double retailCost) {
        this.retailCost = retailCost;
    }
}
