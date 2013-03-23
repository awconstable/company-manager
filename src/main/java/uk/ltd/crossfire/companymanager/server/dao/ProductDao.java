package uk.ltd.crossfire.companymanager.server.dao;

import uk.ltd.crossfire.companymanager.shared.entities.Product;
import uk.ltd.crossfire.companymanager.shared.entities.VatRate;

import java.util.List;

public interface ProductDao {

    List<Product> getProducts();

    Product getProduct(int id);

}
