package ge.softgen.loanexpert.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;

/**
 * Created by Bacho on 3/6/15.
 */
@Entity
@Table(name = "CUSTOMERS")
@SequenceGenerator(name = "customerSeq", sequenceName = "CUSTOMERS_SEQ")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customerSeq")
	@javax.persistence.Column(name = "ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private String personalNo;

	@Basic
	@javax.persistence.Column(name = "PERSONAL_NO")
	public String getPersonalNo() {
		return personalNo;
	}

	public void setPersonalNo(String personalNo) {
		this.personalNo = personalNo;
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

	private Integer isResident;

	@Basic
	@javax.persistence.Column(name = "IS_RESIDENT")
	public Integer getIsResident() {
		return isResident;
	}

	public void setIsResident(Integer isResident) {
		this.isResident = isResident;
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

	private Integer isJuridical;

	@Basic
	@javax.persistence.Column(name = "IS_JURIDICAL")
	public Integer getIsJuridical() {
		return isJuridical;
	}

	public void setIsJuridical(Integer isJuridical) {
		this.isJuridical = isJuridical;
	}

	private Integer customerType;

	@Basic
	@javax.persistence.Column(name = "CUSTOMER_TYPE")
	public Integer getCustomerType() {
		return customerType;
	}

	public void setCustomerType(Integer customerType) {
		this.customerType = customerType;
	}

	private Integer customerFinSec;

	@Basic
	@javax.persistence.Column(name = "CUSTOMER_FIN_SEC")
	public Integer getCustomerFinSec() {
		return customerFinSec;
	}

	public void setCustomerFinSec(Integer customerFinSec) {
		this.customerFinSec = customerFinSec;
	}

	private Integer docType;

	@Basic
	@javax.persistence.Column(name = "DOC_TYPE")
	public Integer getDocType() {
		return docType;
	}

	public void setDocType(Integer docType) {
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

	private Integer gender;

	@Basic
	@javax.persistence.Column(name = "GENDER")
	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
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
		if (isJuridical != null ? !isJuridical.equals(customer.isJuridical) : customer.isJuridical != null) return false;
		if (isResident != null ? !isResident.equals(customer.isResident) : customer.isResident != null) return false;
		if (juridicalAddress != null ? !juridicalAddress.equals(customer.juridicalAddress) : customer.juridicalAddress != null) return false;
		if (firstName != null ? !firstName.equals(customer.firstName) : customer.firstName != null) return false;
		if (phone != null ? !phone.equals(customer.phone) : customer.phone != null) return false;
		if (!Arrays.equals(photo, customer.photo)) return false;
		if (personalNo != null ? !personalNo.equals(customer.personalNo) : customer.personalNo != null) return false;
		if (lastName != null ? !lastName.equals(customer.lastName) : customer.lastName != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (personalNo != null ? personalNo.hashCode() : 0);
		result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
		result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
		result = 31 * result + (isResident != null ? isResident.hashCode() : 0);
		result = 31 * result + (address != null ? address.hashCode() : 0);
		result = 31 * result + (juridicalAddress != null ? juridicalAddress.hashCode() : 0);
		result = 31 * result + (phone != null ? phone.hashCode() : 0);
		result = 31 * result + (isJuridical != null ? isJuridical.hashCode() : 0);
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
