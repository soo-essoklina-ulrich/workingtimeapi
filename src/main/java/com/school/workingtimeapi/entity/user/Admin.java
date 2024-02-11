package com.school.workingtimeapi.entity.user;

import jakarta.persistence.Entity;

@Entity
public class Admin extends UserDetails{
    public Admin() {
        super(
                Role.ADMIN
        );
    }

    public Admin(Long id,String nom, String prenom, Integer telephone, String numeromatricule, String email, String username, String password) {
        super(
                id,
                nom,
                prenom,
                telephone,
                numeromatricule,
                email,
                username,
                password,
                Role.ADMIN
        );
    }
}
