package ge.emis.teachers.security;

import ge.emis.teachers.params.SessionData;
import ge.emis.teachers.model.security.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {

	public static final String SESSION_DATA_KEY = "SESSION_DATA";

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

	public static User getUser() {
		SessionData sessionData = getSessionData();
		if (sessionData != null) {
			return sessionData.getUser();
		}
		return null;
	}

	public static User getUser(HttpSession session) {
		SessionData sessionData = getSessionData(session);
		if (sessionData != null) {
			return sessionData.getUser();
		}
		return null;
	}

	public static void setSessionData(SessionData sessionData) {
		getSession().setAttribute(SessionUtils.SESSION_DATA_KEY, sessionData);
	}

	public static SessionData getSessionData() {
		HttpSession session = getSession();
		SessionData sessionData = null;
		if (session != null) {
			sessionData = (SessionData) session.getAttribute(SESSION_DATA_KEY);
		}
		return sessionData;
	}

	public static SessionData getSessionData(HttpSession session) {
		SessionData sessionData = null;
		if (session != null) {
			sessionData = (SessionData) session.getAttribute(SESSION_DATA_KEY);
		}
		return sessionData;
	}

	public static void removeUser() {
		getSession().invalidate();
	}

}