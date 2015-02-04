package ge.controller;

import ge.model.UserManager;
import ge.model.security.User;
import ge.security.SessionUtils;
import ge.security.annotation.Access;
import ge.security.annotation.Anonymous;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by bacho on 2/2/15.
 */
@Controller
@RequestMapping(value = "/")
public class ApplicationController {

	@RequestMapping(value = "test")
	@ResponseBody
	public User test(User user) {
		return user;
	}

	@Access("ADMINa")
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
				user.setMessage("Sign In Successful!");
			} else {
				user.setMessage("Password is incorrect!");
			}
		} else {
			user.setMessage("User Not Found!");
		}
		return user;
	}

	@RequestMapping(value = "signOut")
	public void signOut() {
		SessionUtils.getSession().invalidate();
	}
}
