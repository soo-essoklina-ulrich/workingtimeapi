package com.school.workingtimeapi.service.interfaceservice;

import com.school.workingtimeapi.entity.EmploieTemps;

import java.util.List;

public interface EmploieInter {
    List<EmploieTemps> findAll();
    EmploieTemps save (EmploieTemps e);
    EmploieTemps update (Long id, EmploieTemps e);
    void delete (Long id);
}
