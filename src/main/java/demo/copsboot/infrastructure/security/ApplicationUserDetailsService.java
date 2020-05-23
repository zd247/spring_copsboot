package demo.copsboot.infrastructure.security;

import demo.copsboot.model.User;
import demo.copsboot.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * The UserDetailsService interface implementation,
 * this is used to retrieve user-related data.
 */
@Service
public class ApplicationUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public ApplicationUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByEmailIgnoreCase(username)
                .orElseThrow(()-> new UsernameNotFoundException(
                        String.format("User with email %s could not be found", username)
                ));
        // wrap user object in the ApplicationUserDetail object for the Spring Security to further handle it
        return new ApplicationUserDetails(user);
    }
}
