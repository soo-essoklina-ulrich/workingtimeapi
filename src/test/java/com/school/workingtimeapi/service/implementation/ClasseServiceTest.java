package com.school.workingtimeapi.service.implementation;

import com.school.workingtimeapi.entity.Classe;
import com.school.workingtimeapi.repository.ClasseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClasseServiceTest {

    @Mock
    private ClasseRepository classeRepository;

    @InjectMocks
    private ClasseService classeService;

    @Test
    public void testFindAllReturnListOfClasse() {
        // Création de données de test
        List<Classe> classes = new ArrayList<>();
        classes.add(new Classe(1L, "ClasseA", "A"));
        classes.add(new Classe(2L, "ClasseB", "B"));

        // Configuration du comportement du repository simulé (mock)
        when(classeRepository.findAll()).thenReturn(classes);

        // Appel de la méthode à tester
        List<Classe> result = classeService.findAll();

        // Vérification des résultats
        assertEquals(2, result.size());
    }

    @Test
    public void testSaveReturnClasse() {
        // Création de données de test
        Classe classeToSave = new Classe(1L, "Classe A", "A");

        // Configuration du comportement du repository simulé (mock)
        when(classeRepository.save(classeToSave)).thenReturn(classeToSave);

        // Appel de la méthode à tester
        Classe result = classeService.save(classeToSave);

        // Vérification des résultats
        assertEquals(classeToSave, result);
    }

    @Test
    public void testUpdate() throws SQLException {
        // Création de données de test
        Long id = 1L;
        Classe classeToUpdate = new Classe(1L, "Classe A", "A");
        Classe classeExisting = new Classe(1L, "Classe B".toLowerCase(), "B");

        // Configuration du comportement du repository simulé (mock)
        when(classeRepository.findById(id)).thenReturn(Optional.of(classeExisting));
        when(classeRepository.save(classeExisting)).thenReturn(classeExisting);

        // Appel de la méthode à tester
        Classe result = classeService.update(id, classeToUpdate);

        // Vérification des résultats
        assertEquals(classeToUpdate.getCode(), result.getCode());
    }

    @Test
    public void testUpdate_ThrowsExceptionWhenClasseNotFound() {
        // Création de données de test
        Long id = 1L;
        Classe classeToUpdate = new Classe(1L, "Classe A", "A");

        // Configuration du comportement du repository simulé (mock)
        when(classeRepository.findById(id)).thenReturn(Optional.empty());

        // Vérification que la méthode lance bien une exception lorsque la classe n'est pas trouvée
        assertThrows(SQLException.class, () -> {
            classeService.update(id, classeToUpdate);
        });
    }

    @Test
    public void testDelete() {
        // Création de données de test
        Long id = 1L;

        // Appel de la méthode à tester
        classeService.delete(id);

        // Vérification que la méthode deleteById du repository est appelée une fois avec l'ID spécifié
        verify(classeRepository, times(1)).deleteById(id);
    }
}
