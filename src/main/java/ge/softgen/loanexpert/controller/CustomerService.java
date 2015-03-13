package ge.softgen.loanexpert.controller;

import ge.softgen.loanexpert.model.Customer;
import ge.softgen.loanexpert.model.SecUser;
import ge.softgen.loanexpert.model.forms.Client;
import ge.softgen.loanexpert.repository.customer.CustomerRepository;
import ge.softgen.loanexpert.security.annotation.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
//	@PersistenceContext
//	private EntityManager em;

	@Autowired
	private CustomerRepository customerRepository;

	@RequestMapping(value = "addCustomer", method = RequestMethod.POST)
	@ResponseBody
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}

	@RequestMapping(value = "editCustomer", method = RequestMethod.POST)
	@ResponseBody
	public Customer editCustomer(@RequestBody Customer customer) {
		return customer;
	}

	@RequestMapping(value = "removeCustomer", method = RequestMethod.POST)
	@ResponseBody
	public Customer removeCustomer(@RequestBody Customer customer) {
		return customer;
	}


}