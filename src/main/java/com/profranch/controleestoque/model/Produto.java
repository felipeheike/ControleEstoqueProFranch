package com.profranch.controleestoque.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PRODUTO_TB")
public class Produto {
    @Id
    @GeneratedValue
    int id;
    @NotBlank(message = "Campo não informado.")
    private String nome;
    //inicialmente uma string, quando terminar os requisitos básicos, alterar para "MultipartFile". Fazer as validações no método do controller relacionado ao endpoint.
    private String imagem;
    @NotNull(message = "Campo não informado")
    private Double preco;

    //A intenção é criar uma lista com os componentes, já que o componente possui a o igrediente e sua respectiva quantidade
    @OneToMany(targetEntity = Componente.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "pc_fk", referencedColumnName = "id")
    List<Componente> componentes;

}

//Getters e Setters automatizados com uso do lombok