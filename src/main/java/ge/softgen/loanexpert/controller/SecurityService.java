package ge.softgen.loanexpert.controller;

import ge.softgen.loanexpert.model.SecUser;
import ge.softgen.loanexpert.model.security.User;
import ge.softgen.loanexpert.repository.security.SecUserRepository;
import ge.softgen.loanexpert.security.SessionUtils;
import ge.softgen.loanexpert.security.annotation.Access;
import ge.softgen.loanexpert.security.annotation.Anonymous;
import ge.softgen.loanexpert.message.MessageException;
import ge.softgen.loanexpert.message.Status;
import ge.softgen.loanexpert.tools.Utils;
import org.springframework.beans.factory.annotation.Autowired;
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
//
//	@PersistenceContext
//	private EntityManager em;

	@Autowired
	private SecUserRepository secUserRepository;

	@RequestMapping(value = "getUser")
	@ResponseBody
	public SecUser getUser(SecUser user) {
		return user;
	}

	@Anonymous
	@ResponseBody
	@RequestMapping(value = "signIn", method = RequestMethod.POST)
	public SecUser signIn(@RequestParam String username, @RequestParam String password) throws MessageException {
		SecUser user = secUserRepository.getUser(username);
		if (user != null) {
			if (user.getPassword().equals(Utils.getMD5(password))) {
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
	@ResponseBody
	@RequestMapping(value = "signOut")
	public void signOut() {
		SessionUtils.getSession().invalidate();
	}

	@ResponseBody
	@RequestMapping(value = "getUsers", method = RequestMethod.POST)
	public List<SecUser> getUsers() {
		return secUserRepository.findAll();
	}
}
