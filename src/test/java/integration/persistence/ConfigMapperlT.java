package integration.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import integration.AbstractDaoIT;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import uk.ltd.crossfire.companymanager.shared.entities.CompanyConfig;
import uk.ltd.crossfire.companymanager.server.persistence.ConfigMapper;

public class ConfigMapperlT extends AbstractDaoIT {

	@Autowired
	private ConfigMapper dao;

	@Test
	public void testGetOptions() {
		List<CompanyConfig> options = dao.getOptions();

		for(CompanyConfig option:options){
			System.out.println("key : " + option.getKey() + ", value : " + option.getValue());
		}

		assertTrue(options.size() > 0);
	}

	@Test
	public void testGetOption() throws Exception {
		CompanyConfig bankName = dao.getOption("testKey");

		assertEquals("testValue2", bankName.getValue());
	}

	@Test
	public void testSetOption() throws Exception {
		CompanyConfig config = new CompanyConfig("testKey", "testValue");
		dao.setOption(config);

		//FIXME this will only test update unless the database is cleared down
		CompanyConfig result = dao.getOption("testKey");

		assertEquals(config.getValue(), result.getValue());

		config.setValue("testValue2");

		dao.setOption(config);

		result = dao.getOption("testKey");

		//check update
		assertEquals(config.getValue(), result.getValue());
	}

}
