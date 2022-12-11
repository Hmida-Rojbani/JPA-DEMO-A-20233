package de.tekup.jpademoa.ctrls;

import de.tekup.jpademoa.entities.LocationEntity;
import de.tekup.jpademoa.services.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class LocationCtrl {
    private LocationService locationService;

    @PostMapping("/locations/add/client/{clientId}/voiture/{voitureId}")
    
    public LocationEntity registerLocation(@PathVariable("clientId") int clientId,
                               @RequestBody LocationEntity location,
                               @PathVariable("voitureId") int voitureId){
        return locationService.saveLocation(location,clientId,voitureId);
    }
}
