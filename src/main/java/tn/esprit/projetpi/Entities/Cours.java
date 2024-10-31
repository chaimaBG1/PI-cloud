package tn.esprit.projetpi.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cours implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCours;


    private String categorie;
    private Date date;
    private String description;
    private int duree;
    private float prix;

    private int nb_participant;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "cour")
    private Set<Participation>participations;

    @ManyToOne
    @ToString.Exclude

    //@JoinColumn(name = "tuteur_id")
    User tuteur;






}
