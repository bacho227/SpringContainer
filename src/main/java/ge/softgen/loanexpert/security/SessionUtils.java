package ge.softgen.loanexpert.security;

import ge.softgen.loanexpert.model.security.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {

	public static final String SESSION_DATA_KEY = "data";

	public static User getUser() {
		HttpSession session = getSession();
		User user;
		if (session != null) {
			user = (User) session.getAttribute(SESSION_DATA_KEY);
		} else {
			user = null;
		}

		return user;
	}

	public static User getUser(HttpSession session) {
		User user;
		if (session != null) {
			user = (User) session.getAttribute(SESSION_DATA_KEY);
		} else {
			user = null;
		}

		return user;
	}

	public static HttpServletRequest getRequest() {
		HttpServletRequest request;
		try {
			ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
			request = attributes.getRequest();
		} catch (Exception ex) {
			ex.printStackTrace();
			request = null;
		}

		return request;
	}

	public static HttpSession getSession() {
		HttpSession session;
		try {
			session = getRequest().getSession();
		} catch (Exception ex) {
			ex.printStackTrace();
			session = null;
		}

		return session;
	}

	public static Integer getUserId() {
		Integer userId;
		User user = getUser();
		if (user == null) {
			userId = null;
		} else {
			userId = user.getUserId();
		}

		return userId;
	}

}
