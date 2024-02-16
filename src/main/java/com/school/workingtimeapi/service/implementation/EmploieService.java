package com.school.workingtimeapi.service.implementation;

import com.school.workingtimeapi.entity.EmploieTemps;
import com.school.workingtimeapi.repository.EmploieTempsRepository;
import com.school.workingtimeapi.service.interfaceservice.EmploieInter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
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
        try{
            EmploieTemps lastItememploieTemps = this.emploieTempsRepository.lastItem();
            if (lastItememploieTemps != null) {
                if (lastItememploieTemps.getHeurefin().before(e.getHeuredebut())) {
                    return this.emploieTempsRepository.save(e);
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }catch (Exception ex){
            System.out.print(ex);
            return this.emploieTempsRepository.save(e);
        }

    }

    @Override
    public EmploieTemps update(Long id, EmploieTemps e) {
        try{
            EmploieTemps emploieTemps = this.emploieTempsRepository.findById(id).orElseThrow(() -> new SQLException("EmploieTemps not found"));
            BeanUtils.copyProperties(e, emploieTemps, "id");
            return this.emploieTempsRepository.save(emploieTemps);

        }catch (Exception ex){
            return null;
        }

    }

    @Override
    public void delete(Long id) {
        this.emploieTempsRepository.deleteById(id);
    }
}
