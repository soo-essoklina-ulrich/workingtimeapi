package com.school.workingtimeapi.entity.user;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Entity
public class Etudiant extends UserDetails{

    public Etudiant() {
        super(
                Role.ETUDIANT
        );
    }

    public Etudiant(Long id, String nom, String prenom, Integer telephone, String numeromatricule, String email, String username, String password) {
        super(
                id,
                nom,
                prenom,
                telephone,
                numeromatricule,
                email,
                username,
                password,
                Role.ETUDIANT
        );
    }


    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public String getNom() {
        return super.getNom();
    }

    @Override
    public String getPrenom() {
        return super.getPrenom();
    }

    @Override
    public Integer getTelephone() {
        return super.getTelephone();
    }

    @Override
    public String getNumeromatricule() {
        return super.getNumeromatricule();
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public Role getRole() {
        return super.getRole();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    @Override
    public void setNom(String nom) {
        super.setNom(nom);
    }

    @Override
    public void setPrenom(String prenom) {
        super.setPrenom(prenom);
    }

    @Override
    public void setTelephone(Integer telephone) {
        super.setTelephone(telephone);
    }

    @Override
    public void setNumeromatricule(String numeromatricule) {
        super.setNumeromatricule(numeromatricule);
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public void setUsername(String username) {
        super.setUsername(username);
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Override
    public void setRole(Role role) {
        super.setRole(role);
    }
}
