package tn.esprit.projetpi.Services;
import jakarta.transaction.Transactional;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projetpi.Entities.Cours;
import tn.esprit.projetpi.Entities.User;
import tn.esprit.projetpi.Repository.CoursRepo;

import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class CoursService implements CoursImpt{
    @Autowired
    CoursRepo coursRepo;
    @Override
    public Cours addCours(Cours c) {

        return coursRepo.save(c);
    }

    @Override
    public Cours updateCours(Cours cour) {
        return coursRepo.save(cour);
    }

    @Override
    public List<Cours> getAll() {
        return coursRepo.findAll();
    }

    @Override
    public Cours getById(Long idCours) {
        return coursRepo.findById(idCours).get();
    }

    @Override
    public void deleteCours(Long idCours) {
         coursRepo.deleteById(idCours);
    }

    @Override
    @Transactional
    public Cours AddCoursToUser(Cours offer, User user) {
        offer.setTuteur(user); // Affecter l'utilisateur à l'offre

        return coursRepo.save(offer);
    }





}
