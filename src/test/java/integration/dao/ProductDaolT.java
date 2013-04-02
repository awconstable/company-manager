package integration.dao;

import integration.AbstractDaoIT;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import uk.ltd.crossfire.companymanager.server.dao.ProductDao;
import uk.ltd.crossfire.companymanager.shared.entities.Product;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProductDaolT extends AbstractDaoIT {

	@Autowired
	private ProductDao dao;

	@Test
	public void testGetProduct() {
		Product product = dao.getProduct(12);

		System.out.print(product.toString());

		assertEquals(12, product.getId());
	}

	@Test
	public void testGetProducts() {
		List<Product> products = dao.getProducts();

		assertTrue(products.size() > 0);
	}

}
