package com.lfrank.revendas.infra.entitys;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name",nullable = false, unique = true)
    private String name;

    @Column(name = "brand",nullable = false)
    private String brand;

    @Column(name = "type",nullable = false)
    private String type;

    @Column(name = "price",nullable = false)
    private Double price;

    @Column(name = "quantity",nullable = false)
    private Integer quantity;


}
