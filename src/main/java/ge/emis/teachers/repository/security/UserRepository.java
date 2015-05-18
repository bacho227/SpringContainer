package ge.emis.teachers.repository.security;

import ge.emis.teachers.model.security.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Bacho on 3/9/15.
 */
public interface UserRepository extends CrudRepository<User, Long> {


	@Query("SELECT t FROM User t WHERE t.username = :username")
	User getUserByUsername(@Param("username") String username);
}