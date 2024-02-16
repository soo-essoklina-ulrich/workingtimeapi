package com.school.workingtimeapi.api.User;

import com.school.workingtimeapi.entity.user.Admin;
import com.school.workingtimeapi.service.implementation.userservice.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(value = "/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
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
        for (int i = 0; i <= 10; i++) {
            Admin u = new Admin(
                    (long) i,
                    generateRandomString(10),
                    generateRandomString(10),
                    generateRandomNumber(),
                    generateRandomString(10),
                    generateRandomString(10) + "@gmail.com",
                    generateRandomString(10),
                    generateRandomString(10)
            );
            this.adminService.save(u);
        }

    }*/

    @GetMapping("/list")
    public ResponseEntity<List<Admin>> getAllAdmins() {
        return ResponseEntity.ok(this.adminService.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addAdmin(@RequestBody Admin admin) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.adminService.save(admin));
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Admin> update(@PathVariable Long id , @RequestBody Admin e) throws SQLException {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.adminService.update(id,e));
    }


}
