package com.school.workingtimeapi.repository.userrepository;

import com.school.workingtimeapi.entity.user.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}
