package ge.softgen.loanexpert.model;

import ge.softgen.loanexpert.spring.ApplicationConfig;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Created by Bacho on 3/6/15.
 */
@Entity
@Table(name = "CUSTOMER_JOINS", schema = ApplicationConfig.schema)
public class CustomerJoin implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal id;
	private BigDecimal joinType;
	private BigDecimal customerId;
	private BigDecimal joinedCustomerId;
	private byte[] scannedDocument;

	@Id
	@Column(name = "ID")
	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Basic
	@Column(name = "JOIN_TYPE")
	public BigDecimal getJoinType() {
		return joinType;
	}

	public void setJoinType(BigDecimal joinType) {
		this.joinType = joinType;
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
	@Column(name = "JOINED_CUSTOMER_ID")
	public BigDecimal getJoinedCustomerId() {
		return joinedCustomerId;
	}

	public void setJoinedCustomerId(BigDecimal joinedCustomerId) {
		this.joinedCustomerId = joinedCustomerId;
	}

	@Basic
	@Column(name = "SCANNED_DOCUMENT")
	public byte[] getScannedDocument() {
		return scannedDocument;
	}

	public void setScannedDocument(byte[] scannedDocument) {
		this.scannedDocument = scannedDocument;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		CustomerJoin that = (CustomerJoin) o;

		if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
		if (id != null ? !id.equals(that.id) : that.id != null) return false;
		if (joinType != null ? !joinType.equals(that.joinType) : that.joinType != null) return false;
		if (joinedCustomerId != null ? !joinedCustomerId.equals(that.joinedCustomerId) : that.joinedCustomerId != null) return false;
		if (!Arrays.equals(scannedDocument, that.scannedDocument)) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (joinType != null ? joinType.hashCode() : 0);
		result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
		result = 31 * result + (joinedCustomerId != null ? joinedCustomerId.hashCode() : 0);
		result = 31 * result + (scannedDocument != null ? Arrays.hashCode(scannedDocument) : 0);
		return result;
	}
}
