package ge.softgen.loanexpert.params.customer;

import ge.softgen.loanexpert.model.Customer;
import ge.softgen.loanexpert.model.CustomerAttrValue;

import java.io.Serializable;
import java.util.List;

/**
 * Created by bacho on 3/15/15.
 */
public class SaveCustomerParam implements Serializable {
	private static final long serialVersionUID = 1L;

	private Customer customer;
	private List<CustomerAttrValue> customerAttrValues;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<CustomerAttrValue> getCustomerAttrValues() {
		return customerAttrValues;
	}

	public void setCustomerAttrValues(List<CustomerAttrValue> customerAttrValues) {
		this.customerAttrValues = customerAttrValues;
	}
}
