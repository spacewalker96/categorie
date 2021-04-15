package com.basma.categorie.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "category_table")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "category_name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category(Long id, String name) {

        this.id = id;
        this.name = name;
    }

    public Category() {
    }
}
