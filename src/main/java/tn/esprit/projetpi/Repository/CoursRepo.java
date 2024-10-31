package tn.esprit.projetpi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.projetpi.Entities.Cours;
@Repository
public interface CoursRepo extends JpaRepository<Cours,Long> {
}
