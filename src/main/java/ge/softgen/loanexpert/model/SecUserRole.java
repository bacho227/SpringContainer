package ge.softgen.loanexpert.model;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Bacho on 3/6/15.
 */
@Entity
@Table(name = "SEC_USER_ROLES")
public class SecUserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer userId;
	private Integer roleId;
	private Integer status;
	private SecRole secRole;

	@Id
	@Column(name = "ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Basic
	@Column(name = "USER_ID")
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Basic
	@Column(name = "ROLE_ID")
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Basic
	@Column(name = "STATUS")
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID", insertable = false, updatable = false)
	public SecRole getSecRole() {
		return secRole;
	}

	public void setSecRole(SecRole secRole) {
		this.secRole = secRole;
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
