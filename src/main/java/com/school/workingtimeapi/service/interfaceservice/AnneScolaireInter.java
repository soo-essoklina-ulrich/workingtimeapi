package com.school.workingtimeapi.service.interfaceservice;

import com.school.workingtimeapi.entity.AnneeScolaire;

import java.util.List;

public interface AnneScolaireInter {
    List<AnneeScolaire> findAll();

    AnneeScolaire save(AnneeScolaire anneeScolaire);
    AnneeScolaire update(Long id, AnneeScolaire anneeScolaire);
    void delete(Long id);

}
