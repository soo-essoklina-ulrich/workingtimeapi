package com.school.workingtimeapi.entity.user;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Builder
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String prenom;

    private Integer telephone;

    private String numeromatricule;

    private String email;

    private String username;

    private String password;

    private Role role;


    public UserDetails(Role role) {
    }
}
