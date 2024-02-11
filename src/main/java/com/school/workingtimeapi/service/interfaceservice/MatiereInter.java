package com.school.workingtimeapi.service.interfaceservice;

import com.school.workingtimeapi.entity.Matiere;

import java.util.List;

public interface MatiereInter {
    List<Matiere> findAll();

    Matiere save(Matiere m);

    Matiere update (Long id,Matiere m);

    void delete(Long id);

    Matiere findByCode(String code);

    Matiere findByIntitule(String intitule);

    Matiere findByIntituleAndCode(String intitule, String code);
}
