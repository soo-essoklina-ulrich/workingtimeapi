package com.school.workingtimeapi.service.interfaceservice;

import com.school.workingtimeapi.entity.Classe;

import java.util.List;

public interface ClasseInter {

    List<Classe> findAll();

    Classe save(Classe classe);

    Classe update(Long id ,Classe classe);

    void delete(Long id);


}
