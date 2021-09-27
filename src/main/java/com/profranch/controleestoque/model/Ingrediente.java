package com.profranch.controleestoque.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="INGREDIENTE_TB")
public class Ingrediente {
    @Id
    @GeneratedValue
    private int id;
    @NotBlank(message = "Campo não informado")
    private String nome;
    @NotBlank(message = "Campo não informado")
    private String unidadeDeMedida;
    @NotNull(message = "Campo não informado")
    private Double preco;
}

//Getters e Setters automatizados com uso do lombok