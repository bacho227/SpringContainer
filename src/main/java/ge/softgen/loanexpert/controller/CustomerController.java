package ge.softgen.loanexpert.controller;

import ge.softgen.loanexpert.model.*;
import ge.softgen.loanexpert.params.customer.SaveCustomerParam;
import ge.softgen.loanexpert.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Bacho on 2/9/15.
 */

@Controller
@RequestMapping(value = "/customer/")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@ResponseBody
	@RequestMapping(value = "saveCustomer")
	@Transactional(rollbackFor = Exception.class)
	public Customer saveCustomer(@RequestBody SaveCustomerParam saveCustomerParam) {
		return customerService.saveCustomer(saveCustomerParam);
	}

	@ResponseBody
	@RequestMapping(value = "deleteCustomerById")
	public void deleteCustomerById(@RequestParam Integer customerId) {
		customerService.deleteCustomerById(customerId);
	}

	@ResponseBody
	@RequestMapping(value = "getCustomerAttrTypes")
	public List<CustomerAttrType> getCustomerAttrTypes() {
		return customerService.getCustomerAttrTypes();
	}

	@ResponseBody
	@RequestMapping(value = "getGenParamsByHeader")
	public List<GenParam> getGenParamsByHeader(@RequestParam String header) {
		return customerService.getGenParamsByHeader(header);
	}

	@ResponseBody
	@RequestMapping(value = "addGenParam")
	public GenParam addGenParam(@RequestBody GenParam genParam) {
		return customerService.addGenParam(genParam);
	}
}
