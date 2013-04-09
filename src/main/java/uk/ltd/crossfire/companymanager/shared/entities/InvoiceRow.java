package uk.ltd.crossfire.companymanager.shared.entities;

import java.io.Serializable;

/**
 * User: awconstable
 * Date: 03/04/2013
 * Time: 21:47
 */
public class InvoiceRow implements Serializable {

    private int id;

    private Integer productId;

    private Integer lineNumber;

    private Double quantity;

    private Double retailCost;

    private Integer discount;

    private Double discountCost;

    private Double lineTotal;

    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getRetailCost() {
        return retailCost;
    }

    public void setRetailCost(Double retailCost) {
        this.retailCost = retailCost;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Double getDiscountCost() {
        return discountCost;
    }

    public void setDiscountCost(Double discountCost) {
        this.discountCost = discountCost;
    }

    public Double getLineTotal() {
        return lineTotal;
    }

    public void setLineTotal(Double lineTotal) {
        this.lineTotal = lineTotal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
