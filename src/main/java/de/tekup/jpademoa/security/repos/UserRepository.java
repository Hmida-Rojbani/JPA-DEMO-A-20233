package de.tekup.jpademoa.security.repos;

import de.tekup.jpademoa.security.entites.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Integer> {

}
