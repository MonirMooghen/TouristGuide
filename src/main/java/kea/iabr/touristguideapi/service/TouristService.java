package kea.iabr.touristguideapi.service;

import kea.iabr.touristguideapi.model.TouristAttraction;
import kea.iabr.touristguideapi.repository.TouristRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class TouristService {
    private final TouristRepository touristRepository;

    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    public ArrayList<TouristAttraction> getAllAttractions() {
        return touristRepository.getAllAttractions();
    }

    public TouristAttraction findAttractionByName(String name){
        return touristRepository.findAttractionByName(name);
    }

    public TouristAttraction addAttraction(TouristAttraction touristAttraction) {
        return touristRepository.addAttraction(touristAttraction);
    }

    public TouristAttraction updateAttraction(String searchName, TouristAttraction touristAttraction) {
        return touristRepository.updateAttraction(searchName, touristAttraction);
    }

    public void deleteAttraction(String searchName) {
        touristRepository.deleteAttraction(searchName);
    }

}
