package com.school.workingtimeapi.service.implementation;

import com.school.workingtimeapi.entity.Classe;
import com.school.workingtimeapi.repository.ClasseRepository;
import com.school.workingtimeapi.service.interfaceservice.ClasseInter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ClasseService implements ClasseInter {

    private ClasseRepository classeRepository;

    public ClasseService(ClasseRepository classeRepository) {
        this.classeRepository = classeRepository;
    }


    @Override
    public List<Classe> findAll() {
        return this.classeRepository.findAll();
    }

    @Override
    public Classe save(Classe classe) {
        return this.classeRepository.save(classe);
    }

    @Override
    public Classe update(Long id, Classe classe) throws SQLException {
        Classe classeExisting = this.classeRepository.findById(id).orElseThrow(() -> new SQLException("Classe not found with id: " + id));
        BeanUtils.copyProperties(classe, classeExisting, "id");
        return this.classeRepository.save(classeExisting);
    }

    @Override
    public void delete(Long id) {
        this.classeRepository.deleteById(id);
    }

}
