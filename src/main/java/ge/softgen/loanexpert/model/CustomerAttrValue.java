package ge.softgen.loanexpert.model;

import ge.softgen.loanexpert.spring.ApplicationConfig;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Bacho on 3/6/15.
 */
@Entity
@Table(name = "CUSTOMER_ATTR_VALUES", schema = ApplicationConfig.schema)
public class CustomerAttrValue implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal id;
	private BigDecimal customerId;
	private BigDecimal attrTypeId;
	private String value;

	@Id
	@Column(name = "ID")
	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Basic
	@Column(name = "CUSTOMER_ID")
	public BigDecimal getCustomerId() {
		return customerId;
	}

	public void setCustomerId(BigDecimal customerId) {
		this.customerId = customerId;
	}

	@Basic
	@Column(name = "ATTR_TYPE_ID")
	public BigDecimal getAttrTypeId() {
		return attrTypeId;
	}

	public void setAttrTypeId(BigDecimal attrTypeId) {
		this.attrTypeId = attrTypeId;
	}

	@Basic
	@Column(name = "VALUE")
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		CustomerAttrValue that = (CustomerAttrValue) o;

		if (attrTypeId != null ? !attrTypeId.equals(that.attrTypeId) : that.attrTypeId != null) return false;
		if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
		if (id != null ? !id.equals(that.id) : that.id != null) return false;
		if (value != null ? !value.equals(that.value) : that.value != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
		result = 31 * result + (attrTypeId != null ? attrTypeId.hashCode() : 0);
		result = 31 * result + (value != null ? value.hashCode() : 0);
		return result;
	}
}
