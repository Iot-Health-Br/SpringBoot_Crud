package com.igor.Spring_Crud.model;

import org.hibernate.annotations.Where;
import org.hibernate.annotations.DialectOverride.SQLDelete;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

// O Data já gera tudo, construtor e getter and setter
@Data
// O Entity faz a persistencia de dados junto ao banco
@Entity

@org.hibernate.annotations.SQLDelete(sql = "UPDATE Course SET status = 'Inativo' WHERE id = ?")
@Where(clause = "status = 'Ativo'")

public class Course {
    
    // Dá a referencia de id e geração automatica
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //Faz a tranformação dos atributos do json entre o back-end e o front-end
    @JsonProperty("_id")
    private Long id;

    //Vem do Pacote jakarta.validation.constraints
    @NotBlank
    @NotNull
    @Length(min=5,max=100)
    //Tamanho máximo das colunas
    @Column(length = 100, nullable = false )
    private String name;

    @NotNull
    @Length(max=10)
    @Pattern(regexp = "Back-end|Front-end")
    @Column(length = 10, nullable = false )
    private String categoria;

    @NotNull
    @Length(max=10)
    @Pattern(regexp = "Ativo|Inativo")
    @Column(length = 10, nullable = false )
    private String status = "Ativo";

}
