package demo.copsboot.infrastructure.security;

import demo.copsboot.model.UserFactory;
import demo.copsboot.model.UserRepository;
import org.junit.Test;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ApplicationUserDetailsServiceTest {

    @Test
    public void givenExistingUsername_whenLoadingUser_userIsReturned() {
        // create a mock of main repository
        UserRepository repository = mock(UserRepository.class);

        // initialize service
        ApplicationUserDetailsService service = new ApplicationUserDetailsService(repository);

        when(repository.findByEmailIgnoreCase(UserFactory.OFFICER_EMAIL))
                .thenReturn(Optional.of(UserFactory.officer()));

        UserDetails userDetails = service.loadUserByUsername(UserFactory.OFFICER_EMAIL);
    }
}
