package de.tekup.jpademoa.ctrls;

import de.tekup.jpademoa.entities.ClientEntity;
import de.tekup.jpademoa.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ClientCtrl {
    @Autowired
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
}
