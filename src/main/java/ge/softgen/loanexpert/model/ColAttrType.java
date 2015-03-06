package ge.softgen.loanexpert.model;

import ge.softgen.loanexpert.spring.ApplicationConfig;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Bacho on 3/6/15.
 */
@Entity
@Table(name = "COL_ATTR_TYPES", schema = ApplicationConfig.schema)
public class ColAttrType implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal id;
	private BigDecimal colateralType;
	private String code;
	private String dataType;
	private String isActive;
	private String isMandatory;

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
	@Column(name = "CODE")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Basic
	@Column(name = "DATA_TYPE")
	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	@Basic
	@Column(name = "IS_ACTIVE")
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@Basic
	@Column(name = "IS_MANDATORY")
	public String getIsMandatory() {
		return isMandatory;
	}

	public void setIsMandatory(String isMandatory) {
		this.isMandatory = isMandatory;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ColAttrType that = (ColAttrType) o;

		if (code != null ? !code.equals(that.code) : that.code != null) return false;
		if (colateralType != null ? !colateralType.equals(that.colateralType) : that.colateralType != null) return false;
		if (dataType != null ? !dataType.equals(that.dataType) : that.dataType != null) return false;
		if (id != null ? !id.equals(that.id) : that.id != null) return false;
		if (isActive != null ? !isActive.equals(that.isActive) : that.isActive != null) return false;
		if (isMandatory != null ? !isMandatory.equals(that.isMandatory) : that.isMandatory != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (colateralType != null ? colateralType.hashCode() : 0);
		result = 31 * result + (code != null ? code.hashCode() : 0);
		result = 31 * result + (dataType != null ? dataType.hashCode() : 0);
		result = 31 * result + (isActive != null ? isActive.hashCode() : 0);
		result = 31 * result + (isMandatory != null ? isMandatory.hashCode() : 0);
		return result;
	}
}
