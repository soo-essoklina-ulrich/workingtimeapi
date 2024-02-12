package com.school.workingtimeapi.api;

import com.school.workingtimeapi.entity.Cours;
import com.school.workingtimeapi.service.implementation.CoursService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/cours")
public class CoursController {

    private final CoursService coursService;

    public CoursController(CoursService coursService) {
        this.coursService = coursService;
    }

    @GetMapping(value = "/list")
    public ResponseEntity<?> getAllCours() {
        return ResponseEntity.status(HttpStatus.OK).body(this.coursService.findAll());
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Cours> addCours(@RequestBody Cours cours) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.coursService.save(cours));
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Cours> updateCours(@PathVariable Long id ,@RequestBody Cours cours) {
        return ResponseEntity.status(HttpStatus.OK).body(this.coursService.update(id, cours));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteCours(@PathVariable Long id) {
        this.coursService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Cours deleted successfully");
    }
}
