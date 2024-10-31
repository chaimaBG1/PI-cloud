package tn.esprit.projetpi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.projetpi.Entities.User;
@Repository
public interface UserRepo extends JpaRepository<User,Long> {
}
