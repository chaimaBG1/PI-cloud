package tn.esprit.projetpi.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.projetpi.Entities.User;
import tn.esprit.projetpi.Repository.UserRepo;

@Service
@AllArgsConstructor
public class UserService implements UserImpl{
    UserRepo userRepo;
    @Override
    public User getUserById(Long userId) {
        return userRepo.findById(userId).orElse(null);
    }
}
