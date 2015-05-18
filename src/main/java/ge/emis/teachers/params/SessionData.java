package ge.emis.teachers.params;

import ge.emis.teachers.model.security.User;

import java.io.Serializable;

/**
 * Created by bacho on 4/15/15.
 */
public class SessionData implements Serializable {
	private static final long serialVersionUID = 1L;
	private User user;

	public SessionData(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
