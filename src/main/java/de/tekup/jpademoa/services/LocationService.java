package de.tekup.jpademoa.services;

import de.tekup.jpademoa.entities.ClientEntity;
import de.tekup.jpademoa.entities.LocationEntity;
import de.tekup.jpademoa.repos.LocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LocationService {

    private ClientService clientService;
    private LocationRepository locationRepository;
    //TODO add insert Location into DB
    public LocationEntity saveLocation(LocationEntity location,
                                       int clientId){
        ClientEntity client = clientService.getClientById(clientId);
        location.setClient(client);
        return locationRepository.save(location);
    }
}
