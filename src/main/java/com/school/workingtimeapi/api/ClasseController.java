package com.school.workingtimeapi.api;

import com.school.workingtimeapi.entity.Classe;
import com.school.workingtimeapi.service.implementation.ClasseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(value = "/classe")
@CrossOrigin(origins = "*")
public class ClasseController {

    private final ClasseService classeService;

    public ClasseController(ClasseService classeService){
        this.classeService = classeService;
    }

/*    @PostConstruct
    public void init(){
        for (int i = 0; i < 10; i++) {
            Classe c = new Classe();
            c.setCode("c"+i);
            c.setIntitule("classe"+i);
            this.classeService.save(c);
        }
    }*/

    @GetMapping(value = "/list")
    public ResponseEntity<List<Classe>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.classeService.findAll());
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Classe> save(@RequestBody Classe c){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.classeService.save(c));
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Classe> update(@PathVariable Long id,@RequestBody Classe c) throws SQLException {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.classeService.update(id, c));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        this.classeService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(this.classeService.findAll());
    }
}
