package com.school.workingtimeapi.api.User;

import com.school.workingtimeapi.entity.user.Enseignant;
import com.school.workingtimeapi.entity.user.Role;
import com.school.workingtimeapi.entity.user.UserDetails;
import com.school.workingtimeapi.service.implementation.userservice.EnseignantService;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(value = "/enseignant")
@CrossOrigin(origins = "*")
public class EnseigantController {


    private final EnseignantService enseignantService;

    public EnseigantController(EnseignantService enseignantService)
    {
     this.enseignantService = enseignantService;
    }

   /* private static final String ALLOWED_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
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
            Enseignant u = new Enseignant(
                    (long) i,
                    generateRandomString(10),
                    generateRandomString(10),
                    generateRandomNumber(),
                    generateRandomString(10),
                    generateRandomString(10) + "@gmail.com",
                    generateRandomString(10),
                    generateRandomString(10)
            );
            this.enseignantService.save(u);
        }

    }*/


    @GetMapping(value = "/list")
    public ResponseEntity<List<Enseignant>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.enseignantService.findAll());
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Enseignant> save(@RequestBody Enseignant e){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.enseignantService.save(e));
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Enseignant> update(@PathVariable Long id ,@RequestBody Enseignant e){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.enseignantService.update(id,e));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        this.enseignantService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(this.enseignantService.findAll());
    }

}
