package ge.softgen.loanexpert.controller;

import ge.softgen.loanexpert.model.SecUser;
import ge.softgen.loanexpert.model.security.User;
import ge.softgen.loanexpert.security.SessionUtils;
import ge.softgen.loanexpert.security.annotation.Anonymous;
import ge.softgen.loanexpert.message.MessageException;
import ge.softgen.loanexpert.message.Status;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Bacho on 2/2/15.
 */
@Controller
@RequestMapping(value = "/security/")
public class SecurityService {

	@PersistenceContext
	private EntityManager em;

	@RequestMapping(value = "getUser")
	@ResponseBody
	public SecUser getUser(SecUser user) {
		return user;
	}

	@Anonymous
	@ResponseBody
	@RequestMapping(value = "signIn", method = RequestMethod.POST)
	public SecUser signIn(@RequestParam String username, @RequestParam String password) throws MessageException {
		Query query = em.createQuery("select t from SecUser t where t.username = :username", SecUser.class);
		query.setParameter("username", username);
		List<SecUser> users = query.getResultList();
		SecUser user;
		if (users.size() == 1) {
			user = users.get(0);
			if (password.equals(user.getPassword())) {
				user.setPassword(null);
				HttpSession session = SessionUtils.getSession();
				session.setAttribute(SessionUtils.SESSION_DATA_KEY, user);
			} else {
				throw new MessageException(Status.badPassword());
			}
		} else {
			throw new MessageException(Status.badUser());
		}
		return user;
	}

	@Anonymous
	@RequestMapping(value = "signOut")
	@ResponseBody
	public void signOut(User user) {
		SessionUtils.getSession().invalidate();
	}
}
