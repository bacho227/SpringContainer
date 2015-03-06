package ge.softgen.loanexpert.model;

import ge.softgen.loanexpert.spring.ApplicationConfig;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Bacho on 3/6/15.
 */
@Entity
@Table(name = "CUSTOMER_FIN_SECS", schema = ApplicationConfig.schema)
public class CustomerFinSec implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal id;
	private BigDecimal customerTypesId;
	private String descrip;

	@Id
	@Column(name = "ID")
	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Basic
	@Column(name = "CUSTOMER_TYPES_ID")
	public BigDecimal getCustomerTypesId() {
		return customerTypesId;
	}

	public void setCustomerTypesId(BigDecimal customerTypesId) {
		this.customerTypesId = customerTypesId;
	}

	@Basic
	@Column(name = "DESCRIP")
	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		CustomerFinSec that = (CustomerFinSec) o;

		if (customerTypesId != null ? !customerTypesId.equals(that.customerTypesId) : that.customerTypesId != null) return false;
		if (descrip != null ? !descrip.equals(that.descrip) : that.descrip != null) return false;
		if (id != null ? !id.equals(that.id) : that.id != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (customerTypesId != null ? customerTypesId.hashCode() : 0);
		result = 31 * result + (descrip != null ? descrip.hashCode() : 0);
		return result;
	}
}
