package ge.softgen.loanexpert.repository.customer;

import ge.softgen.loanexpert.model.Customer;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by Bacho on 3/13/15.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
