package ge.softgen.loanexpert.repository.security;

import ge.softgen.loanexpert.model.SecUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Bacho on 3/9/15.
 */
public interface SecUserRepository extends CrudRepository<SecUser, Long> {
	List<SecUser> findAll();

	@Query("SELECT t FROM SecUser t WHERE t.username = :username")
	SecUser getUser(@Param("username") String username);
}
