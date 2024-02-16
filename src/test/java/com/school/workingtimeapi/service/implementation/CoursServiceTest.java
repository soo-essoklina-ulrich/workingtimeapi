package com.school.workingtimeapi.service.implementation;

import com.school.workingtimeapi.entity.AnneeScolaire;
import com.school.workingtimeapi.entity.Classe;
import com.school.workingtimeapi.entity.Cours;
import com.school.workingtimeapi.entity.Matiere;
import com.school.workingtimeapi.entity.user.Enseignant;
import com.school.workingtimeapi.repository.CoursRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CoursServiceTest {

    @Mock
    private CoursRepository coursRepository;

    @InjectMocks
    private CoursService coursService;



    @Test
    void TestfindAllRetunrListOfCours() {
        List<Cours> cours = new ArrayList<>();
        cours.add(new Cours(1L,new Matiere(), new Enseignant(), new Classe(), new AnneeScolaire()));
        cours.add(new Cours(2L,new Matiere(), new Enseignant(), new Classe(), new AnneeScolaire()));

        when(coursRepository.findAll()).thenReturn(cours);
        List<Cours> result = coursService.findAll();

        assertEquals(2, result.size());
    }

    @Test
    void TestsaveReturnCours() {
        Cours coursToSave = new Cours(1L,new Matiere(), new Enseignant(), new Classe(), new AnneeScolaire());
        when(coursRepository.save(coursToSave)).thenReturn(coursToSave);
        Cours result = coursService.save(coursToSave);
        assertEquals(coursToSave, result);
    }

    @Test
    void TestupdateReturnCoursUpdate() throws SQLException {
        Long id = 1L;
        Matiere matiere = new Matiere(1L, "Math", "Mathematique");
        Enseignant enseignant = new Enseignant(1L, "Moussa", "Moussa", 1234567890, "Tt","j", "","");
        Classe classe = new Classe(1L, "ClasseA", "A");
        AnneeScolaire anneeScolaire = new AnneeScolaire(1L, "2020-2021", new Date(100), new Date(200));

        Cours coursToUpdate = new Cours(1L, matiere, enseignant, classe, anneeScolaire);
        Cours coursExiste = new Cours(1L, matiere, enseignant, classe, anneeScolaire);
        when(coursRepository.findById(id)).thenReturn(java.util.Optional.of(coursExiste));
        when(coursRepository.save(coursExiste)).thenReturn(coursExiste);
        Cours result = coursService.update(id, coursToUpdate);
        assertEquals(coursToUpdate, result);

    }



    @Test
    void delete() {
        Long id = 1L;

        coursService.delete(id);

        verify(coursRepository, times(1)).deleteById(id);
    }
}