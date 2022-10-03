package de.tekup.jpademoa.repos;

import de.tekup.jpademoa.entities.ClientEntity;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<ClientEntity,Integer> {
}
