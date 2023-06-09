package com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
@Data
@Entity
@Table(name = "role")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Long id;

    @Column(name = "role", unique = true)
    private String role;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "roles")
    private Collection<UserRegisterEntity> users;
}
