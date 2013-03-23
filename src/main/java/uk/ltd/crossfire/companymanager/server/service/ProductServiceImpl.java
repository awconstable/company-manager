package uk.ltd.crossfire.companymanager.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ltd.crossfire.companymanager.server.dao.ContactDao;
import uk.ltd.crossfire.companymanager.server.dao.ProductDao;
import uk.ltd.crossfire.companymanager.shared.entities.Contact;
import uk.ltd.crossfire.companymanager.shared.entities.Product;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getProducts() {
        return productDao.getProducts();
    }

    @Override
    public Product getProduct(int id) {
        return productDao.getProduct(id);
    }
}
