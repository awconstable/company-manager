package uk.ltd.crossfire.companymanager.server.service;

import uk.ltd.crossfire.companymanager.shared.entities.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getProducts();

    public Product getProduct(int id);

}
