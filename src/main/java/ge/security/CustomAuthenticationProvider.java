package ge.security;

import ge.model.Role;
import ge.model.UserManager;
import ge.model.User;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

//    @Autowired
//    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        System.out.println(username + "  >>>>>>>>>>>>   " + password);
//        CustomParamAuthenticationToken token = (CustomParamAuthenticationToken) authentication;
//        String username = token.getName();
//        String password = (String) token.getCredentials();
//        String dgNum = token.getDgNum();
        User user = UserManager.getUserByParams(username);
        if (user == null) {
            throw new BadCredentialsException("Username not found!");
        }
        if (!password.equals(user.getPassword())) {
            throw new BadCredentialsException("Wrong password!");
        }
//        if (!dgNum.equals("1111")) {
//            throw new BadCredentialsException("Wrong dgNum!");
//        }
        List<Role> roles = new ArrayList<>();
//        roles.add(new Role("ROLE_USER", 1));
        return new UsernamePasswordAuthenticationToken(user, password, user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

}
