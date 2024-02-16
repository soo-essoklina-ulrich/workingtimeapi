package com.school.workingtimeapi.entity;

import com.school.workingtimeapi.entity.user.Enseignant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_matiere")
    private Matiere matieres;
    @ManyToOne
    @JoinColumn(name = "id_enseignant")
    private Enseignant enseignant;
    @ManyToOne
    @JoinColumn(name = "id_classe")
    private Classe classe;
    @ManyToOne
    @JoinColumn(name = "id_annee_scolaire")
    private AnneeScolaire anneescolaire;
}
