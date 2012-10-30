package uk.ltd.crossfire.companymanager.common.domain;

import java.io.Serializable;

public abstract class Entity implements Serializable {

	private static final long serialVersionUID = -8701901450266139526L;

	private Long id;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

}
