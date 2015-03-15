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

	private Integer status;

	@Basic
	@javax.persistence.Column(name = "STATUS")
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	private String mobile;

	@Basic
	@javax.persistence.Column(name = "MOBILE")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
