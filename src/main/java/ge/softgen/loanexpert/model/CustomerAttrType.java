package ge.softgen.loanexpert.model;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Bacho on 3/6/15.
 */
@Entity
@Table(name = "CUSTOMER_ATTR_TYPES")
public class CustomerAttrType implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String descrip;
	private Integer attrtype;
	private String attrlist;

	@Id
	@Column(name = "ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Basic
	@Column(name = "DESCRIP")
	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	@Basic
	@Column(name = "ATTRTYPE")
	public Integer getAttrtype() {
		return attrtype;
	}

	public void setAttrtype(Integer attrtype) {
		this.attrtype = attrtype;
	}

	@Basic
	@Column(name = "ATTRLIST")
	public String getAttrlist() {
		return attrlist;
	}

	public void setAttrlist(String attrlist) {
		this.attrlist = attrlist;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		CustomerAttrType that = (CustomerAttrType) o;

		if (attrlist != null ? !attrlist.equals(that.attrlist) : that.attrlist != null) return false;
		if (attrtype != null ? !attrtype.equals(that.attrtype) : that.attrtype != null) return false;
		if (descrip != null ? !descrip.equals(that.descrip) : that.descrip != null) return false;
		if (id != null ? !id.equals(that.id) : that.id != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (descrip != null ? descrip.hashCode() : 0);
		result = 31 * result + (attrtype != null ? attrtype.hashCode() : 0);
		result = 31 * result + (attrlist != null ? attrlist.hashCode() : 0);
		return result;
	}
}
