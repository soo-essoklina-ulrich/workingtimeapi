package com.school.workingtimeapi.service.implementation;

import com.school.workingtimeapi.entity.EmploieTemps;
import com.school.workingtimeapi.repository.EmploieTempsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmploieServiceTest {
    @Mock
    private EmploieTempsRepository emploieTempsRepository;

    @InjectMocks
    private EmploieService emploieService;

    @Test
    void testFindAll() {
        // Création d'une liste d'emplois fictive
        List<EmploieTemps> emploieTempsList = new ArrayList<>();
        emploieTempsList.add(new EmploieTemps());
        emploieTempsList.add(new EmploieTemps());

        // Définition du comportement attendu lors de l'appel à findAll() du repository
        when(emploieTempsRepository.findAll()).thenReturn(emploieTempsList);

        // Appel de la méthode findAll() du service
        List<EmploieTemps> result = emploieService.findAll();

        // Vérification que la liste retournée par le service est la même que celle attendue
        assertEquals(emploieTempsList.size(), result.size());
    }

    @Test
    void testSave() {
        // Création d'un emploi fictif

        EmploieTemps emploieTempsprevious = new EmploieTemps(1L,null,null,new Date(120,02,01,10,00),new Date(120,02,01,12,00),"");
        EmploieTemps emploieTempsnew = new EmploieTemps(2L,null,null,new Date(120,02,01,13,00),new Date(121,02,01),"");

        // Définition du comportement attendu lors de l'appel à save() du repository
        lenient().when(emploieTempsRepository.save(emploieTempsprevious)).thenReturn(emploieTempsprevious);

        // Définition du comportement attendu lors de l'appel à lastItem() du repository
        lenient().when(emploieTempsRepository.lastItem()).thenReturn(emploieTempsprevious);

        // Définition du comportement attendu lors de l'appel à save() du repository
        when(emploieTempsRepository.save(emploieTempsnew)).thenReturn(emploieTempsnew);

        // Appel de la méthode save() du service
        EmploieTemps result = emploieService.save(emploieTempsnew);

        // Vérification que l'emploi retourné par le service est le même que celui attendu
        assertEquals(emploieTempsnew, result);
    }

    @Test
    void update() {
    }

    @Test
    void deleteTest() {
        Long id = 1L;

        emploieService.delete(id);

        verify(emploieTempsRepository, times(1)).deleteById(id);
    }
}