package ge.security;

import ge.model.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * Created by bacho on 8/19/14.
 */
public final class CustomParamAuthenticationToken extends UsernamePasswordAuthenticationToken {
    private String dgNum;

    // used for attempting authentication
    public CustomParamAuthenticationToken(String principal, String credentials, String dgNum) {
        super(principal, credentials);
        this.dgNum = dgNum;
    }

    public CustomParamAuthenticationToken(User principal, String credentials, String dgNum) {
        super(principal, credentials, principal.getAuthorities());
        this.dgNum = dgNum;
    }

    public String getDgNum() {
        return dgNum;
    }
}