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
@Table(name = "LOAN_REQUESTS")
public class LoanRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal id;
	private BigDecimal loanId;
	private BigDecimal requestNum;
	private BigDecimal capital;
	private BigDecimal percent;
	private Timestamp requestDate;
	private Timestamp accrStartDate;
	private Timestamp lastAccrDate;
	private BigDecimal interestRate;
	private BigDecimal reqStatus;
	private BigDecimal accruedPenlaty;
	private BigDecimal accruedOverPerc;
	private BigDecimal accruedPerc;
	private BigDecimal payedPenalty;
	private BigDecimal payedPerc;
	private BigDecimal payedOverPerc;
	private BigDecimal payedOverCap;
	private BigDecimal payedCapital;

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
	@Column(name = "REQUEST_NUM")
	public BigDecimal getRequestNum() {
		return requestNum;
	}

	public void setRequestNum(BigDecimal requestNum) {
		this.requestNum = requestNum;
	}

	@Basic
	@Column(name = "CAPITAL")
	public BigDecimal getCapital() {
		return capital;
	}

	public void setCapital(BigDecimal capital) {
		this.capital = capital;
	}

	@Basic
	@Column(name = "PERCENT")
	public BigDecimal getPercent() {
		return percent;
	}

	public void setPercent(BigDecimal percent) {
		this.percent = percent;
	}

	@Basic
	@Column(name = "REQUEST_DATE")
	public Timestamp getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Timestamp requestDate) {
		this.requestDate = requestDate;
	}

	@Basic
	@Column(name = "ACCR_START_DATE")
	public Timestamp getAccrStartDate() {
		return accrStartDate;
	}

	public void setAccrStartDate(Timestamp accrStartDate) {
		this.accrStartDate = accrStartDate;
	}

	@Basic
	@Column(name = "LAST_ACCR_DATE")
	public Timestamp getLastAccrDate() {
		return lastAccrDate;
	}

	public void setLastAccrDate(Timestamp lastAccrDate) {
		this.lastAccrDate = lastAccrDate;
	}

	@Basic
	@Column(name = "INTEREST_RATE")
	public BigDecimal getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}

	@Basic
	@Column(name = "REQ_STATUS")
	public BigDecimal getReqStatus() {
		return reqStatus;
	}

	public void setReqStatus(BigDecimal reqStatus) {
		this.reqStatus = reqStatus;
	}

	@Basic
	@Column(name = "ACCRUED_PENLATY")
	public BigDecimal getAccruedPenlaty() {
		return accruedPenlaty;
	}

	public void setAccruedPenlaty(BigDecimal accruedPenlaty) {
		this.accruedPenlaty = accruedPenlaty;
	}

	@Basic
	@Column(name = "ACCRUED_OVER_PERC")
	public BigDecimal getAccruedOverPerc() {
		return accruedOverPerc;
	}

	public void setAccruedOverPerc(BigDecimal accruedOverPerc) {
		this.accruedOverPerc = accruedOverPerc;
	}

	@Basic
	@Column(name = "ACCRUED_PERC")
	public BigDecimal getAccruedPerc() {
		return accruedPerc;
	}

	public void setAccruedPerc(BigDecimal accruedPerc) {
		this.accruedPerc = accruedPerc;
	}

	@Basic
	@Column(name = "PAYED_PENALTY")
	public BigDecimal getPayedPenalty() {
		return payedPenalty;
	}

	public void setPayedPenalty(BigDecimal payedPenalty) {
		this.payedPenalty = payedPenalty;
	}

	@Basic
	@Column(name = "PAYED_PERC")
	public BigDecimal getPayedPerc() {
		return payedPerc;
	}

	public void setPayedPerc(BigDecimal payedPerc) {
		this.payedPerc = payedPerc;
	}

	@Basic
	@Column(name = "PAYED_OVER_PERC")
	public BigDecimal getPayedOverPerc() {
		return payedOverPerc;
	}

	public void setPayedOverPerc(BigDecimal payedOverPerc) {
		this.payedOverPerc = payedOverPerc;
	}

	@Basic
	@Column(name = "PAYED_OVER_CAP")
	public BigDecimal getPayedOverCap() {
		return payedOverCap;
	}

	public void setPayedOverCap(BigDecimal payedOverCap) {
		this.payedOverCap = payedOverCap;
	}

	@Basic
	@Column(name = "PAYED_CAPITAL")
	public BigDecimal getPayedCapital() {
		return payedCapital;
	}

	public void setPayedCapital(BigDecimal payedCapital) {
		this.payedCapital = payedCapital;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		LoanRequest that = (LoanRequest) o;

		if (accrStartDate != null ? !accrStartDate.equals(that.accrStartDate) : that.accrStartDate != null) return false;
		if (accruedOverPerc != null ? !accruedOverPerc.equals(that.accruedOverPerc) : that.accruedOverPerc != null) return false;
		if (accruedPenlaty != null ? !accruedPenlaty.equals(that.accruedPenlaty) : that.accruedPenlaty != null) return false;
		if (accruedPerc != null ? !accruedPerc.equals(that.accruedPerc) : that.accruedPerc != null) return false;
		if (capital != null ? !capital.equals(that.capital) : that.capital != null) return false;
		if (id != null ? !id.equals(that.id) : that.id != null) return false;
		if (interestRate != null ? !interestRate.equals(that.interestRate) : that.interestRate != null) return false;
		if (lastAccrDate != null ? !lastAccrDate.equals(that.lastAccrDate) : that.lastAccrDate != null) return false;
		if (loanId != null ? !loanId.equals(that.loanId) : that.loanId != null) return false;
		if (payedCapital != null ? !payedCapital.equals(that.payedCapital) : that.payedCapital != null) return false;
		if (payedOverCap != null ? !payedOverCap.equals(that.payedOverCap) : that.payedOverCap != null) return false;
		if (payedOverPerc != null ? !payedOverPerc.equals(that.payedOverPerc) : that.payedOverPerc != null) return false;
		if (payedPenalty != null ? !payedPenalty.equals(that.payedPenalty) : that.payedPenalty != null) return false;
		if (payedPerc != null ? !payedPerc.equals(that.payedPerc) : that.payedPerc != null) return false;
		if (percent != null ? !percent.equals(that.percent) : that.percent != null) return false;
		if (reqStatus != null ? !reqStatus.equals(that.reqStatus) : that.reqStatus != null) return false;
		if (requestDate != null ? !requestDate.equals(that.requestDate) : that.requestDate != null) return false;
		if (requestNum != null ? !requestNum.equals(that.requestNum) : that.requestNum != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (loanId != null ? loanId.hashCode() : 0);
		result = 31 * result + (requestNum != null ? requestNum.hashCode() : 0);
		result = 31 * result + (capital != null ? capital.hashCode() : 0);
		result = 31 * result + (percent != null ? percent.hashCode() : 0);
		result = 31 * result + (requestDate != null ? requestDate.hashCode() : 0);
		result = 31 * result + (accrStartDate != null ? accrStartDate.hashCode() : 0);
		result = 31 * result + (lastAccrDate != null ? lastAccrDate.hashCode() : 0);
		result = 31 * result + (interestRate != null ? interestRate.hashCode() : 0);
		result = 31 * result + (reqStatus != null ? reqStatus.hashCode() : 0);
		result = 31 * result + (accruedPenlaty != null ? accruedPenlaty.hashCode() : 0);
		result = 31 * result + (accruedOverPerc != null ? accruedOverPerc.hashCode() : 0);
		result = 31 * result + (accruedPerc != null ? accruedPerc.hashCode() : 0);
		result = 31 * result + (payedPenalty != null ? payedPenalty.hashCode() : 0);
		result = 31 * result + (payedPerc != null ? payedPerc.hashCode() : 0);
		result = 31 * result + (payedOverPerc != null ? payedOverPerc.hashCode() : 0);
		result = 31 * result + (payedOverCap != null ? payedOverCap.hashCode() : 0);
		result = 31 * result + (payedCapital != null ? payedCapital.hashCode() : 0);
		return result;
	}
}
