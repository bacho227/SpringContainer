package ge.softgen.loanexpert.model;

import ge.softgen.loanexpert.spring.ApplicationConfig;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Bacho on 3/6/15.
 */
@Entity
@Table(name = "GEN_HEADER", schema = ApplicationConfig.schema)
public class GenHeader implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal id;
	private String header;
	private String descrip;

	@Id
	@Column(name = "ID")
	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		GenHeader genHeader = (GenHeader) o;

		if (descrip != null ? !descrip.equals(genHeader.descrip) : genHeader.descrip != null) return false;
		if (header != null ? !header.equals(genHeader.header) : genHeader.header != null) return false;
		if (id != null ? !id.equals(genHeader.id) : genHeader.id != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (header != null ? header.hashCode() : 0);
		result = 31 * result + (descrip != null ? descrip.hashCode() : 0);
		return result;
	}
}
