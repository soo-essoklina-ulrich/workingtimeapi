package com.school.workingtimeapi.service.implementation;

import com.school.workingtimeapi.entity.Cours;
import com.school.workingtimeapi.repository.CoursRepository;
import com.school.workingtimeapi.service.interfaceservice.CoursInter;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CoursService implements CoursInter {
    private final CoursRepository coursRepository;

    public CoursService(CoursRepository coursRepository) {
        this.coursRepository = coursRepository;
    }
    @Override
    public List<Cours> findAll() {
        return this.coursRepository.findAll();
    }

    @Override
    public Cours save(Cours cours) {
        return this.coursRepository.save(cours);
    }

    @Override
    public Cours update(Long id,Cours cours) {
        return this.coursRepository.save(cours);
    }

    @Override
    public void delete(Long id) {
        this.coursRepository.deleteById(id);
    }
}