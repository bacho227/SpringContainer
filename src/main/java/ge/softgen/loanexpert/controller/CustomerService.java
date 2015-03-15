package ge.softgen.loanexpert.controller;

import ge.softgen.loanexpert.model.*;
import ge.softgen.loanexpert.model.forms.Client;
import ge.softgen.loanexpert.params.customer.SaveCustomerParams;
import ge.softgen.loanexpert.repository.customer.CustomerAttrTypesRepository;
import ge.softgen.loanexpert.repository.customer.CustomerAttrValuesRepository;
import ge.softgen.loanexpert.repository.customer.CustomerRepository;
import ge.softgen.loanexpert.repository.customer.GenParamsRepository;
import ge.softgen.loanexpert.security.annotation.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Bacho on 2/9/15.
 */

@Controller
@RequestMapping(value = "/customer/")
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerAttrTypesRepository customerAttrTypesRepository;

	@Autowired
	private CustomerAttrValuesRepository customerAttrValuesRepository;

	@Autowired
	private GenParamsRepository genParamsRepository;

	@ResponseBody
	@RequestMapping(value = "saveCustomer")
	@Transactional(rollbackFor = Exception.class)
	public Customer saveCustomer(@RequestBody SaveCustomerParams saveCustomerParams) {
		Customer customer = customerRepository.save(saveCustomerParams.getCustomer());
		List<CustomerAttrValue> customerAttrValues = saveCustomerParams.getCustomerAttrValues();
		for (CustomerAttrValue customerAttrValue : customerAttrValues) {
			customerAttrValue.setCustomerId(customer.getId());
		}
		customerAttrValuesRepository.save(customerAttrValues);
		return customer;
	}

	@ResponseBody
	@RequestMapping(value = "deleteCustomerById")
	public void deleteCustomerById(@RequestParam Integer id) {
		customerRepository.deleteById(id);
	}

	@ResponseBody
	@RequestMapping(value = "getCustomerAttrTypes")
	public List<CustomerAttrType> getCustomerAttrTypes() {
		return customerAttrTypesRepository.findAll();
	}

	@ResponseBody
	@RequestMapping(value = "getGenParamsByHeader")
	public List<GenParam> getGenParamsByHeader(@RequestParam String header) {
		return genParamsRepository.findByHeader(header);
	}


}
