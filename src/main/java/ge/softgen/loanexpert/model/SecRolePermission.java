package ge.softgen.loanexpert.model;

import ge.softgen.loanexpert.spring.ApplicationConfig;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Bacho on 3/6/15.
 */
@Entity
@Table(name = "SEC_ROLE_PERMISSIONS")
public class SecRolePermission implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal roleId;
	private BigDecimal permissionId;

	@Id
	@Column(name = "ROLE_ID")
	public BigDecimal getRoleId() {
		return roleId;
	}

	public void setRoleId(BigDecimal roleId) {
		this.roleId = roleId;
	}

	@Id
	@Column(name = "PERMISSION_ID")
	public BigDecimal getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(BigDecimal permissionId) {
		this.permissionId = permissionId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		SecRolePermission that = (SecRolePermission) o;

		if (permissionId != null ? !permissionId.equals(that.permissionId) : that.permissionId != null) return false;
		if (roleId != null ? !roleId.equals(that.roleId) : that.roleId != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = roleId != null ? roleId.hashCode() : 0;
		result = 31 * result + (permissionId != null ? permissionId.hashCode() : 0);
		return result;
	}
}
