package demo.copsboot.model;

import demo.orm.jpa.InMemoryUniqueIdGenerator;
import demo.orm.jpa.UniqueIdGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository repository; //CRUD repository to be tested on

    // this method contains your test
    @Test
    public void testStoreUser() {
        HashSet<UserRole> roles = new HashSet<>();
        roles.add(UserRole.OFFICER);
        User user = repository.save(new User(
                    repository.nextId(),
                    "test@gmail.com",
                    "password",
                    roles
                )
        );

        // Test assertion
        assertThat(user).isNotNull();
        assertThat(repository.count()).isEqualTo(1L);
    }

    @Test
    public void testFindByEmail() {
        User user = UserFactory.newRandomOfficer();
        repository.save(user);
        Optional<User> optional = repository.findByEmailIgnoreCase(user.getEmail());

        //Test assertion
        assertThat(optional).isNotEmpty().contains(user);
    }

    @TestConfiguration
    static class TestConfig {
        @Bean
        public UniqueIdGenerator<UUID> generator() {
            return new InMemoryUniqueIdGenerator();
        }
    }

}
