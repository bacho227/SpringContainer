package ge.softgen.loanexpert.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by bacho on 3/7/15.
 */
@Entity
@Table(name = "SEC_USERS")
public class SecUser implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String surname;
	private String ipRange;
	private String phone;
	private String username;
	private String password;

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

	@Basic
	@Column(name = "SURNAME")
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		SecUser secUser = (SecUser) o;

		if (id != null ? !id.equals(secUser.id) : secUser.id != null) return false;
		if (ipRange != null ? !ipRange.equals(secUser.ipRange) : secUser.ipRange != null) return false;
		if (name != null ? !name.equals(secUser.name) : secUser.name != null) return false;
		if (password != null ? !password.equals(secUser.password) : secUser.password != null) return false;
		if (phone != null ? !phone.equals(secUser.phone) : secUser.phone != null) return false;
		if (surname != null ? !surname.equals(secUser.surname) : secUser.surname != null) return false;
		if (username != null ? !username.equals(secUser.username) : secUser.username != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (surname != null ? surname.hashCode() : 0);
		result = 31 * result + (ipRange != null ? ipRange.hashCode() : 0);
		result = 31 * result + (phone != null ? phone.hashCode() : 0);
		result = 31 * result + (username != null ? username.hashCode() : 0);
		result = 31 * result + (password != null ? password.hashCode() : 0);
		return result;
	}
}
