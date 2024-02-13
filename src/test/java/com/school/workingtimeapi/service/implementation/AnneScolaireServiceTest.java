package com.school.workingtimeapi.service.implementation;

import com.school.workingtimeapi.entity.AnneeScolaire;
import com.school.workingtimeapi.repository.AnneeScolaireRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AnneScolaireServiceTest {
    @Mock
    private AnneeScolaireRepository anneeScolaireRepository;

    @InjectMocks
    private AnneScolaireService anneScolaireService;


    @Test
    void findAll() {
        List<AnneeScolaire> anneeScolaires = new ArrayList<>();
        anneeScolaires.add(new AnneeScolaire(1L, "2020-2021", new Date(124,04,01), new Date(124,04,01)));
        anneeScolaires.add(new AnneeScolaire(2L, "2020-2021", new Date(125,04,01),new Date(125,04,01)));

        when(anneeScolaireRepository.findAll()).thenReturn(anneeScolaires);

        List<AnneeScolaire> resultat = anneScolaireService.findAll();

        assertEquals(2, resultat.size());
    }

    @Test
    void saveTestRetunAnScolaire() {
        AnneeScolaire anneeScolaire = new AnneeScolaire(1L, "2020-2021", new Date(124,04,01), new Date(124,04,01));

        when(anneeScolaireRepository.save(anneeScolaire)).thenReturn(anneeScolaire);

        AnneeScolaire resultat = anneScolaireService.save(anneeScolaire);

        assertEquals(anneeScolaire, resultat);
    }

    @Test
    void updateTestReturnAnScolaireToUpdate() {
        Long id = 1L;
        AnneeScolaire anneeScolaireToUpdate = new AnneeScolaire(1L, "anne2", new Date(125,04,01), new Date(124,04,01));
        AnneeScolaire anneeScolaireToExiste = new AnneeScolaire(1L, "anne1", new Date(124,04,01), new Date(125,04,01));

        when(anneeScolaireRepository.findById(id)).thenReturn(Optional.of(anneeScolaireToExiste));
        when(anneeScolaireRepository.save(anneeScolaireToExiste)).thenReturn(anneeScolaireToExiste);

        AnneeScolaire resultat = anneScolaireService.update(id, anneeScolaireToUpdate);

        assertEquals(anneeScolaireToUpdate.getCode(), resultat.getCode());
    }

    @Test
    void testUpdate_ThrowsExceptionWhenAnScNotFound() {
        Long id = 1L;
        AnneeScolaire anneeScolaireToUpdate = new AnneeScolaire(1L, "2020-2022", new Date(125,04,01), new Date(125,04,01));

        when(anneeScolaireRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> anneScolaireService.update(id, anneeScolaireToUpdate));}

    @Test
    void deleteTestAnneScolaireEaraseObject() {
        Long id = 1L;

        anneScolaireService.delete(id);

        verify(anneeScolaireRepository, times(1)).deleteById(id);
    }
}