package ge.softgen.loanexpert.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Bacho on 3/6/15.
 */
@Entity
@Table(name = "GEN_HEADER")
public class GenHeader implements Serializable {
	private static final long serialVersionUID = 1L;

	private String header;
	private String descrip;

	@Id
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		GenHeader genHeader = (GenHeader) o;

		if (descrip != null ? !descrip.equals(genHeader.descrip) : genHeader.descrip != null) return false;
		if (header != null ? !header.equals(genHeader.header) : genHeader.header != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = header != null ? header.hashCode() : 0;
		result = 31 * result + (descrip != null ? descrip.hashCode() : 0);
		return result;
	}
}
