package de.tekup.jpademoa.ctrls;

import de.tekup.jpademoa.entities.LocationEntity;
import de.tekup.jpademoa.services.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@AllArgsConstructor
public class LocationCtrl {
    private LocationService locationService;

    @PostMapping("/locations/add/client/{clientId}/voiture/{voitureId}")
    @ResponseBody
    public LocationEntity registerLocation(@PathVariable("clientId") int clientId,
                               @RequestBody LocationEntity location,
                               @PathVariable("voitureId") int voitureId){
        return locationService.saveLocation(location,clientId,voitureId);
    }
}
