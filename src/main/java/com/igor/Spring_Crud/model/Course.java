package com.igor.Spring_Crud.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

// O Data já gera tudo, construtor e getter and setter
@Data
// O Entity faz a persistencia de dados junto ao banco
@Entity
public class Course {
    
    // Dá a referencia de id e geração automatica
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //Faz a tranformação dos atributos do json entre o back-end e o front-end
    @JsonProperty("_id")
    private Long id;

    @Column(length = 200, nullable = false )
    private String name;

    @Column(length = 20, nullable = false )
    private String categoria;

}
