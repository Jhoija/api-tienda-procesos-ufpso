package com.ufpso.parcial.apitiendaprocesosufpso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Category {
    @Id
    private Long id;
    private String nombre;
}
