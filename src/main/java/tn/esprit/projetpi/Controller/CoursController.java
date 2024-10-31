package tn.esprit.projetpi.Controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projetpi.Entities.Cours;
import tn.esprit.projetpi.Entities.User;
import tn.esprit.projetpi.Services.CoursImpt;
import tn.esprit.projetpi.Services.UserImpl;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("cours")
@CrossOrigin("*")

public class CoursController {
    @Autowired
    CoursImpt coursImpt;
    UserImpl userImpl;

    @PostMapping("/addC")
    public Cours addCour(@RequestBody Cours c){
        return coursImpt.addCours(c);
    }

    @PutMapping("/updateC")
    public Cours updateC(@RequestBody Cours cours){
        return coursImpt.updateCours(cours);
    }

    @GetMapping("/getall")
    public List<Cours>getallC(){
        return coursImpt.getAll();
    }

    @GetMapping("/getById/{idC}")
    public Cours getByIdC(@PathVariable("idC") Long idcour){
        return  coursImpt.getById(idcour);
    }

    @DeleteMapping("/deleteC/{idCo}")
    public void delete (@PathVariable("idCo") long idcour){
        coursImpt.deleteCours(idcour);
    }

    @PutMapping("/update/{id}")
    public Cours updateSalle(@PathVariable Long id,@RequestBody Cours c){
        Cours existingCour = coursImpt.getById(id);
        Cours updatedcour = null;

        if(existingCour != null){

            existingCour.setDate(c.getDate());
            existingCour.setDescription(c.getDescription());
            existingCour.setCategorie(c.getCategorie());
            existingCour.setPrix(c.getPrix());
            existingCour.setDuree(c.getDuree());
            existingCour.setNb_participant(c.getNb_participant());
           

            updatedcour = coursImpt.updateCours(c);
        }
        return updatedcour;
    }


    @PostMapping("/ajouterOffer/{userId}")
    public ResponseEntity<?> AddOfferToUser(@RequestBody Cours offer, @PathVariable("userId") Long userId ) {
        User user = userImpl.getUserById(userId); // Récupérer l'utilisateur

        if (user == null) {
            return ResponseEntity.badRequest().body("Utilisateur non trouvé");
        }


        coursImpt.AddCoursToUser(offer , user ); // Ajouter l'offre en l'associant à l'utilisateur
        // Envoyer la notification à l'admin

        return ResponseEntity.ok("Offre ajoutée avec succès");
        //return offerService.AddOfferToUser(offer, user);


    }


}
