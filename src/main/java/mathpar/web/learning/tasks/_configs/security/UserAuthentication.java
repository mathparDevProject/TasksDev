package mathpar.web.learning.tasks._configs.security;

import mathpar.web.learning.tasks.utils.SecurityUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

public class UserAuthentication implements Authentication {
    private final String token;

    public UserAuthentication(String token) {
        this.token = token;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_AUTHENTICATED"));
    }

    @Override
    public String getCredentials() {
        return token;
    }

    @Override
    public String getDetails() {
        return token;
    }

    @Override
    public Long getPrincipal() {
        return SecurityUtils.extractAccountId(token);
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
    }

    @Override
    public String getName() {
        return token;
    }
}
