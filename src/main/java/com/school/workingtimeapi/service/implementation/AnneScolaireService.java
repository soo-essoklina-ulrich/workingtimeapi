package com.school.workingtimeapi.service.implementation;

import com.school.workingtimeapi.entity.AnneeScolaire;
import com.school.workingtimeapi.repository.AnneeScolaireRepository;
import com.school.workingtimeapi.service.interfaceservice.AnneScolaireInter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnneScolaireService implements AnneScolaireInter {

    private final AnneeScolaireRepository anneeScolaireRepository;

    public AnneScolaireService(AnneeScolaireRepository an, AnneeScolaireRepository anneeScolaireRepository) {
        this.anneeScolaireRepository = anneeScolaireRepository;
    }

    @Override
    public List<AnneeScolaire> findAll() {
        return this.anneeScolaireRepository.findAll();
    }

    @Override
    public AnneeScolaire save(AnneeScolaire anneeScolaire) {
        return this.anneeScolaireRepository.save(anneeScolaire);
    }

    @Override
    public AnneeScolaire update(Long id, AnneeScolaire anneeScolaire) {
        AnneeScolaire anneeScolaireExisting = this.anneeScolaireRepository.findById(id).orElseThrow(() -> new RuntimeException("Annee Scolaire not found with id: " + id));
        BeanUtils.copyProperties(anneeScolaire, anneeScolaireExisting, "id");
        return this.anneeScolaireRepository.save(anneeScolaireExisting);
    }

    @Override
    public void delete(Long id) {
        this.anneeScolaireRepository.deleteById(id);
    }
}
