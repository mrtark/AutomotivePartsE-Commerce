package com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.data.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "products")
public class ProductEntity extends BaseEntity{
    public static final long serialVersionUID = 1L;
    @Column(name = "part_id")
    private Long partID;
    @Column(name = "part_name")
    private String partName;
    @Column(name = "part_description")
    private String description;
    @Column(name = "part_price")
    private Long partPrice;
    @Column(name = "part_image")
    private String partImage;

}
