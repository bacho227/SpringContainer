package ge.softgen.loanexpert.service;

import ge.softgen.loanexpert.model.Customer;
import ge.softgen.loanexpert.model.CustomerAttrType;
import ge.softgen.loanexpert.model.CustomerAttrValue;
import ge.softgen.loanexpert.model.GenParam;
import ge.softgen.loanexpert.params.customer.SaveCustomerParam;
import ge.softgen.loanexpert.repository.customer.CustomerAttrTypesRepository;
import ge.softgen.loanexpert.repository.customer.CustomerAttrValuesRepository;
import ge.softgen.loanexpert.repository.customer.CustomerRepository;
import ge.softgen.loanexpert.repository.customer.GenParamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Bacho on 3/16/15.
 */
@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerAttrTypesRepository customerAttrTypesRepository;

	@Autowired
	private CustomerAttrValuesRepository customerAttrValuesRepository;

	@Autowired
	private GenParamsRepository genParamsRepository;

	@Transactional(rollbackFor = Exception.class)
	public Customer saveCustomer(SaveCustomerParam saveCustomerParam) {
		Customer customer = customerRepository.save(saveCustomerParam.getCustomer());
		List<CustomerAttrValue> customerAttrValues = saveCustomerParam.getCustomerAttrValues();
		Iterator<CustomerAttrValue> iterator = customerAttrValues.iterator();
		while (iterator.hasNext()) {
			CustomerAttrValue customerAttrValue = iterator.next();
			if (customerAttrValue.getValue() == null || customerAttrValue.getValue().isEmpty()) {
				iterator.remove();
			} else {
				customerAttrValue.setCustomerId(customer.getId());
			}
		}
		customerAttrValuesRepository.save(customerAttrValues);
		return customer;
	}

	public void deleteCustomerById(Integer customerId) {
		customerRepository.deleteById(customerId);
	}

	public List<CustomerAttrType> getCustomerAttrTypes() {
		return customerAttrTypesRepository.findAll();
	}

	public List<GenParam> getGenParamsByHeader(String header) {
		return genParamsRepository.findByHeader(header);
	}

	public GenParam addGenParam(GenParam genParam) {
		return genParamsRepository.save(genParam);
	}
}
