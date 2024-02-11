package com.school.workingtimeapi.api.User;

import com.school.workingtimeapi.entity.user.Enseignant;
import com.school.workingtimeapi.entity.user.Etudiant;
import com.school.workingtimeapi.entity.user.Role;
import com.school.workingtimeapi.entity.user.UserDetails;
import com.school.workingtimeapi.service.implementation.userservice.EtudiantService;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(value = "/etudiant")
@CrossOrigin(origins = "*")
public class EtudiantController {

    private final EtudiantService etudiantService;

    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    /*private static final String ALLOWED_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    public String generateRandomString(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("La longueur doit être supérieure à zéro.");
        }

        StringBuilder randomString = new StringBuilder(length);
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(ALLOWED_CHARACTERS.length());
            char randomChar = ALLOWED_CHARACTERS.charAt(randomIndex);
            randomString.append(randomChar);
        }

        return randomString.toString();
    }
    public static int generateRandomNumber() {
        int min = 90000; // Minimum value of range
        int max = 99999999; // Maximum value of range

        return (int)Math.floor(Math.random() * (max - min + 1) + min);
    }

    @PostConstruct
    public void init() {
        Role[] roles = Role.values();

        for (int i = 0; i <= 10; i++) {
            Etudiant u = new Etudiant(
                    (long) i,
                    generateRandomString(10),
                    generateRandomString(10),
                    generateRandomNumber(),
                    generateRandomString(10),
                    generateRandomString(10) + "@gmail.com",
                    generateRandomString(10),
                    generateRandomString(10)
            );
            this.etudiantService.save(u);
        }

    }*/


    @GetMapping(value = "/list")
    public ResponseEntity<List<Etudiant>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(this.etudiantService.findAll());
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Etudiant> add(@RequestBody Etudiant etudiant) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.etudiantService.save(etudiant));
    }
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Etudiant> update(@PathVariable Long id ,@RequestBody Etudiant e){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.etudiantService.update(id,e));
    }

}
