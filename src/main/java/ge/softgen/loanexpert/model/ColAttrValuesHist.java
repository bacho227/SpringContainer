package ge.softgen.loanexpert.model;

import ge.softgen.loanexpert.spring.ApplicationConfig;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Bacho on 3/6/15.
 */
@Entity
@Table(name = "COL_ATTR_VALUES_HIST")
public class ColAttrValuesHist implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal colateralId;
	private BigDecimal colAttTpId;
	private String value;
	private Timestamp chgDate;

	@Id
	@Column(name = "COLATERAL_ID")
	public BigDecimal getColateralId() {
		return colateralId;
	}

	public void setColateralId(BigDecimal colateralId) {
		this.colateralId = colateralId;
	}

	@Id
	@Column(name = "COL_ATT_TP_ID")
	public BigDecimal getColAttTpId() {
		return colAttTpId;
	}

	public void setColAttTpId(BigDecimal colAttTpId) {
		this.colAttTpId = colAttTpId;
	}

	@Basic
	@Column(name = "VALUE")
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Id
	@Column(name = "CHG_DATE")
	public Timestamp getChgDate() {
		return chgDate;
	}

	public void setChgDate(Timestamp chgDate) {
		this.chgDate = chgDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ColAttrValuesHist that = (ColAttrValuesHist) o;

		if (chgDate != null ? !chgDate.equals(that.chgDate) : that.chgDate != null) return false;
		if (colAttTpId != null ? !colAttTpId.equals(that.colAttTpId) : that.colAttTpId != null) return false;
		if (colateralId != null ? !colateralId.equals(that.colateralId) : that.colateralId != null) return false;
		if (value != null ? !value.equals(that.value) : that.value != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = colateralId != null ? colateralId.hashCode() : 0;
		result = 31 * result + (colAttTpId != null ? colAttTpId.hashCode() : 0);
		result = 31 * result + (value != null ? value.hashCode() : 0);
		result = 31 * result + (chgDate != null ? chgDate.hashCode() : 0);
		return result;
	}
}
