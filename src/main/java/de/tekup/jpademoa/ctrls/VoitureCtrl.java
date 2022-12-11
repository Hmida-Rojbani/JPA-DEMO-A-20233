package de.tekup.jpademoa.ctrls;


import de.tekup.jpademoa.entities.VoitureEntity;
import de.tekup.jpademoa.services.VoitureService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class VoitureCtrl {

    private VoitureService voitureService;
    @PostMapping("/voitures/save")
    
    public VoitureEntity saveVoiture(@RequestBody VoitureEntity voiture){
        return voitureService.insertIntoDB(voiture);
    }
    @GetMapping("/voitures")
    
    public List<VoitureEntity> getAllVoitures(){
        return voitureService.getAllVoitures();
    }

    @GetMapping("/voitures/{id}")
    
    public VoitureEntity getVoitureById(@PathVariable("id") int voitureId){
        return voitureService.getVoitureById(voitureId);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    
    public String handleIllegalArgumentException(IllegalArgumentException e ){
        return e.getMessage();
    }
}
