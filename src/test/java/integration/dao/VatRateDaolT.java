package integration.dao;

import integration.AbstractDaoIT;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import uk.ltd.crossfire.companymanager.server.dao.VatRateDao;
import uk.ltd.crossfire.companymanager.shared.entities.VatRate;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class VatRateDaolT extends AbstractDaoIT {

	@Autowired
	private VatRateDao dao;

	@Test
	public void testGetContacts() {
		List<VatRate> rates = dao.getVatRates();

		assertTrue(rates.size() > 1);
	}

}
