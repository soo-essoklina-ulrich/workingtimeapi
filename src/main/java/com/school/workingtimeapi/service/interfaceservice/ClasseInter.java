package com.school.workingtimeapi.service.interfaceservice;

import com.school.workingtimeapi.entity.Classe;

import java.sql.SQLException;
import java.util.List;

public interface ClasseInter {

    List<Classe> findAll();

    Classe save(Classe classe);

    Classe update(Long id ,Classe classe) throws SQLException;

    void delete(Long id);


}
