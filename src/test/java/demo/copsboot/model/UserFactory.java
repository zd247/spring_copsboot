package demo.copsboot.model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

/**
 * FACTORY User class for unit testing
 * The class will generate random & pre-defined Users
 */
public class UserFactory {
    private static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    public static final String OFFICER_EMAIL = "officer@example.com";
    public static final String OFFICER_PASSWORD = "officer";
    public static final String CAPTAIN_EMAIL = "captain@example.com";
    public static final String CAPTAIN_PASSWORD = "captain";

    // Sample officer template
    private static User OFFICER = User.createOfficer(
            newRandomId(),
            OFFICER_EMAIL,
            PASSWORD_ENCODER.encode(OFFICER_PASSWORD)
    );

    // Sample captain template
    private static User CAPTAIN = User.createOfficer(
            newRandomId(),
            CAPTAIN_EMAIL,
            PASSWORD_ENCODER.encode(CAPTAIN_PASSWORD)
    );

    public static UserId newRandomId() {
        return new UserId(UUID.randomUUID());
    }

    // * to be called in unit testing class
    public static User newRandomOfficer() {
        return newRandomOfficer(newRandomId());
    }

    // new random officer with pre-defined email and password.
    public static User newRandomOfficer(UserId userId) {
        String uniqueId = userId.asString().substring(0,5);
        return User.createOfficer(
                userId,
                "user-" + uniqueId + "@example.com",
                PASSWORD_ENCODER.encode("user")
        );
    }

    public static User officer() {
        return OFFICER;
    }

    public static User captain() {
        return CAPTAIN;
    }

    private UserFactory() {}

}
