package com.school.workingtimeapi.api;

import com.school.workingtimeapi.entity.EmploieTemps;
import com.school.workingtimeapi.service.implementation.EmploieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/emplois")
public class EmploisController {

    private final EmploieService emploieService;

    public EmploisController(EmploieService emploieService) {
        this.emploieService = emploieService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<?> getAllEmplois() {
        return ResponseEntity.status(HttpStatus.OK).body(this.emploieService.findAll());
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addEmplois(@RequestBody EmploieTemps emplois) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.emploieService.save(emplois));
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> updateEmplois(@PathVariable Long id ,@RequestBody EmploieTemps emplois) {
        return ResponseEntity.status(HttpStatus.OK).body(this.emploieService.update(id, emplois));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteEmplois(@PathVariable Long id) {
        this.emploieService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Emplois deleted successfully");
    }
}
