package ge.model;

import ge.model.security.Permission;
import ge.model.security.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bacho on 8/25/14.
 */
public class UserManager {
	public static User getUserByUserName(String userName) {
		User user = new User();
		//TODO custom select here for user
		if (userName.equals("test")) {
			user.setUsername(userName);
			user.setPassword("test");
			user.setFirstName("firstName");
			user.setLastName("lastName");
			user.setPersonalNo("01234567890");
			user.setUserId(1);
			loadPermissionsToUser(user);
		}
		return user;
	}

	private static void loadPermissionsToUser(User user) {
		List<Permission> permissions = new ArrayList<>();
		//TODO custom select here for permissions
		permissions.add(new Permission("USER", 1));
		permissions.add(new Permission("ADMIN", 2));
		permissions.add(new Permission("SOME_PERMISSION", 3));
		user.setPermissions(permissions);
	}
}
