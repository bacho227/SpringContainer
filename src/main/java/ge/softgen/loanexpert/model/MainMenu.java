package ge.softgen.loanexpert.model;

import ge.softgen.loanexpert.spring.ApplicationConfig;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Bacho on 3/6/15.
 */
@Entity
@Table(name = "MAIN_MENU", schema = ApplicationConfig.schema)
public class MainMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal id;
	private String name;
	private String descript;
	private BigDecimal parentId;
	private BigDecimal orderId;
	private BigDecimal formsShowId;

	@Id
	@Column(name = "ID")
	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Basic
	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name = "DESCRIPT")
	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	@Basic
	@Column(name = "PARENT_ID")
	public BigDecimal getParentId() {
		return parentId;
	}

	public void setParentId(BigDecimal parentId) {
		this.parentId = parentId;
	}

	@Basic
	@Column(name = "ORDER_ID")
	public BigDecimal getOrderId() {
		return orderId;
	}

	public void setOrderId(BigDecimal orderId) {
		this.orderId = orderId;
	}

	@Basic
	@Column(name = "FORMS_SHOW_ID")
	public BigDecimal getFormsShowId() {
		return formsShowId;
	}

	public void setFormsShowId(BigDecimal formsShowId) {
		this.formsShowId = formsShowId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		MainMenu mainMenu = (MainMenu) o;

		if (descript != null ? !descript.equals(mainMenu.descript) : mainMenu.descript != null) return false;
		if (formsShowId != null ? !formsShowId.equals(mainMenu.formsShowId) : mainMenu.formsShowId != null) return false;
		if (id != null ? !id.equals(mainMenu.id) : mainMenu.id != null) return false;
		if (name != null ? !name.equals(mainMenu.name) : mainMenu.name != null) return false;
		if (orderId != null ? !orderId.equals(mainMenu.orderId) : mainMenu.orderId != null) return false;
		if (parentId != null ? !parentId.equals(mainMenu.parentId) : mainMenu.parentId != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (descript != null ? descript.hashCode() : 0);
		result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
		result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
		result = 31 * result + (formsShowId != null ? formsShowId.hashCode() : 0);
		return result;
	}
}
