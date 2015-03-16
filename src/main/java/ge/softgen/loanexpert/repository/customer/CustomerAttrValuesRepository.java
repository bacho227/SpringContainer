package ge.softgen.loanexpert.repository.customer;


import ge.softgen.loanexpert.model.CustomerAttrType;
import ge.softgen.loanexpert.model.CustomerAttrValue;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by bacho on 3/15/15.
 */
public interface CustomerAttrValuesRepository extends CrudRepository<CustomerAttrValue, Integer> {
}
