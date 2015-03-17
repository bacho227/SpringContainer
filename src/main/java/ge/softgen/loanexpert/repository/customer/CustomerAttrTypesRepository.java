package ge.softgen.loanexpert.repository.customer;


import ge.softgen.loanexpert.model.CustomerAttrType;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by bacho on 3/15/15.
 */
public interface CustomerAttrTypesRepository extends CrudRepository<CustomerAttrType, Integer> {
	@Cacheable("customerAttrTypes")
	List<CustomerAttrType> findAll();
}
