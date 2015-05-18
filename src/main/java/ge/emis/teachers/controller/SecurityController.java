package ge.emis.teachers.controller;

import ge.emis.teachers.message.MessageException;
import ge.emis.teachers.message.Status;
import ge.emis.teachers.model.security.User;
import ge.emis.teachers.params.SessionData;
import ge.emis.teachers.security.SessionUtils;
import ge.emis.teachers.security.annotation.Anonymous;
import ge.emis.teachers.service.SecurityService;
import ge.emis.teachers.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by Bacho on 2/9/15.
 */

@Controller
@RequestMapping(value = "/security/")
public class SecurityController {

	@Autowired
	private SecurityService securityService;

	@Anonymous
	@ResponseBody
	@RequestMapping(value = "signIn", method = RequestMethod.POST)
	public void signIn(@RequestParam String username, @RequestParam String password) throws MessageException {
		User user = new User();//securityService.getUserByUsername(username);
		user.setUsername(username);
		user.setPassword("098f6bcd4621d373cade4e832627b4f6");
		user.setFirstName("test");
		user.setLastName("test");
		if (user == null) {
			throw new MessageException(Status.badUser());
		}
		if (user.getPassword().equals(Utils.getMD5(password)) == false) {
			throw new MessageException(Status.badPassword());
		}
		user.setPassword(null);
//		user.loadPermissions();
		SessionData sessionData = new SessionData(user);
		SessionUtils.setSessionData(sessionData);
	}

	@Anonymous
	@RequestMapping(value = "signOut")
	public String signOut() {
		SessionUtils.removeUser();
		return "redirect:/login.html";
	}

	@RequestMapping(value = "getUser")
	@ResponseBody
	public User getUser(SessionData sessionData) throws MessageException {
		return sessionData.getUser();
	}

}