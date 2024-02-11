package com.school.workingtimeapi.repository;

import com.school.workingtimeapi.entity.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatiereRepository extends JpaRepository<Matiere, Long> {
    Matiere findByCode(String code);
    Matiere findByIntitule(String intitule);
    Matiere findByIntituleAndCode(String intitule, String code);
}
