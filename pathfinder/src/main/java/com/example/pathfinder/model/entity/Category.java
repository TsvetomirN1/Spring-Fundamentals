package com.example.pathfinder.model.entity;


import com.example.pathfinder.model.enums.CategoryEnum;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    private CategoryEnum name;
    private String description;


    public Category() {
    }

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    public CategoryEnum getName() {
        return name;
    }

    public void setName(CategoryEnum name) {
        this.name = name;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
