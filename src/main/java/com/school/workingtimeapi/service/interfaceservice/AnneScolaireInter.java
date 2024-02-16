package com.school.workingtimeapi.service.interfaceservice;

import com.school.workingtimeapi.entity.AnneeScolaire;

import java.sql.SQLException;
import java.util.List;

public interface AnneScolaireInter {
    List<AnneeScolaire> findAll();

    AnneeScolaire save(AnneeScolaire anneeScolaire);
    AnneeScolaire update(Long id, AnneeScolaire anneeScolaire) throws SQLException;
    void delete(Long id);

}
