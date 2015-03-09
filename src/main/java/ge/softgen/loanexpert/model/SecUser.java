package ge.softgen.loanexpert.model;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by bacho on 3/7/15.
 */
@Entity
@Table(name = "SEC_USERS")
public class SecUser implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String firstName;
	private String lastName;
	private String ipRange;
	private String phone;
	private String username;
	private String password;
	private List<SecUserRole> secUserRoles;

	@Transient
	private Set<String> permissionsSet = new HashSet<>();

	@PostLoad
	private void loadPermissions() {
		if (secUserRoles != null) {
			for (SecUserRole secUserRole : secUserRoles) {
				SecRole secRole = secUserRole.getSecRole();
				if (secRole != null) {
					List<SecRolePermission> secRolePermissions = secRole.getSecRolePermissions();
					if (secRolePermissions != null) {
						for (SecRolePermission secRolePermission : secRolePermissions) {
							SecPermission secPermission = secRolePermission.getSecPermission();
							if (secPermission != null) {
								permissionsSet.add(secPermission.getName());
							}
						}
					}
				}
			}
		}
	}

	public boolean hasPermission(String permissionName) {
		return permissionsSet.contains(permissionName);
	}

	@Id
	@Column(name = "ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Basic
	@Column(name = "FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Basic
	@Column(name = "LAST_NAME")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Basic
	@Column(name = "IP_RANGE")
	public String getIpRange() {
		return ipRange;
	}

	public void setIpRange(String ipRange) {
		this.ipRange = ipRange;
	}

	@Basic
	@Column(name = "PHONE")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Basic
	@Column(name = "USERNAME")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Basic
	@Column(name = "PASSWORD")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID", referencedColumnName = "ID")
	@Where(clause = "status=1")
	public List<SecUserRole> getSecUserRoles() {
		return secUserRoles;
	}

	public void setSecUserRoles(List<SecUserRole> secUserRoles) {
		this.secUserRoles = secUserRoles;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		SecUser secUser = (SecUser) o;

		if (id != null ? !id.equals(secUser.id) : secUser.id != null) return false;
		if (ipRange != null ? !ipRange.equals(secUser.ipRange) : secUser.ipRange != null) return false;
		if (firstName != null ? !firstName.equals(secUser.firstName) : secUser.firstName != null) return false;
		if (password != null ? !password.equals(secUser.password) : secUser.password != null) return false;
		if (phone != null ? !phone.equals(secUser.phone) : secUser.phone != null) return false;
		if (lastName != null ? !lastName.equals(secUser.lastName) : secUser.lastName != null) return false;
		if (username != null ? !username.equals(secUser.username) : secUser.username != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		result = 31 * result + (ipRange != null ? ipRange.hashCode() : 0);
		result = 31 * result + (phone != null ? phone.hashCode() : 0);
		result = 31 * result + (username != null ? username.hashCode() : 0);
		result = 31 * result + (password != null ? password.hashCode() : 0);
		return result;
	}
}
