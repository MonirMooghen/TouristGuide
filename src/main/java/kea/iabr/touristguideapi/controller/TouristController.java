package kea.iabr.touristguideapi.controller;

import kea.iabr.touristguideapi.model.TouristAttraction;
import kea.iabr.touristguideapi.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("attractions")
public class TouristController {
    private final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping("")
    public ResponseEntity<List<TouristAttraction>> getAllTouristAttractions() {
        List<TouristAttraction> attractions = touristService.getAllAttractions();
        return new ResponseEntity<>(attractions, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> getAttraction(@PathVariable String name) {
        TouristAttraction touristAttraction = touristService.findAttractionByName(name);
        return new ResponseEntity<>(touristAttraction, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> addAttraction(@RequestBody TouristAttraction touristAttraction) {
        TouristAttraction newAttraction = touristService.addAttraction(touristAttraction);
        return new ResponseEntity<>(newAttraction, HttpStatus.CREATED);
    }

    @PostMapping("/update/{searchName}")
    public ResponseEntity<TouristAttraction> updateAttraction(@PathVariable String searchName, @RequestBody TouristAttraction touristAttraction){
        TouristAttraction newAttraction = touristService.updateAttraction(searchName, touristAttraction);
        return new ResponseEntity<>(newAttraction, HttpStatus.OK);
    }

    @PostMapping("/delete/{searchName}")
    public ResponseEntity<HttpStatus> deleteAttraction(@PathVariable String searchName){
        touristService.deleteAttraction(searchName);
        return new ResponseEntity<>(HttpStatus.GONE);
    }

}
