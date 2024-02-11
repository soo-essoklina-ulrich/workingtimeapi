package com.school.workingtimeapi.service.interfaceservice.userinter;

import com.school.workingtimeapi.entity.user.Etudiant;

import java.util.List;

public interface EtudiantInter {

    List<Etudiant> findAll();

    Etudiant save(Etudiant e);

    Etudiant update(Long id, Etudiant e);

    void delete(Long id);
}
