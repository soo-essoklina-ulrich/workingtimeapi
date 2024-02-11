package com.school.workingtimeapi.service.implementation.userservice;

import com.school.workingtimeapi.entity.user.Enseignant;
import com.school.workingtimeapi.entity.user.Role;
import com.school.workingtimeapi.repository.userrepository.EnseignantRepository;
import com.school.workingtimeapi.service.interfaceservice.userinter.EnseignantInter;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnseignantService implements EnseignantInter {

    private final EnseignantRepository enseignantRepository;

    public EnseignantService(EnseignantRepository enseignantRepository) {
        this.enseignantRepository = enseignantRepository;
    }
    @Override
    public List<Enseignant> findAll() {
        return this.enseignantRepository.findAll();
    }

    @Override
    public Enseignant save(Enseignant e) {
        e.setRole(Role.ENSEIGNANT);
        return this.enseignantRepository.save(e);
    }

    @Override
    public Enseignant update(Long id ,Enseignant eToUpdate) {
        Enseignant enseignantexisting = this.enseignantRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Enseignant not found with id: " + id));
        BeanUtils.copyProperties(eToUpdate, enseignantexisting, "id");
        return this.enseignantRepository.save(eToUpdate);
    }

    @Override
    public void delete(Long id) {
        this.enseignantRepository.deleteById(id);
    }

    @Override
    public List<Enseignant> findEnseignantByNom(String nom) {
        return this.enseignantRepository.findEnseignantByNom(nom);
    }

    @Override
    public List<Enseignant> findEnseignantByPrenom(String prenom) {
        return this.enseignantRepository.findEnseignantByPrenom(prenom);
    }

    @Override
    public List<Enseignant> findEnseignantByTelephone(Integer telephone) {
        return this.enseignantRepository.findEnseignantByTelephone(telephone);
    }

    @Override
    public List<Enseignant> findEnseignantByNomAndPrenomAndTelephone(String nom, String prenom, Integer telephone) {
        return this.enseignantRepository.findEnseignantByNomAndPrenomAndTelephone(nom, prenom, telephone);
    }
}
