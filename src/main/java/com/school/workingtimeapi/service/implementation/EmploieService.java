package com.school.workingtimeapi.service.implementation;

import com.school.workingtimeapi.entity.EmploieTemps;
import com.school.workingtimeapi.repository.EmploieTempsRepository;
import com.school.workingtimeapi.service.interfaceservice.EmploieInter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmploieService implements EmploieInter {
    private final EmploieTempsRepository emploieTempsRepository;

    public EmploieService(EmploieTempsRepository emploieTempsRepository) {
        this.emploieTempsRepository = emploieTempsRepository;
    }

    @Override
    public List<EmploieTemps> findAll() {
        return this.emploieTempsRepository.findAll();
    }

    @Override
    public EmploieTemps save(EmploieTemps e) {
        return this.emploieTempsRepository.save(e);
    }

    @Override
    public EmploieTemps update(Long id, EmploieTemps e) {
        EmploieTemps emploieTemps = this.emploieTempsRepository.findById(id).orElseThrow(()-> new RuntimeException("EmploieTemps not found"));
        BeanUtils.copyProperties(e, emploieTemps, "id");
        return this.emploieTempsRepository.save(emploieTemps);
    }

    @Override
    public void delete(Long id) {
        this.emploieTempsRepository.deleteById(id);
    }
}
