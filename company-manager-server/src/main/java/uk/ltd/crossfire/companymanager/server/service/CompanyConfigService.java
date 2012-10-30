package uk.ltd.crossfire.companymanager.server.service;

import java.util.List;

import uk.ltd.crossfire.companymanager.common.domain.CompanyConfig;
import uk.ltd.crossfire.companymanager.server.exceptions.CompanyManagerSystemException;

public interface CompanyConfigService {

	List<CompanyConfig> getOptions();

	CompanyConfig getOption(String key) throws CompanyManagerSystemException;

	void setOption(CompanyConfig option) throws CompanyManagerSystemException;

}
