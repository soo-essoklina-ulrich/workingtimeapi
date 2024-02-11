package com.school.workingtimeapi.repository;

import com.school.workingtimeapi.entity.EmploieTemps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmploieTempsRepository extends JpaRepository<EmploieTemps, Long> {
}
