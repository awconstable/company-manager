package uk.ltd.crossfire.companymanager.server.persistence;

import java.util.List;

import uk.ltd.crossfire.companymanager.common.domain.CompanyConfig;

public interface ConfigMapper {

	CompanyConfig getOption(String key);

	List<CompanyConfig> getOptions();

	void setOption(CompanyConfig config);

}
