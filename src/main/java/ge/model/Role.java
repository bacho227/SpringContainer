package ge.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * User's Roles will be supplied from this class.
 * Role class implements Spring-Security GrantedAuthority interface for custom authentication feature
 *
 * @author aakin
 */
public class Role implements GrantedAuthority {
    private static final long serialVersionUID = 1L;

    private String name;
    private Integer roleId;

    public Role(String name, Integer roleId) {
        this.roleId = roleId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getRoleId() {
        return roleId;
    }

    @Override
    public String getAuthority() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Role {" +
                "name = '" + name + '\'' +
                "roleId = '" + roleId + '\'' +
                '}';
    }
}
