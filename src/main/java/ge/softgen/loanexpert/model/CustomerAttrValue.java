package ge.softgen.loanexpert.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Bacho on 3/6/15.
 */
@Entity
@Table(name = "CUSTOMER_ATTR_VALUES")
@SequenceGenerator(name = "customerAttrValuesSeq", sequenceName = "CUSTOMER_ATTR_VALUES_SEQ")
public class CustomerAttrValue implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer customerId;
	private Integer attrTypeId;
	private String value;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customerAttrValuesSeq")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Basic
	@Column(name = "CUSTOMER_ID")
	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	@Basic
	@Column(name = "ATTR_TYPE_ID")
	public Integer getAttrTypeId() {
		return attrTypeId;
	}

	public void setAttrTypeId(Integer attrTypeId) {
		this.attrTypeId = attrTypeId;
	}

	@Basic
	@Column(name = "VALUE")
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
