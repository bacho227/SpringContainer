package ge.softgen.loanexpert.repository.customer;

import ge.softgen.loanexpert.model.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by Bacho on 3/13/15.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	@Modifying
	@Transactional
	@Query("DELETE FROM Customer t WHERE t.id = :id")
	void deleteById(@Param("id") Integer id);
}
