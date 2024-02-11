package com.school.workingtimeapi.service.implementation.userservice;

import com.school.workingtimeapi.entity.user.Etudiant;
import com.school.workingtimeapi.entity.user.Role;
import com.school.workingtimeapi.repository.userrepository.EtudiantRepository;
import com.school.workingtimeapi.service.interfaceservice.userinter.EtudiantInter;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EtudiantService implements EtudiantInter {

    private final EtudiantRepository etudiantRepository;

    public EtudiantService(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @Override
    public List<Etudiant> findAll() {
        return this.etudiantRepository.findAll();
    }

    @Override
    public Etudiant save(Etudiant e) {
        e.setRole(Role.ETUDIANT);
        return this.etudiantRepository.save(e);
    }

    @Override
    public Etudiant update(Long id, Etudiant etudiantupdate) {
        Etudiant etudiantexisting = this.etudiantRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Etudiant not found with id: " + id));
        BeanUtils.copyProperties(etudiantupdate, etudiantexisting, "id");
        return this.etudiantRepository.save(etudiantexisting);
    }

    @Override
    public void delete(Long id) {

    }
}
