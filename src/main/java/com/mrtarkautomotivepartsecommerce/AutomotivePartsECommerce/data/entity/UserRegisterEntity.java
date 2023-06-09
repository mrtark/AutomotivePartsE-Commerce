package com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Data
@Entity
@Table(name = "users")
public class UserRegisterEntity extends BaseEntity{
    public static final long serialVersionUID = 1L;
    @Column(name = "users_name")
    private String name;
    @Column(name = "users_lastname")
    private String lastname;
    @Column(name = "users_mail") // unique = true
    private  String email;
    @Column(name = "users_password")
    @JsonIgnore
    private String password;
    @Column(name = "users_active",nullable = false)
    private String active;
}
