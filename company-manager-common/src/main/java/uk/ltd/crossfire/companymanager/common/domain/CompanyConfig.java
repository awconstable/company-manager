package uk.ltd.crossfire.companymanager.common.domain;

import java.io.Serializable;

public class CompanyConfig implements Serializable {

	private static final long serialVersionUID = 1164548666322953805L;

	private String key;
	private String value;

	public CompanyConfig() {
	}

	public CompanyConfig(String key, String value){
		this.setKey(key);
		this.setValue(value);
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CompanyConfig [key=");
		builder.append(key);
		builder.append(", value=");
		builder.append(value);
		builder.append("]");
		return builder.toString();
	}

}
