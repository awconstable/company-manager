package uk.ltd.crossfire.companymanager.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.ltd.crossfire.companymanager.shared.entities.CompanyConfig;
import uk.ltd.crossfire.companymanager.server.exceptions.CompanyManagerSystemException;
import uk.ltd.crossfire.companymanager.server.persistence.ConfigMapper;

@Service
public class CompanyConfigServiceImpl implements CompanyConfigService {

	@Autowired
	private ConfigMapper dao;

	@Override
	public List<CompanyConfig> getOptions() {
		return dao.getOptions();
	}

	@Override
	public CompanyConfig getOption(String key) throws CompanyManagerSystemException {
		return dao.getOption(key);
	}

	@Override
	public void setOption(CompanyConfig option) throws CompanyManagerSystemException {
		dao.setOption(option);
	}

}
