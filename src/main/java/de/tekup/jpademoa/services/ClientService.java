package de.tekup.jpademoa.services;

import de.tekup.jpademoa.entities.ClientEntity;
import de.tekup.jpademoa.repos.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientService {

    private ClientRepository clientRepository;

    public ClientEntity insertClient(ClientEntity client){
       return clientRepository.save(client);
    }

    public List<ClientEntity> selectAllFrom(){
        return (List<ClientEntity>) clientRepository.findAll();
    }

    //TODO: add method to search Client By ID and call it in Controller
    public ClientEntity getClientById(int id){
        return clientRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Client ID not found"));
    }
    @PostConstruct
    public void initDB(){
        if(clientRepository.count()==0){
            clientRepository.save(new ClientEntity(12345678,"Doe","John","New York"));
            this.insertClient(new ClientEntity(12345679,"Doe","Jane","Los Angelos"));
        }
    }
}
