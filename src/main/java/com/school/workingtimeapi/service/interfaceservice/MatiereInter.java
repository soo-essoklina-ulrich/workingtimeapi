package com.school.workingtimeapi.service.interfaceservice;

import com.school.workingtimeapi.entity.Matiere;

import java.sql.SQLException;
import java.util.List;

public interface MatiereInter {
    List<Matiere> findAll();

    Matiere save(Matiere m);

    Matiere update (Long id,Matiere m) throws SQLException;

    void delete(Long id);

    Matiere findByCode(String code);

    Matiere findByIntitule(String intitule);

    Matiere findByIntituleAndCode(String intitule, String code);
}
