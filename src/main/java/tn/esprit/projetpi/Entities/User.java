package tn.esprit.projetpi.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static jakarta.persistence.GenerationType.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity

public class User {
    @Id
    @GeneratedValue(strategy= IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private int cin;
    private LocalDate dateNaissance;
    private int numtel;
    private String email;
    private String adresse;
    private String mdp;
    @Enumerated(EnumType.STRING)
    private Role role;



    @OneToMany(mappedBy = "tuteur")
    @ToString.Exclude
    @JsonIgnore
    List<Cours> Offers;
}
