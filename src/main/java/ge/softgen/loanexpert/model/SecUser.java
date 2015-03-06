package ge.softgen.loanexpert.model;

import ge.softgen.loanexpert.spring.ApplicationConfig;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Bacho on 3/6/15.
 */
@Entity
@Table(name = "SEC_USERS", schema = ApplicationConfig.schema)
public class SecUser implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal id;
	private String name;
	private String surname;
	private String ipRange;
	private String phone;

	@Id
	@Column(name = "ID")
	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		SecUser secUser = (SecUser) o;

		if (id != null ? !id.equals(secUser.id) : secUser.id != null) return false;
		if (ipRange != null ? !ipRange.equals(secUser.ipRange) : secUser.ipRange != null) return false;
		if (name != null ? !name.equals(secUser.name) : secUser.name != null) return false;
		if (phone != null ? !phone.equals(secUser.phone) : secUser.phone != null) return false;
		if (surname != null ? !surname.equals(secUser.surname) : secUser.surname != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (surname != null ? surname.hashCode() : 0);
		result = 31 * result + (ipRange != null ? ipRange.hashCode() : 0);
		result = 31 * result + (phone != null ? phone.hashCode() : 0);
		return result;
	}
}
