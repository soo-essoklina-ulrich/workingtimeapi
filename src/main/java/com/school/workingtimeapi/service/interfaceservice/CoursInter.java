package com.school.workingtimeapi.service.interfaceservice;

import com.school.workingtimeapi.entity.Cours;

import java.sql.SQLException;
import java.util.List;

public interface CoursInter {

    List<Cours> findAll();

    Cours save(Cours cours);

    Cours update(Long id, Cours cours) throws SQLException;

    void delete(Long id);

}
