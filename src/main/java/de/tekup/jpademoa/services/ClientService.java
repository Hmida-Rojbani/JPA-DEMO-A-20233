package de.tekup.jpademoa.services;

import de.tekup.jpademoa.entities.ClientEntity;
import de.tekup.jpademoa.repos.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public ClientEntity insertClient(ClientEntity client){
       return clientRepository.save(client);
    }

    public List<ClientEntity> selectAllFrom(){
        return (List<ClientEntity>) clientRepository.findAll();
    }

    //TODO
    // add method to search Client By ID and call it in Controller
}
