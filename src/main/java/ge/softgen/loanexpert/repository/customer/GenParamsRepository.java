package ge.softgen.loanexpert.repository.customer;

import ge.softgen.loanexpert.model.GenParam;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by bacho on 3/15/15.
 */
public interface GenParamsRepository extends CrudRepository<GenParam, Long> {
	@Query("SELECT t FROM GenParam t WHERE t.header = :header")
	List<GenParam> findByHeader(@Param("header") String header);
}
