package ge.softgen.loanexpert.model;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Bacho on 3/6/15.
 */
@Entity
@Table(name = "GEN_PARAM")
public class GenParam implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String header;
	private String descrip;
	private String longDescription;

	@Id
	@Column(name = "ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Basic
	@Column(name = "HEADER")
	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
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
	@Column(name = "LONG_DESCRIPTION")
	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		GenParam genParam = (GenParam) o;

		if (descrip != null ? !descrip.equals(genParam.descrip) : genParam.descrip != null) return false;
		if (header != null ? !header.equals(genParam.header) : genParam.header != null) return false;
		if (id != null ? !id.equals(genParam.id) : genParam.id != null) return false;
		if (longDescription != null ? !longDescription.equals(genParam.longDescription) : genParam.longDescription != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (header != null ? header.hashCode() : 0);
		result = 31 * result + (descrip != null ? descrip.hashCode() : 0);
		result = 31 * result + (longDescription != null ? longDescription.hashCode() : 0);
		return result;
	}
}
