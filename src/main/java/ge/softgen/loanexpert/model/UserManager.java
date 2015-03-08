package ge.softgen.loanexpert.model;

import ge.softgen.loanexpert.model.security.Permission;
import ge.softgen.loanexpert.model.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bacho on 8/25/14.
 */
@Controller
public class UserManager {
	@PersistenceContext
	private EntityManager em;

	public SecUser getUserByUserName(String userName) {
		System.out.println(">>>>>>>>>>>>>>");
		System.out.println(em);
		Query query = em.createQuery("select t from SecUser t where t.username = :username", SecUser.class);
		query.setParameter("username", userName);
		return (SecUser) query.getResultList().get(0);
	}

	private static void loadPermissionsToUser(User user) {
		List<Permission> permissions = new ArrayList<>();
		//TODO custom select here for permissions
		permissions.add(new Permission("USER", 1));
		permissions.add(new Permission("ADMIN", 2));
		permissions.add(new Permission("SOME_PERMISSION", 3));
		user.setPermissions(permissions);
	}
}
