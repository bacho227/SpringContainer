package ge.softgen.loanexpert.model;

import ge.softgen.loanexpert.spring.ApplicationConfig;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Bacho on 3/6/15.
 */
@Entity
@Table(name = "SEC_USER_ROLES", schema = ApplicationConfig.schema)
public class SecUserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal id;
	private BigDecimal userId;
	private BigDecimal roleId;
	private BigDecimal status;

	@Id
	@Column(name = "ID")
	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Basic
	@Column(name = "USER_ID")
	public BigDecimal getUserId() {
		return userId;
	}

	public void setUserId(BigDecimal userId) {
		this.userId = userId;
	}

	@Basic
	@Column(name = "ROLE_ID")
	public BigDecimal getRoleId() {
		return roleId;
	}

	public void setRoleId(BigDecimal roleId) {
		this.roleId = roleId;
	}

	@Basic
	@Column(name = "STATUS")
	public BigDecimal getStatus() {
		return status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		SecUserRole that = (SecUserRole) o;

		if (id != null ? !id.equals(that.id) : that.id != null) return false;
		if (roleId != null ? !roleId.equals(that.roleId) : that.roleId != null) return false;
		if (status != null ? !status.equals(that.status) : that.status != null) return false;
		if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (userId != null ? userId.hashCode() : 0);
		result = 31 * result + (roleId != null ? roleId.hashCode() : 0);
		result = 31 * result + (status != null ? status.hashCode() : 0);
		return result;
	}
}
