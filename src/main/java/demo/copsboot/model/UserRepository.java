package demo.copsboot.model;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID>, UserRepositoryCustom {
    
}
