package ge.model.security;

import java.io.Serializable;

public class Permission implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private Integer permissionId;

	public Permission(String name, Integer permissionId) {
		this.name = name;
		this.permissionId = permissionId;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}
}
