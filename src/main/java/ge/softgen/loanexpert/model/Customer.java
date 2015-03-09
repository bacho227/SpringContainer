package ge.softgen.loanexpert.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;

/**
 * Created by Bacho on 3/6/15.
 */
@Entity
@Table(name = "CUSTOMERS")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal id;

	@Id
	@javax.persistence.Column(name = "ID")
	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	private String pid;

	@Basic
	@javax.persistence.Column(name = "PID")
	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	private String firstName;

	@Basic
	@javax.persistence.Column(name = "FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	private String lastName;

	@Basic
	@javax.persistence.Column(name = "LAST_NAME")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	private String fullName;

	@Basic
	@javax.persistence.Column(name = "FULL_NAME")
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	private Timestamp birthDate;

	@Basic
	@javax.persistence.Column(name = "BIRTH_DATE")
	public Timestamp getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Timestamp birthDate) {
		this.birthDate = birthDate;
	}

	private BigDecimal isresident;

	@Basic
	@javax.persistence.Column(name = "ISRESIDENT")
	public BigDecimal getIsresident() {
		return isresident;
	}

	public void setIsresident(BigDecimal isresident) {
		this.isresident = isresident;
	}

	private String address;

	@Basic
	@javax.persistence.Column(name = "ADDRESS")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	private String juridicalAddress;

	@Basic
	@javax.persistence.Column(name = "JURIDICAL_ADDRESS")
	public String getJuridicalAddress() {
		return juridicalAddress;
	}

	public void setJuridicalAddress(String juridicalAddress) {
		this.juridicalAddress = juridicalAddress;
	}

	private String phone;

	@Basic
	@javax.persistence.Column(name = "PHONE")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	private BigDecimal isjuridical;

	@Basic
	@javax.persistence.Column(name = "ISJURIDICAL")
	public BigDecimal getIsjuridical() {
		return isjuridical;
	}

	public void setIsjuridical(BigDecimal isjuridical) {
		this.isjuridical = isjuridical;
	}

	private BigDecimal customerType;

	@Basic
	@javax.persistence.Column(name = "CUSTOMER_TYPE")
	public BigDecimal getCustomerType() {
		return customerType;
	}

	public void setCustomerType(BigDecimal customerType) {
		this.customerType = customerType;
	}

	private BigDecimal customerFinSec;

	@Basic
	@javax.persistence.Column(name = "CUSTOMER_FIN_SEC")
	public BigDecimal getCustomerFinSec() {
		return customerFinSec;
	}

	public void setCustomerFinSec(BigDecimal customerFinSec) {
		this.customerFinSec = customerFinSec;
	}

	private BigDecimal docType;

	@Basic
	@javax.persistence.Column(name = "DOC_TYPE")
	public BigDecimal getDocType() {
		return docType;
	}

	public void setDocType(BigDecimal docType) {
		this.docType = docType;
	}

	private String docNumber;

	@Basic
	@javax.persistence.Column(name = "DOC_NUMBER")
	public String getDocNumber() {
		return docNumber;
	}

	public void setDocNumber(String docNumber) {
		this.docNumber = docNumber;
	}

	private String docIssuer;

	@Basic
	@javax.persistence.Column(name = "DOC_ISSUER")
	public String getDocIssuer() {
		return docIssuer;
	}

	public void setDocIssuer(String docIssuer) {
		this.docIssuer = docIssuer;
	}

	private Timestamp docIssueDate;

	@Basic
	@javax.persistence.Column(name = "DOC_ISSUE_DATE")
	public Timestamp getDocIssueDate() {
		return docIssueDate;
	}

	public void setDocIssueDate(Timestamp docIssueDate) {
		this.docIssueDate = docIssueDate;
	}

	private Timestamp docValidDate;

	@Basic
	@javax.persistence.Column(name = "DOC_VALID_DATE")
	public Timestamp getDocValidDate() {
		return docValidDate;
	}

	public void setDocValidDate(Timestamp docValidDate) {
		this.docValidDate = docValidDate;
	}

	private String email;

	@Basic
	@javax.persistence.Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private byte[] photo;

	@Basic
	@javax.persistence.Column(name = "PHOTO")
	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	private String comments;

	@Basic
	@javax.persistence.Column(name = "COMMENTS")
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	private BigDecimal gender;

	@Basic
	@javax.persistence.Column(name = "GENDER")
	public BigDecimal getGender() {
		return gender;
	}

	public void setGender(BigDecimal gender) {
		this.gender = gender;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Customer customer = (Customer) o;

		if (address != null ? !address.equals(customer.address) : customer.address != null) return false;
		if (birthDate != null ? !birthDate.equals(customer.birthDate) : customer.birthDate != null) return false;
		if (comments != null ? !comments.equals(customer.comments) : customer.comments != null) return false;
		if (customerFinSec != null ? !customerFinSec.equals(customer.customerFinSec) : customer.customerFinSec != null) return false;
		if (customerType != null ? !customerType.equals(customer.customerType) : customer.customerType != null) return false;
		if (docIssueDate != null ? !docIssueDate.equals(customer.docIssueDate) : customer.docIssueDate != null) return false;
		if (docIssuer != null ? !docIssuer.equals(customer.docIssuer) : customer.docIssuer != null) return false;
		if (docNumber != null ? !docNumber.equals(customer.docNumber) : customer.docNumber != null) return false;
		if (docType != null ? !docType.equals(customer.docType) : customer.docType != null) return false;
		if (docValidDate != null ? !docValidDate.equals(customer.docValidDate) : customer.docValidDate != null) return false;
		if (email != null ? !email.equals(customer.email) : customer.email != null) return false;
		if (fullName != null ? !fullName.equals(customer.fullName) : customer.fullName != null) return false;
		if (gender != null ? !gender.equals(customer.gender) : customer.gender != null) return false;
		if (id != null ? !id.equals(customer.id) : customer.id != null) return false;
		if (isjuridical != null ? !isjuridical.equals(customer.isjuridical) : customer.isjuridical != null) return false;
		if (isresident != null ? !isresident.equals(customer.isresident) : customer.isresident != null) return false;
		if (juridicalAddress != null ? !juridicalAddress.equals(customer.juridicalAddress) : customer.juridicalAddress != null) return false;
		if (firstName != null ? !firstName.equals(customer.firstName) : customer.firstName != null) return false;
		if (phone != null ? !phone.equals(customer.phone) : customer.phone != null) return false;
		if (!Arrays.equals(photo, customer.photo)) return false;
		if (pid != null ? !pid.equals(customer.pid) : customer.pid != null) return false;
		if (lastName != null ? !lastName.equals(customer.lastName) : customer.lastName != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (pid != null ? pid.hashCode() : 0);
		result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
		result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
		result = 31 * result + (isresident != null ? isresident.hashCode() : 0);
		result = 31 * result + (address != null ? address.hashCode() : 0);
		result = 31 * result + (juridicalAddress != null ? juridicalAddress.hashCode() : 0);
		result = 31 * result + (phone != null ? phone.hashCode() : 0);
		result = 31 * result + (isjuridical != null ? isjuridical.hashCode() : 0);
		result = 31 * result + (customerType != null ? customerType.hashCode() : 0);
		result = 31 * result + (customerFinSec != null ? customerFinSec.hashCode() : 0);
		result = 31 * result + (docType != null ? docType.hashCode() : 0);
		result = 31 * result + (docNumber != null ? docNumber.hashCode() : 0);
		result = 31 * result + (docIssuer != null ? docIssuer.hashCode() : 0);
		result = 31 * result + (docIssueDate != null ? docIssueDate.hashCode() : 0);
		result = 31 * result + (docValidDate != null ? docValidDate.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
		result = 31 * result + (photo != null ? Arrays.hashCode(photo) : 0);
		result = 31 * result + (comments != null ? comments.hashCode() : 0);
		result = 31 * result + (gender != null ? gender.hashCode() : 0);
		return result;
	}
}
