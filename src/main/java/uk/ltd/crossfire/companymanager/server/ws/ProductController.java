package uk.ltd.crossfire.companymanager.server.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import uk.ltd.crossfire.companymanager.server.service.ContactService;
import uk.ltd.crossfire.companymanager.server.service.ProductService;
import uk.ltd.crossfire.companymanager.shared.entities.Contact;
import uk.ltd.crossfire.companymanager.shared.entities.Product;

import java.util.List;

@RequestMapping(value = "/products")
@Controller
public class ProductController {

    private final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<Product> getContacts() {

        List<Product> products = productService.getProducts();

        if(products != null){
            log.debug("Products : {}", products);
        }

        return products;
    }

    @RequestMapping(value = "/{id}")
    public @ResponseBody
    Product getProduct(@PathVariable int id) {

        Product product = productService.getProduct(id);

        if(product != null){
            log.debug("Product : {}", product);
        }

        return product;
    }

}
