package de.tekup.jpademoa.repos;

import de.tekup.jpademoa.entities.LocationEntity;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<LocationEntity,Integer> {
}
