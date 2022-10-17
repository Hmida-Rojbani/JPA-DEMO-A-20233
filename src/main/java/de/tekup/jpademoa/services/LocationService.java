package de.tekup.jpademoa.services;

import de.tekup.jpademoa.entities.ClientEntity;
import de.tekup.jpademoa.entities.LocationEntity;
import de.tekup.jpademoa.entities.VoitureEntity;
import de.tekup.jpademoa.repos.LocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LocationService {

    private ClientService clientService;
    private LocationRepository locationRepository;
    private VoitureService voitureService;
    //TODO add insert Location into DB
    public LocationEntity saveLocation(LocationEntity location,
                                       int clientId, int voitureId){
        ClientEntity client = clientService.getClientById(clientId);
        VoitureEntity voiture = voitureService.getVoitureById(voitureId);
        location.setClient(client);
        location.setVoiture(voiture);
        return locationRepository.save(location);
    }
}
