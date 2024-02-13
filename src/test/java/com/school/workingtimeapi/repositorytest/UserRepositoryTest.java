package com.school.workingtimeapi.repositorytest;

import com.school.workingtimeapi.entity.user.Etudiant;
import com.school.workingtimeapi.entity.user.UserDetails;
import com.school.workingtimeapi.repository.userrepository.EtudiantRepository;
import com.school.workingtimeapi.repository.userrepository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void EtudiantRepository_SallAll_ReturnsSavedEtudiants() {
        //Arrange
        UserDetails userDetails = UserDetails.builder()
                .nom("Soo")
                .prenom("Ulrich")
                .telephone(123456789)
                .numeromatricule("123456SUl04")
                .email("sooulrich870@gmail.com").build();

        //Act
        UserDetails saveuser =userRepository.save(userDetails);

        //Assert

        Assertions.assertEquals(userDetails, saveuser);
    }

}
