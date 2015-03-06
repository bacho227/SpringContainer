package ge.softgen.loanexpert.model;

import ge.softgen.loanexpert.spring.ApplicationConfig;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Bacho on 3/6/15.
 */
@Entity
@Table(name = "SEC_FORMS_SHOW", schema = ApplicationConfig.schema)
public class SecFormsShow implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal id;
	private BigDecimal formId;
	private BigDecimal parentId;
	private BigDecimal orderId;

	@Id
	@Column(name = "ID")
	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Id
	@Column(name = "FORM_ID")
	public BigDecimal getFormId() {
		return formId;
	}

	public void setFormId(BigDecimal formId) {
		this.formId = formId;
	}

	@Basic
	@Column(name = "PARENT_ID")
	public BigDecimal getParentId() {
		return parentId;
	}

	public void setParentId(BigDecimal parentId) {
		this.parentId = parentId;
	}

	@Basic
	@Column(name = "ORDER_ID")
	public BigDecimal getOrderId() {
		return orderId;
	}

	public void setOrderId(BigDecimal orderId) {
		this.orderId = orderId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		SecFormsShow that = (SecFormsShow) o;

		if (formId != null ? !formId.equals(that.formId) : that.formId != null) return false;
		if (id != null ? !id.equals(that.id) : that.id != null) return false;
		if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
		if (parentId != null ? !parentId.equals(that.parentId) : that.parentId != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (formId != null ? formId.hashCode() : 0);
		result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
		result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
		return result;
	}
}
