package de.tekup.jpademoa.ctrls;

import de.tekup.jpademoa.entities.ClientEntity;
import de.tekup.jpademoa.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class ClientCtrl {

    private ClientService clientService;

    @RequestMapping(path = "/clients/add",method = RequestMethod.POST)
    @ResponseBody
    public ClientEntity saveClient(@RequestBody ClientEntity client){
        return clientService.insertClient(client);
    }

    @RequestMapping(path = "/clients/all",method = RequestMethod.GET)
    @ResponseBody
    public List<ClientEntity> getClients(){
        return clientService.selectAllFrom();
    }

    //@RequestMapping(path = "/clients/{id}",method = RequestMethod.GET)
    @GetMapping("/clients/{id}")
    @ResponseBody
    public ClientEntity getClientById(@PathVariable("id") int clientId){
       return clientService.getClientById(clientId);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public String handleIllegalArgsException(IllegalArgumentException e){
        return "Error in search :"+e.getMessage();
    }
}
