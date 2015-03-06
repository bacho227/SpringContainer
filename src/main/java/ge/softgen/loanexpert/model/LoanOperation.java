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
@Table(name = "LOAN_OPERATIONS", schema = ApplicationConfig.schema)
public class LoanOperation implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal id;
	private BigDecimal loanId;
	private BigDecimal operationId;
	private BigDecimal amountCapital;
	private BigDecimal amountOverCapital;
	private BigDecimal amountPenalty;
	private BigDecimal amountOverPerc;
	private BigDecimal amountPerc;
	private BigDecimal amountCommission;
	private Timestamp currDate;
	private Timestamp sysDate;

	@Id
	@Column(name = "ID")
	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Basic
	@Column(name = "LOAN_ID")
	public BigDecimal getLoanId() {
		return loanId;
	}

	public void setLoanId(BigDecimal loanId) {
		this.loanId = loanId;
	}

	@Basic
	@Column(name = "OPERATION_ID")
	public BigDecimal getOperationId() {
		return operationId;
	}

	public void setOperationId(BigDecimal operationId) {
		this.operationId = operationId;
	}

	@Basic
	@Column(name = "AMOUNT_CAPITAL")
	public BigDecimal getAmountCapital() {
		return amountCapital;
	}

	public void setAmountCapital(BigDecimal amountCapital) {
		this.amountCapital = amountCapital;
	}

	@Basic
	@Column(name = "AMOUNT_OVER_CAPITAL")
	public BigDecimal getAmountOverCapital() {
		return amountOverCapital;
	}

	public void setAmountOverCapital(BigDecimal amountOverCapital) {
		this.amountOverCapital = amountOverCapital;
	}

	@Basic
	@Column(name = "AMOUNT_PENALTY")
	public BigDecimal getAmountPenalty() {
		return amountPenalty;
	}

	public void setAmountPenalty(BigDecimal amountPenalty) {
		this.amountPenalty = amountPenalty;
	}

	@Basic
	@Column(name = "AMOUNT_OVER_PERC")
	public BigDecimal getAmountOverPerc() {
		return amountOverPerc;
	}

	public void setAmountOverPerc(BigDecimal amountOverPerc) {
		this.amountOverPerc = amountOverPerc;
	}

	@Basic
	@Column(name = "AMOUNT_PERC")
	public BigDecimal getAmountPerc() {
		return amountPerc;
	}

	public void setAmountPerc(BigDecimal amountPerc) {
		this.amountPerc = amountPerc;
	}

	@Basic
	@Column(name = "AMOUNT_COMMISSION")
	public BigDecimal getAmountCommission() {
		return amountCommission;
	}

	public void setAmountCommission(BigDecimal amountCommission) {
		this.amountCommission = amountCommission;
	}

	@Basic
	@Column(name = "CURR_DATE")
	public Timestamp getCurrDate() {
		return currDate;
	}

	public void setCurrDate(Timestamp currDate) {
		this.currDate = currDate;
	}

	@Basic
	@Column(name = "SYS_DATE")
	public Timestamp getSysDate() {
		return sysDate;
	}

	public void setSysDate(Timestamp sysDate) {
		this.sysDate = sysDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		LoanOperation that = (LoanOperation) o;

		if (amountCapital != null ? !amountCapital.equals(that.amountCapital) : that.amountCapital != null) return false;
		if (amountCommission != null ? !amountCommission.equals(that.amountCommission) : that.amountCommission != null) return false;
		if (amountOverCapital != null ? !amountOverCapital.equals(that.amountOverCapital) : that.amountOverCapital != null) return false;
		if (amountOverPerc != null ? !amountOverPerc.equals(that.amountOverPerc) : that.amountOverPerc != null) return false;
		if (amountPenalty != null ? !amountPenalty.equals(that.amountPenalty) : that.amountPenalty != null) return false;
		if (amountPerc != null ? !amountPerc.equals(that.amountPerc) : that.amountPerc != null) return false;
		if (currDate != null ? !currDate.equals(that.currDate) : that.currDate != null) return false;
		if (id != null ? !id.equals(that.id) : that.id != null) return false;
		if (loanId != null ? !loanId.equals(that.loanId) : that.loanId != null) return false;
		if (operationId != null ? !operationId.equals(that.operationId) : that.operationId != null) return false;
		if (sysDate != null ? !sysDate.equals(that.sysDate) : that.sysDate != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (loanId != null ? loanId.hashCode() : 0);
		result = 31 * result + (operationId != null ? operationId.hashCode() : 0);
		result = 31 * result + (amountCapital != null ? amountCapital.hashCode() : 0);
		result = 31 * result + (amountOverCapital != null ? amountOverCapital.hashCode() : 0);
		result = 31 * result + (amountPenalty != null ? amountPenalty.hashCode() : 0);
		result = 31 * result + (amountOverPerc != null ? amountOverPerc.hashCode() : 0);
		result = 31 * result + (amountPerc != null ? amountPerc.hashCode() : 0);
		result = 31 * result + (amountCommission != null ? amountCommission.hashCode() : 0);
		result = 31 * result + (currDate != null ? currDate.hashCode() : 0);
		result = 31 * result + (sysDate != null ? sysDate.hashCode() : 0);
		return result;
	}
}
