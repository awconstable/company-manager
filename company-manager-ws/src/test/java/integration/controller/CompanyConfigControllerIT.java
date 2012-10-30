package integration.controller;
import static org.junit.Assert.assertNotNull;
import integration.AbstractControllerIT;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import uk.ltd.crossfire.companymanager.common.domain.CompanyConfig;
import uk.ltd.crossfire.companymanager.server.ws.CompanyConfigController;


public class CompanyConfigControllerIT extends AbstractControllerIT {

	@Autowired
	CompanyConfigController controller;

	@Test
	public void test() {
		List<CompanyConfig> model = controller.getAllOptions();

		assertNotNull(model);
	}

}
