package kea.iabr.touristguideapi.repository;

import kea.iabr.touristguideapi.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    private ArrayList<TouristAttraction> attractions = new ArrayList();

    public TouristRepository(){
        populateAttractions();
    }

    public void populateAttractions(){
        attractions.add(new TouristAttraction("Pride", "Pride parade 2024"));
        attractions.add(new TouristAttraction("Vela", "Queer bar specifikt henvendt sapphics"));
        attractions.add(new TouristAttraction("LGBT+ bibliotek", "Bogsamling hos LGBT+ Danmark"));
        attractions.add(new TouristAttraction("Nørrebro Pride", "Alternativ prideparade, som centraliserer QTBIPOCS"));
    }

    public ArrayList<TouristAttraction> getAllAttractions(){
        return attractions;
    }

    public TouristAttraction findAttractionByName(String name) {
        for(TouristAttraction touristAttraction : attractions) {
            if(touristAttraction.getName().equals(name)) {
                return touristAttraction;
            }
        } return null;
    }

    public TouristAttraction addAttraction(TouristAttraction touristAttraction){
        getAllAttractions().add(touristAttraction);
        return touristAttraction;
    }

    public TouristAttraction updateAttraction(String searchName, TouristAttraction touristAttraction){
        for(TouristAttraction attraction : attractions){
            if(attraction.getName().equalsIgnoreCase(searchName)) {
                attraction.setName(touristAttraction.getName());
                attraction.setDescription(touristAttraction.getDescription());
                return attraction;
            }
        }
        return null;
    }

    public void deleteAttraction(String searchName){
        for(TouristAttraction attraction : attractions){
            if(attraction.getName().equalsIgnoreCase(searchName)) {
                attractions.remove(attraction);
            }
        }
    }


}
