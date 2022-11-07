package de.tekup.jpademoa.ctrls;

import de.tekup.jpademoa.entities.ClientEntity;
import de.tekup.jpademoa.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/clients/ui")
@AllArgsConstructor
public class ClientsViewCtrl {
    private ClientService clientService;

    @GetMapping("/display")
    public String displayClient(Model model){
        model.addAttribute("clients",clientService.selectAllFrom());
        return "client-display";
    }

    @GetMapping("/add")
    public String addClient(Model model){
        model.addAttribute("client",new ClientEntity());
        return "client-add";
    }

    @PostMapping("/add")
    public String addClientPost(@ModelAttribute("client") @Valid ClientEntity client, BindingResult result, Model model){
        if(result.hasErrors()){
            return "client-add";
        }

        clientService.insertClient(client);
        return "redirect:/clients/ui/display";
    }

}
