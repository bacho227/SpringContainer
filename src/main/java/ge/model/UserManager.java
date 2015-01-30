package ge.model;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bacho on 8/25/14.
 */
public class UserManager {
    public static User getUserByParams(String userName) {
        User user = null;
        //TODO custom select here for user
        if (userName.equals("test")) {
            user = new User();
            user.setUsername(userName);
            user.setPassword("test");
            loadRolesToUser(user);
        }
        return user;
    }

    private static void loadRolesToUser(User user) {
        List<Role> roles = new ArrayList<Role>();
        //TODO custom select here for roles
        roles.add(new Role("USER", 1));
        roles.add(new Role("ROLE_ADMIN", 2));
        user.setAuthorities(roles);
    }

    public static User getUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = null;
        try {
            user = (User) auth.getPrincipal();
        } catch (ClassCastException ex) {
            //anonymousUser
        }
        return user;
    }
}
