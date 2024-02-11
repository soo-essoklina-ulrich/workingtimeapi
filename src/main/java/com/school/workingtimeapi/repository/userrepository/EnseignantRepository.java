package com.school.workingtimeapi.repository.userrepository;

import com.school.workingtimeapi.entity.user.Enseignant;
import com.school.workingtimeapi.entity.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {


    List<Enseignant> findEnseignantByRole(Role role);
    List<Enseignant> findEnseignantByNom(String nom);
    List<Enseignant> findEnseignantByPrenom(String Prenom);
    List<Enseignant> findEnseignantByTelephone(Integer Telehpone);
    List<Enseignant> findEnseignantByNomAndPrenomAndTelephone(String nom, String prenom, Integer telephone);
}
