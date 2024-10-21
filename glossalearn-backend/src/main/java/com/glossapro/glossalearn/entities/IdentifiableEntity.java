package com.glossapro.glossalearn.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.util.UUID;
@MappedSuperclass
public abstract class IdentifiableEntity {

    @Id
    private UUID id;

    IdentifiableEntity() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}
