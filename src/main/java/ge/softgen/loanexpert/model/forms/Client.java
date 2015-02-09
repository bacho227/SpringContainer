package ge.softgen.loanexpert.model.forms;

import java.util.Date;

/**
 * Created by Bacho on 2/9/15.
 */
public class Client {
	private Integer type;
	private String personalNo;
	private Integer status;
	private String firstName;
	private String lastName;
	private Date birthDate;

	//Extra params
	private String legalName;
	private String financialSector;
	private String address;
	private String legalAddress;
	private String docType;
	private String docNo;
	private String docIssuer;
	private Date docIssueDate;
	private Date docValidDate;
	private String phone;
	private String mobile;
	private String email;
	private String note;
	private String photo;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getPersonalNo() {
		return personalNo;
	}

	public void setPersonalNo(String personalNo) {
		this.personalNo = personalNo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getLegalName() {
		return legalName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	public String getFinancialSector() {
		return financialSector;
	}

	public void setFinancialSector(String financialSector) {
		this.financialSector = financialSector;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLegalAddress() {
		return legalAddress;
	}

	public void setLegalAddress(String legalAddress) {
		this.legalAddress = legalAddress;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getDocNo() {
		return docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	public String getDocIssuer() {
		return docIssuer;
	}

	public void setDocIssuer(String docIssuer) {
		this.docIssuer = docIssuer;
	}

	public Date getDocIssueDate() {
		return docIssueDate;
	}

	public void setDocIssueDate(Date docIssueDate) {
		this.docIssueDate = docIssueDate;
	}

	public Date getDocValidDate() {
		return docValidDate;
	}

	public void setDocValidDate(Date docValidDate) {
		this.docValidDate = docValidDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
