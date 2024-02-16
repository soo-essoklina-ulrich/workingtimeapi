package com.school.workingtimeapi.service.implementation;

import com.school.workingtimeapi.entity.Matiere;
import com.school.workingtimeapi.repository.MatiereRepository;
import com.school.workingtimeapi.service.interfaceservice.MatiereInter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
@Service
public class MatiereService implements MatiereInter {

    private final MatiereRepository matiereRepository;

    public MatiereService(MatiereRepository matiereRepository) {
        this.matiereRepository = matiereRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Matiere> findAll() {
        return this.matiereRepository.findAll();
    }

    @Override
    public Matiere save(Matiere m) {
        return this.matiereRepository.save(m);
    }

    @Override
    public Matiere update(Long id, Matiere m) throws SQLException {
        Matiere matiereExesting = this.matiereRepository.findById(id).orElseThrow(() -> new SQLException("Matiere not found with id : " + id));
        BeanUtils.copyProperties(matiereExesting, m, "id");
        return this.matiereRepository.save(matiereExesting);
    }

    @Override
    public void delete(Long id) {
        this.matiereRepository.deleteById(id);
    }

    @Override
    public Matiere findByCode(String code) {
        return this.matiereRepository.findByCode(code);
    }

    @Override
    public Matiere findByIntitule(String intitule) {
        return this.matiereRepository.findByIntitule(intitule);
    }

    @Override
    public Matiere findByIntituleAndCode(String code, String intitule) {
        return this.matiereRepository.findByIntituleAndCode(intitule, code);
    }
}
