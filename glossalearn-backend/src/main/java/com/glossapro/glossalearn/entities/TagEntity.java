package com.glossapro.glossalearn.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Set;

@Entity(name = "Tag")
@Table(name = "tags")
public class TagEntity {

    @Id
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
