package com.school.workingtimeapi.api.User;

import com.school.workingtimeapi.entity.user.Enseignant;
import com.school.workingtimeapi.service.implementation.userservice.EnseignantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class EnseigantControllerTest {
    @Mock
    private EnseignantService enseignantService;

    @InjectMocks
    private EnseigantController enseigantController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFindAllEnseignantContoller() {
        // Given
        Enseignant enseignant1 = new Enseignant();
        Enseignant enseignant2 = new Enseignant();
        List<Enseignant> enseignants = Arrays.asList(enseignant1, enseignant2);
        when(enseignantService.findAll()).thenReturn(enseignants);

        // When
        ResponseEntity<List<Enseignant>> response = enseigantController.findAll();

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(enseignants, response.getBody());
    }

}