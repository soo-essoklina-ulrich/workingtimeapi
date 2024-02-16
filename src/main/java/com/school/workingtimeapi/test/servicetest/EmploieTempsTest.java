package com.school.workingtimeapi.test.servicetest;

import com.school.workingtimeapi.entity.Cours;
import com.school.workingtimeapi.entity.EmploieTemps;
import com.school.workingtimeapi.entity.user.Enseignant;
import com.school.workingtimeapi.service.implementation.EmploieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class EmploieTempsTest implements CommandLineRunner {
    @Autowired
    private EmploieService emploieTempsService;

    private final EmploieTemps emploieTemps = new EmploieTemps(1L, new Enseignant(1L,"nom","prenom",123,"matricule","@gmail","user","password"), new Cours(), new Date(120,01,2,10,00), new Date(120,01,2,11,00), "null");




    public void testcreate() {
        this.emploieTempsService.save(this.emploieTemps);
    }
    public void findAll() {
        this.emploieTempsService.findAll();
    }
    public void update() {
        EmploieTemps New = new EmploieTemps();
        New.setSalle("new");
        this.emploieTempsService.update(1L, New);
    }
    public void delete() {
         this.emploieTempsService.delete(emploieTemps.getId());
    }

    @Override
    public void run(String... args) throws Exception {
         this.testcreate();
         this.findAll();
         this.update();
         this.delete();
    }
}
