package demo.copsboot.infrastructure.security;

import demo.copsboot.model.User;
import demo.copsboot.model.UserId;
import demo.copsboot.model.UserRole;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This models core user information retrieved by a UserDetailsService.
 * Visit :https://docs.spring.io/spring-security/site/docs/3.0.x/apidocs/org/springframework/security/core/userdetails/User.html
 * for more information
 */
public class ApplicationUserDetails extends org.springframework.security.core.userdetails.User{
    private static final String ROLE_PREFIX = "ROLE_";

    private final UserId userId;

    public ApplicationUserDetails(User user) {
        super(user.getEmail(), user.getPassword(), createAuthorities(user.getRoles()));
        this.userId = user.getId();
    }

    public UserId getUserId() {
        return userId;
    }
    // converting UserRole to SimpleGrantedAuthority to ensure Spring Security is aware of the role of each user
    private static Collection<SimpleGrantedAuthority> createAuthorities(Set<UserRole> roles) {
        return roles.stream()
                .map(userRole -> new SimpleGrantedAuthority(ROLE_PREFIX + userRole.name()))
                .collect(Collectors.toSet());
    }
}
