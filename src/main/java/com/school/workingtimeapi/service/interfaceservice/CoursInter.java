package com.school.workingtimeapi.service.interfaceservice;

import com.school.workingtimeapi.entity.Cours;

import java.util.List;

public interface CoursInter {

    List<Cours> findAll();

    Cours save(Cours cours);

    Cours update(Long id, Cours cours);

    void delete(Long id);

}
