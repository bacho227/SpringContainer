package ge.softgen.loanexpert.service;

import ge.softgen.loanexpert.model.CustomerAttrType;
import ge.softgen.loanexpert.repository.customer.CustomerAttrTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * Created by Bacho on 3/16/15.
 */
@Service
public class LibraryService {
	private static Map<Object, Object> cache;

	private Object getFromCache(Object o) {
		return cache.get(o);
	}

	@Autowired
	private CustomerAttrTypesRepository customerAttrTypesRepository;

	public List<CustomerAttrType> getCustomerAttrTypes() {
		return customerAttrTypesRepository.findAll();
	}

}
