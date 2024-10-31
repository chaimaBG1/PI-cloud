package tn.esprit.projetpi.Services;

import tn.esprit.projetpi.Entities.Cours;
import tn.esprit.projetpi.Entities.User;

import java.util.List;

public interface CoursImpt {
    public Cours addCours(Cours c);
    public Cours updateCours(Cours cour);
    public List<Cours>getAll();
    public Cours getById(Long idCours);
    public void deleteCours(Long idCours);
    public Cours AddCoursToUser(Cours offer, User user);
}
