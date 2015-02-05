package ge.controller;

import ge.model.UserManager;
import ge.model.security.User;
import ge.security.SessionUtils;
import ge.security.annotation.Access;
import ge.security.annotation.Anonymous;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by bacho on 2/2/15.
 */
@Controller
@RequestMapping(value = "/security/")
public class SecurityService {

	@RequestMapping(value = "getUser")
	@ResponseBody
	public User getUser(User user) {
		return user;
	}

	@Access("ADMINa") // აქ a უნდა ეწეროს?
	@RequestMapping(value = "test1")
	@ResponseBody
	public String test1(User user) {
		return "asdssdfs sdg";
	}

	@Anonymous
	@RequestMapping(value = "signIn", method = RequestMethod.POST)
	@ResponseBody
	public User signIn(@RequestParam String username, @RequestParam String password) {
		User user = UserManager.getUserByUserName(username);
		if (user.getUserId() != null) {
			if (password.equals(user.getPassword())) {
				user.setPassword(null);
				HttpSession session = SessionUtils.getSession();
				session.setAttribute(SessionUtils.SESSION_DATA_KEY, user);
				user.setMessage("SUCCESSFUL");
			} else {
				user.setMessage("BAD_PASSWORD");
			}
		} else {
			user.setMessage("BAD_USER");
		}
		return user;
	}

	@Anonymous
	@RequestMapping(value = "signOut")
	@ResponseBody
	public void signOut() {
		SessionUtils.getSession().invalidate();
	}
}
