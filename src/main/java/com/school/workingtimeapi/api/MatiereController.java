package com.school.workingtimeapi.api;

import com.school.workingtimeapi.entity.Matiere;
import com.school.workingtimeapi.service.implementation.MatiereService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(value = "matiere")
@CrossOrigin(origins = "*")
public class MatiereController {
    private final MatiereService matiereService;

    public MatiereController(MatiereService matiereService) {
        this.matiereService = matiereService;
    }

/*    @PostConstruct
    public void init(){
       for (int i = 0; i < 10; i++) {
           Matiere m = new Matiere();
           m.setCode("m"+i);
           m.setIntitule("matiere"+i);
           this.matiereService.save(m);
       }
    }*/


    @PostMapping(value = "/add")
    public ResponseEntity<Matiere> save(@RequestBody Matiere m){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.matiereService.save(m));
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<Matiere>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body( this.matiereService.findAll());
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Matiere> update(@PathVariable Long id, @RequestBody Matiere m) throws SQLException {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.matiereService.update(id, m));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        this.matiereService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(this.matiereService.findAll());
    }

    @GetMapping(value = "/getByCode/")
    public ResponseEntity<Matiere> getByCode(@PathParam("code") String code){
        return ResponseEntity.status(HttpStatus.OK).body(this.matiereService.findByCode(code));
    }

    @GetMapping(value = "/getByIntitule")
    public ResponseEntity<Matiere> getByIntitule(@PathParam("intitule") String intitule){
        return ResponseEntity.status(HttpStatus.OK).body(this.matiereService.findByIntitule(intitule));
    }

    @GetMapping(value = "/getByIntituleAndCode/")
    public ResponseEntity<Matiere> getByIntituleAndCode(@PathParam("code") String code, @PathParam("intitule") String intitule){
        return ResponseEntity.status(HttpStatus.OK).body(this.matiereService.findByIntituleAndCode(code, intitule));
    }
}
