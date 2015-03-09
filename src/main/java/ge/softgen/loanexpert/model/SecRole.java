package ge.softgen.loanexpert.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Bacho on 3/6/15.
 */
@Entity
@Table(name = "SEC_ROLES")
public class SecRole implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private List<SecRolePermission> secRolePermissions;

	@Id
	@Column(name = "ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Basic
	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
	public List<SecRolePermission> getSecRolePermissions() {
		return secRolePermissions;
	}

	public void setSecRolePermissions(List<SecRolePermission> secRolePermissions) {
		this.secRolePermissions = secRolePermissions;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		SecRole secRole = (SecRole) o;

		if (id != null ? !id.equals(secRole.id) : secRole.id != null) return false;
		if (name != null ? !name.equals(secRole.name) : secRole.name != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		return result;
	}
}
