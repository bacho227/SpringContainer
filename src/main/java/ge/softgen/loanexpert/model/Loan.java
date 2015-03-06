package ge.softgen.loanexpert.model;

import ge.softgen.loanexpert.spring.ApplicationConfig;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Bacho on 3/6/15.
 */
@Entity
@Table(name = "LOANS", schema = ApplicationConfig.schema)
public class Loan implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal loanId;

	@Id
	@javax.persistence.Column(name = "LOAN_ID")
	public BigDecimal getLoanId() {
		return loanId;
	}

	public void setLoanId(BigDecimal loanId) {
		this.loanId = loanId;
	}

	private String agrNum;

	@Basic
	@javax.persistence.Column(name = "AGR_NUM")
	public String getAgrNum() {
		return agrNum;
	}

	public void setAgrNum(String agrNum) {
		this.agrNum = agrNum;
	}

	private Timestamp regDate;

	@Basic
	@javax.persistence.Column(name = "REG_DATE")
	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	private Timestamp startDate;

	@Basic
	@javax.persistence.Column(name = "START_DATE")
	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	private Timestamp endDate;

	@Basic
	@javax.persistence.Column(name = "END_DATE")
	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	private Timestamp closeDate;

	@Basic
	@javax.persistence.Column(name = "CLOSE_DATE")
	public Timestamp getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Timestamp closeDate) {
		this.closeDate = closeDate;
	}

	private BigDecimal status;

	@Basic
	@javax.persistence.Column(name = "STATUS")
	public BigDecimal getStatus() {
		return status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

	private BigDecimal amount;

	@Basic
	@javax.persistence.Column(name = "AMOUNT")
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	private BigDecimal duration;

	@Basic
	@javax.persistence.Column(name = "DURATION")
	public BigDecimal getDuration() {
		return duration;
	}

	public void setDuration(BigDecimal duration) {
		this.duration = duration;
	}

	private BigDecimal durationType;

	@Basic
	@javax.persistence.Column(name = "DURATION_TYPE")
	public BigDecimal getDurationType() {
		return durationType;
	}

	public void setDurationType(BigDecimal durationType) {
		this.durationType = durationType;
	}

	private BigDecimal durationPeriods;

	@Basic
	@javax.persistence.Column(name = "DURATION_PERIODS")
	public BigDecimal getDurationPeriods() {
		return durationPeriods;
	}

	public void setDurationPeriods(BigDecimal durationPeriods) {
		this.durationPeriods = durationPeriods;
	}

	private BigDecimal productId;

	@Basic
	@javax.persistence.Column(name = "PRODUCT_ID")
	public BigDecimal getProductId() {
		return productId;
	}

	public void setProductId(BigDecimal productId) {
		this.productId = productId;
	}

	private String currency;

	@Basic
	@javax.persistence.Column(name = "CURRENCY")
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	private BigDecimal currentAmount;

	@Basic
	@javax.persistence.Column(name = "CURRENT_AMOUNT")
	public BigDecimal getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(BigDecimal currentAmount) {
		this.currentAmount = currentAmount;
	}

	private BigDecimal interestRate;

	@Basic
	@javax.persistence.Column(name = "INTEREST_RATE")
	public BigDecimal getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}

	private BigDecimal commission;

	@Basic
	@javax.persistence.Column(name = "COMMISSION")
	public BigDecimal getCommission() {
		return commission;
	}

	public void setCommission(BigDecimal commission) {
		this.commission = commission;
	}

	private BigDecimal limit;

	@Basic
	@javax.persistence.Column(name = "LIMIT")
	public BigDecimal getLimit() {
		return limit;
	}

	public void setLimit(BigDecimal limit) {
		this.limit = limit;
	}

	private BigDecimal penaltyRate;

	@Basic
	@javax.persistence.Column(name = "PENALTY_RATE")
	public BigDecimal getPenaltyRate() {
		return penaltyRate;
	}

	public void setPenaltyRate(BigDecimal penaltyRate) {
		this.penaltyRate = penaltyRate;
	}

	private BigDecimal prepayPenalty;

	@Basic
	@javax.persistence.Column(name = "PREPAY_PENALTY")
	public BigDecimal getPrepayPenalty() {
		return prepayPenalty;
	}

	public void setPrepayPenalty(BigDecimal prepayPenalty) {
		this.prepayPenalty = prepayPenalty;
	}

	private BigDecimal prepayRefPenalty;

	@Basic
	@javax.persistence.Column(name = "PREPAY_REF_PENALTY")
	public BigDecimal getPrepayRefPenalty() {
		return prepayRefPenalty;
	}

	public void setPrepayRefPenalty(BigDecimal prepayRefPenalty) {
		this.prepayRefPenalty = prepayRefPenalty;
	}

	private BigDecimal branchId;

	@Basic
	@javax.persistence.Column(name = "BRANCH_ID")
	public BigDecimal getBranchId() {
		return branchId;
	}

	public void setBranchId(BigDecimal branchId) {
		this.branchId = branchId;
	}

	private BigDecimal regUserId;

	@Basic
	@javax.persistence.Column(name = "REG_USER_ID")
	public BigDecimal getRegUserId() {
		return regUserId;
	}

	public void setRegUserId(BigDecimal regUserId) {
		this.regUserId = regUserId;
	}

	private BigDecimal officerId;

	@Basic
	@javax.persistence.Column(name = "OFFICER_ID")
	public BigDecimal getOfficerId() {
		return officerId;
	}

	public void setOfficerId(BigDecimal officerId) {
		this.officerId = officerId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Loan loan = (Loan) o;

		if (agrNum != null ? !agrNum.equals(loan.agrNum) : loan.agrNum != null) return false;
		if (amount != null ? !amount.equals(loan.amount) : loan.amount != null) return false;
		if (branchId != null ? !branchId.equals(loan.branchId) : loan.branchId != null) return false;
		if (closeDate != null ? !closeDate.equals(loan.closeDate) : loan.closeDate != null) return false;
		if (commission != null ? !commission.equals(loan.commission) : loan.commission != null) return false;
		if (currency != null ? !currency.equals(loan.currency) : loan.currency != null) return false;
		if (currentAmount != null ? !currentAmount.equals(loan.currentAmount) : loan.currentAmount != null) return false;
		if (duration != null ? !duration.equals(loan.duration) : loan.duration != null) return false;
		if (durationPeriods != null ? !durationPeriods.equals(loan.durationPeriods) : loan.durationPeriods != null) return false;
		if (durationType != null ? !durationType.equals(loan.durationType) : loan.durationType != null) return false;
		if (endDate != null ? !endDate.equals(loan.endDate) : loan.endDate != null) return false;
		if (interestRate != null ? !interestRate.equals(loan.interestRate) : loan.interestRate != null) return false;
		if (limit != null ? !limit.equals(loan.limit) : loan.limit != null) return false;
		if (loanId != null ? !loanId.equals(loan.loanId) : loan.loanId != null) return false;
		if (officerId != null ? !officerId.equals(loan.officerId) : loan.officerId != null) return false;
		if (penaltyRate != null ? !penaltyRate.equals(loan.penaltyRate) : loan.penaltyRate != null) return false;
		if (prepayPenalty != null ? !prepayPenalty.equals(loan.prepayPenalty) : loan.prepayPenalty != null) return false;
		if (prepayRefPenalty != null ? !prepayRefPenalty.equals(loan.prepayRefPenalty) : loan.prepayRefPenalty != null) return false;
		if (productId != null ? !productId.equals(loan.productId) : loan.productId != null) return false;
		if (regDate != null ? !regDate.equals(loan.regDate) : loan.regDate != null) return false;
		if (regUserId != null ? !regUserId.equals(loan.regUserId) : loan.regUserId != null) return false;
		if (startDate != null ? !startDate.equals(loan.startDate) : loan.startDate != null) return false;
		if (status != null ? !status.equals(loan.status) : loan.status != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = loanId != null ? loanId.hashCode() : 0;
		result = 31 * result + (agrNum != null ? agrNum.hashCode() : 0);
		result = 31 * result + (regDate != null ? regDate.hashCode() : 0);
		result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
		result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
		result = 31 * result + (closeDate != null ? closeDate.hashCode() : 0);
		result = 31 * result + (status != null ? status.hashCode() : 0);
		result = 31 * result + (amount != null ? amount.hashCode() : 0);
		result = 31 * result + (duration != null ? duration.hashCode() : 0);
		result = 31 * result + (durationType != null ? durationType.hashCode() : 0);
		result = 31 * result + (durationPeriods != null ? durationPeriods.hashCode() : 0);
		result = 31 * result + (productId != null ? productId.hashCode() : 0);
		result = 31 * result + (currency != null ? currency.hashCode() : 0);
		result = 31 * result + (currentAmount != null ? currentAmount.hashCode() : 0);
		result = 31 * result + (interestRate != null ? interestRate.hashCode() : 0);
		result = 31 * result + (commission != null ? commission.hashCode() : 0);
		result = 31 * result + (limit != null ? limit.hashCode() : 0);
		result = 31 * result + (penaltyRate != null ? penaltyRate.hashCode() : 0);
		result = 31 * result + (prepayPenalty != null ? prepayPenalty.hashCode() : 0);
		result = 31 * result + (prepayRefPenalty != null ? prepayRefPenalty.hashCode() : 0);
		result = 31 * result + (branchId != null ? branchId.hashCode() : 0);
		result = 31 * result + (regUserId != null ? regUserId.hashCode() : 0);
		result = 31 * result + (officerId != null ? officerId.hashCode() : 0);
		return result;
	}
}
