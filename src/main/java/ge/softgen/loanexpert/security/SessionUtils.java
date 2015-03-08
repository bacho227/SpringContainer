package ge.softgen.loanexpert.security;

import ge.softgen.loanexpert.model.SecUser;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {

	public static final String SESSION_DATA_KEY = "data";

	public static SecUser getUser() {
		HttpSession session = getSession();
		SecUser user;
		if (session != null) {
			user = (SecUser) session.getAttribute(SESSION_DATA_KEY);
		} else {
			user = null;
		}
		return user;
	}

	public static SecUser getUser(HttpSession session) {
		SecUser user;
		if (session != null) {
			user = (SecUser) session.getAttribute(SESSION_DATA_KEY);
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
		SecUser user = getUser();
		if (user == null) {
			userId = null;
		} else {
			userId = user.getId();
		}
		return userId;
	}

}
