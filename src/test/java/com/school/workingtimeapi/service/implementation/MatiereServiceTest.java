package com.school.workingtimeapi.service.implementation;

import com.school.workingtimeapi.entity.Matiere;
import com.school.workingtimeapi.repository.MatiereRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MatiereServiceTest {

    @Mock
    private MatiereRepository matiereRepository;

    @InjectMocks
    private MatiereService matiereService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    void findAllReturnMatiereList() {

        List<Matiere> matieres = new ArrayList<>();
        matieres.add(new Matiere(1L, "Math", "MTH"));
        matieres.add(new Matiere(2L, "Physique", "PHY"));

        when(matiereRepository.findAll()).thenReturn(matieres);

        List<Matiere> result = matiereService.findAll();

        assertEquals(2, result.size());
    }

    @Test
    void saveReturnMatiere() {
        Matiere matiereToSave = new Matiere(1L, "Math", "MTH");

        when(matiereRepository.save(matiereToSave)).thenReturn(matiereToSave);

        Matiere result = matiereService.save(matiereToSave);

        assertEquals(matiereToSave.getCode(), result.getCode());
    }

    @Test
    void updateTestMatiereReturnUpdatefoMatierewhoexiste() {
        Long id = 1L;
        Matiere matiereToUpdate = new Matiere(1L, "Mathnew", "MTHNEW");
        Matiere matiereToExiste = new Matiere(1L, "Math", "MTH");

        when(matiereRepository.findById(id)).thenReturn(java.util.Optional.of(matiereToExiste));
        when(matiereRepository.save(matiereToExiste)).thenReturn(matiereToExiste);

        Matiere result = matiereService.update(id, matiereToUpdate);

        assertEquals(matiereToUpdate, result);
    }

    @Test
    void testUpdateMatiereReturnException() {
        Long id = 1L;
        Matiere matiereToUpdate = new Matiere(1L, "Mathnew", "MTHNEW");
        Matiere matiereToExiste = new Matiere(2L, "Math", "MTH");

        when(matiereRepository.findById(id)).thenReturn(java.util.Optional.of(matiereToExiste));

        assertThrows(RuntimeException.class, () -> matiereService.update(id, matiereToUpdate));
    }

    @Test
    void deleteTest() {
        Long id = 1L;

        matiereService.delete(id);

        verify(matiereRepository, times(1)).deleteById(id);
    }

    @Test
    void testFindByCode() {
        // Given
        String code = "MAT001";
        Matiere matiere = new Matiere();
        when(matiereRepository.findByCode(code)).thenReturn(matiere);

        // When
        Matiere result = matiereService.findByCode(code);

        // Then
        assertEquals(matiere, result);
    }

    @Test
    void testFindByIntitule() {
        // Given
        String intitule = "Mathématiques";
        Matiere matiere = new Matiere();
        when(matiereRepository.findByIntitule(intitule)).thenReturn(matiere);

        // When
        Matiere result = matiereService.findByIntitule(intitule);

        // Then
        assertEquals(matiere, result);
    }

    @Test
    void testFindByIntituleAndCode() {
        // Given
        String code = "MAT001";
        String intitule = "Mathématiques";
        Matiere matiere = new Matiere();
        when(matiereRepository.findByIntituleAndCode(intitule, code)).thenReturn(matiere);

        // When
        Matiere result = matiereService.findByIntituleAndCode(code, intitule);

        // Then
        assertEquals(matiere, result);
    }
}