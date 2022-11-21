package de.tekup.jpademoa.ctrls;

import de.tekup.jpademoa.entities.VoitureEntity;
import de.tekup.jpademoa.services.VoitureService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/voitures/ui")
 @AllArgsConstructor
public class ViewVoitureCtrl {
    private VoitureService voitureService;
    @GetMapping("/")
    public String displayAllCars(Model model){
        model.addAttribute("voitures",voitureService.getAllVoitures());
        return "car";
    }


}
