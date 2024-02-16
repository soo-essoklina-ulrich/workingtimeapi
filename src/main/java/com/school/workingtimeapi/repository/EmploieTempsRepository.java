package com.school.workingtimeapi.repository;

import com.school.workingtimeapi.entity.EmploieTemps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmploieTempsRepository extends JpaRepository<EmploieTemps, Long> {

    @Query(value = "SELECT * FROM Emploie_Temps order by id DESC limit 1", nativeQuery = true)
    EmploieTemps lastItem();
}
