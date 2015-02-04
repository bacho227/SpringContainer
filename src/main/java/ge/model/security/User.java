package ge.model.security;

import java.io.Serializable;
import java.util.List;


public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer userId;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String personalNo;

	private List<Permission> permissions;
	private boolean accountIsLocked = false;
	private boolean enabled = true;
	private String message;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPersonalNo() {
		return personalNo;
	}

	public void setPersonalNo(String personalNo) {
		this.personalNo = personalNo;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	public boolean isAccountIsLocked() {
		return accountIsLocked;
	}

	public void setAccountIsLocked(boolean accountIsLocked) {
		this.accountIsLocked = accountIsLocked;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
