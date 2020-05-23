package demo.copsboot.model;

import com.google.common.collect.Sets;
import com.sun.istack.NotNull;
import demo.orm.jpa.AbstractEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="copsboot_user")
public class User extends AbstractEntity<UserId> {
    private String email;
    private String password;

    @ElementCollection(fetch= FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @NotNull
    private Set<UserRole> roles;

    protected User() {}

    public static User createOfficer(UserId userId, String email, String encodedPassword) {
        return new User(userId, email, encodedPassword, Sets.newHashSet(UserRole.OFFICER));
    }

    public static User createCaptain(UserId userId, String email, String encodedPassword) {
        return new User(userId, email, encodedPassword, Sets.newHashSet(UserRole.CAPTAIN));
    }

    public User(UserId id, String email, String password, Set<UserRole> roles) {
        super(id);
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }
}
