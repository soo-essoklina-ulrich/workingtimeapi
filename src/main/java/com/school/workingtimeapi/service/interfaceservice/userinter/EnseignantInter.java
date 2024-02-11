package com.school.workingtimeapi.service.interfaceservice.userinter;

import com.school.workingtimeapi.entity.user.Enseignant;

import java.util.List;

public interface EnseignantInter {

    List<Enseignant> findAll();

    Enseignant save(Enseignant e);

    Enseignant update(Long id , Enseignant e);

    void delete(Long id);

    List<Enseignant> findEnseignantByNom(String nom);
    List<Enseignant> findEnseignantByPrenom(String prenom);
    List<Enseignant> findEnseignantByTelephone(Integer telephone);
    List<Enseignant> findEnseignantByNomAndPrenomAndTelephone(String nom, String prenom, Integer telephone);

}
