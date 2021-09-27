package com.profranch.controleestoque.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Componente {
    //Essa classe é responsável por associar a quantidade da receita ao ingrediente que será utilizado
    @Id
    private int id;
    private int quantidade;
    @OneToOne(targetEntity = Ingrediente.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "ci_fk", referencedColumnName = "id")
    private Ingrediente ingrediente;

}
