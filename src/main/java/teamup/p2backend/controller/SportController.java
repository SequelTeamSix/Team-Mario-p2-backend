package teamup.p2backend.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import teamup.p2backend.model.Sport;
import teamup.p2backend.service.SportService;

import java.util.List;

@RestController
@RequestMapping("sport")
public class SportController {
    SportService sportService;

    @Autowired
    public SportController(SportService sportService){this.sportService = sportService;}

   // @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    List<Sport> getSports(){
        return sportService.findAllSports();
    }

    // @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("sportname/{sportname}")
    public Sport getSport(@PathVariable String sportname){
        return sportService.findSport(sportname);
    }

    // @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public Sport postSport(@RequestBody Sport sport){
        return sportService.saveSport(sport);
    }

    // @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping()
    public void deleteSport(@RequestParam String sportname){
        sportService.deleteSport(sportname);
    }


}
