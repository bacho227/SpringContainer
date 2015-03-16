package ge.softgen.loanexpert.repository.customer;

import ge.softgen.loanexpert.model.GenParam;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bacho on 3/15/15.
 */
public interface GenParamsRepository extends CrudRepository<GenParam, Integer> {
	@Cacheable("GenParamByHeader")
	@Query("SELECT t FROM GenParam t WHERE t.header = :header")
	List<GenParam> findByHeader(@Param("header") String header);

	@CacheEvict(value = "GenParamByHeader", allEntries = true)
	@Modifying
	@Transactional
	GenParam save(GenParam genParam);
}
