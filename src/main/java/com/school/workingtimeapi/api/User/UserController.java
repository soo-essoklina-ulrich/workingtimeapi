package com.school.workingtimeapi.api.User;

import com.school.workingtimeapi.entity.user.Enseignant;
import com.school.workingtimeapi.entity.user.Role;
import com.school.workingtimeapi.entity.user.UserDetails;
import com.school.workingtimeapi.service.implementation.userservice.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/all")
    public ResponseEntity<List<UserDetails>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.getAll());
    }
    @GetMapping("/all/role")
    public ResponseEntity<List<UserDetails>> getAllByRole(){
        Role role = Role.ENSEIGNANT;
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.getAllByRole(role));
    }

    @PostMapping("/create")
    public ResponseEntity<UserDetails> create(@RequestBody UserDetails u) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.create(u));
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<UserDetails> update(@PathVariable Long id ,@RequestBody  UserDetails e){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.update(id,e));
    }

}
