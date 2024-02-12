package com.school.workingtimeapi.test.servicetest;

import com.school.workingtimeapi.entity.AnneeScolaire;
import com.school.workingtimeapi.service.implementation.AnneScolaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

//@Component
public class AnScoTest implements CommandLineRunner {
   /* @Autowired
    private AnneScolaireService anneScolaireService;

    private final AnneeScolaire anneeScolaire = new AnneeScolaire(1L, "2019-2020", new Date(), new Date());
    */

    @Override
    public void run(String... args) throws Exception {
        //this.testcreate();
    }
/*
    public void testcreate() {
        AnneeScolaire anneeScolaire = new AnneeScolaire();
        anneeScolaire.setDateDebut(new Date());
        anneeScolaire.setDateFin(new Date());
        anneeScolaire.setCode("2019-2020");
        this.anneScolaireService.save(anneeScolaire);
    }

    public void findAll() {
        this.anneScolaireService.findAll();
    }

    public void update() {
        this.anneScolaireService.update(1L, anneeScolaire);
    }

    public void delete() {
        this.anneScolaireService.delete(anneeScolaire.getId());
    }*/

}


