package de.tekup.jpademoa.ctrls;

import de.tekup.jpademoa.entities.ClientEntity;
import de.tekup.jpademoa.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ClientCtrl {

    private ClientService clientService;

    @RequestMapping(path = "/clients/add",method = RequestMethod.POST)
    
    public ClientEntity saveClient(@RequestBody ClientEntity client){
        return clientService.insertClient(client);
    }

    @RequestMapping(path = "/clients/all",method = RequestMethod.GET)
    
    public List<ClientEntity> getClients(){
        return clientService.selectAllFrom();
    }

    //@RequestMapping(path = "/clients/{id}",method = RequestMethod.GET)
    @GetMapping("/clients/{id}")
    
    public ClientEntity getClientById(@PathVariable("id") int clientId){
       return clientService.getClientById(clientId);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    
    public String handleIllegalArgsException(IllegalArgumentException e){
        return "Error in search :"+e.getMessage();
    }
}
