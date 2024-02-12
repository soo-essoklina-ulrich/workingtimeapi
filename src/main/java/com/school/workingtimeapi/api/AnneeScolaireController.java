package com.school.workingtimeapi.api;

import com.school.workingtimeapi.entity.AnneeScolaire;
import com.school.workingtimeapi.service.implementation.AnneScolaireService;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.*;

@RestController
@RequestMapping(value = "/anneeScolaire")
@CrossOrigin(origins = "*")
public class AnneeScolaireController {
    private final AnneScolaireService anneeScolaireService;

    public AnneeScolaireController(AnneScolaireService anneeScolaireService){
        this.anneeScolaireService = anneeScolaireService;
    }


/*    @PostConstruct
    public void init(){
        for (int i = 0; i < 10; i++) {
            AnneeScolaire anneeScolaire = new AnneeScolaire();
            anneeScolaire.setCode("a"+i);
            anneeScolaire.setDateDebut(new Date(2024, Calendar.JANUARY,1));
            anneeScolaire.setDateFin(new Date(2024,Calendar.FEBRUARY,1));
            this.anneeScolaireService.save(anneeScolaire);
        }
    }*/

    @GetMapping(value = "/list")
    public ResponseEntity<List<AnneeScolaire>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.anneeScolaireService.findAll());
    }

    @PostMapping(value = "/create")
    public ResponseEntity<AnneeScolaire> create(@RequestBody AnneeScolaire anneeScolaire){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.anneeScolaireService.save(anneeScolaire));
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<AnneeScolaire> update(@PathVariable Long id, @RequestBody AnneeScolaire anneeScolaire){
        return ResponseEntity.status(HttpStatus.OK).body(this.anneeScolaireService.update(id, anneeScolaire));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.anneeScolaireService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}
