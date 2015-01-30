package ge.security;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by bacho on 8/20/14.
 */
public final class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }
        String username = request.getParameter("username");
        username = username.trim();
        String password = request.getParameter("password");
        String dgNum = request.getParameter("dgNum");
        CustomParamAuthenticationToken authRequest = new CustomParamAuthenticationToken(username, password, dgNum);
        setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);
    }

}