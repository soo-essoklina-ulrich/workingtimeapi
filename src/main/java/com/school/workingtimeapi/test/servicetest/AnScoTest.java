package com.school.workingtimeapi.test.servicetest;

import com.school.workingtimeapi.entity.AnneeScolaire;
import com.school.workingtimeapi.service.implementation.AnneScolaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Date;

@Component
public class AnScoTest implements CommandLineRunner {
    @Autowired
    private AnneScolaireService anneScolaireService;

    private final AnneeScolaire anneeScolaire = new AnneeScolaire(1L, "2019-2020", new Date(), new Date());

    @Override
    public void run(String... args) throws Exception {
//        this.testcreate();
//        this.findAll();
//        this.update();
//        this.delete();
    }
    public void testcreate() {

        this.anneScolaireService.save(this.anneeScolaire);
    }

    public void findAll() {
        this.anneScolaireService.findAll();
    }

    public void update() throws SQLException {
        AnneeScolaire New = new AnneeScolaire();
        New.setCode("new");
        New.setDateDebut(new Date());
        this.anneScolaireService.update(1L, New);
    }

    public void delete() {
        this.anneScolaireService.delete(anneeScolaire.getId());
    }

}


