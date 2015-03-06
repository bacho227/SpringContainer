package ge.softgen.loanexpert.model;

import ge.softgen.loanexpert.spring.ApplicationConfig;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Bacho on 3/6/15.
 */
@Entity
@Table(name = "COLATERAL", schema = ApplicationConfig.schema)
public class Colateral implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal id;
	private BigDecimal colateralType;
	private BigDecimal markedValue;
	private BigDecimal bookingValue;
	private String currency;
	private String regNumber;
	private String commen;
	private BigDecimal status;
	private BigDecimal clientId;

	@Id
	@Column(name = "ID")
	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Basic
	@Column(name = "COLATERAL_TYPE")
	public BigDecimal getColateralType() {
		return colateralType;
	}

	public void setColateralType(BigDecimal colateralType) {
		this.colateralType = colateralType;
	}

	@Basic
	@Column(name = "MARKED_VALUE")
	public BigDecimal getMarkedValue() {
		return markedValue;
	}

	public void setMarkedValue(BigDecimal markedValue) {
		this.markedValue = markedValue;
	}

	@Basic
	@Column(name = "BOOKING_VALUE")
	public BigDecimal getBookingValue() {
		return bookingValue;
	}

	public void setBookingValue(BigDecimal bookingValue) {
		this.bookingValue = bookingValue;
	}

	@Basic
	@Column(name = "CURRENCY")
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Basic
	@Column(name = "REG_NUMBER")
	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	@Basic
	@Column(name = "COMMEN")
	public String getCommen() {
		return commen;
	}

	public void setCommen(String commen) {
		this.commen = commen;
	}

	@Basic
	@Column(name = "STATUS")
	public BigDecimal getStatus() {
		return status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

	@Basic
	@Column(name = "CLIENT_ID")
	public BigDecimal getClientId() {
		return clientId;
	}

	public void setClientId(BigDecimal clientId) {
		this.clientId = clientId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Colateral colateral = (Colateral) o;

		if (bookingValue != null ? !bookingValue.equals(colateral.bookingValue) : colateral.bookingValue != null) return false;
		if (clientId != null ? !clientId.equals(colateral.clientId) : colateral.clientId != null) return false;
		if (colateralType != null ? !colateralType.equals(colateral.colateralType) : colateral.colateralType != null) return false;
		if (commen != null ? !commen.equals(colateral.commen) : colateral.commen != null) return false;
		if (currency != null ? !currency.equals(colateral.currency) : colateral.currency != null) return false;
		if (id != null ? !id.equals(colateral.id) : colateral.id != null) return false;
		if (markedValue != null ? !markedValue.equals(colateral.markedValue) : colateral.markedValue != null) return false;
		if (regNumber != null ? !regNumber.equals(colateral.regNumber) : colateral.regNumber != null) return false;
		if (status != null ? !status.equals(colateral.status) : colateral.status != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (colateralType != null ? colateralType.hashCode() : 0);
		result = 31 * result + (markedValue != null ? markedValue.hashCode() : 0);
		result = 31 * result + (bookingValue != null ? bookingValue.hashCode() : 0);
		result = 31 * result + (currency != null ? currency.hashCode() : 0);
		result = 31 * result + (regNumber != null ? regNumber.hashCode() : 0);
		result = 31 * result + (commen != null ? commen.hashCode() : 0);
		result = 31 * result + (status != null ? status.hashCode() : 0);
		result = 31 * result + (clientId != null ? clientId.hashCode() : 0);
		return result;
	}
}
