package de.tekup.jpademoa.ctrls;

import de.tekup.jpademoa.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
