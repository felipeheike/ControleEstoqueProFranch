package com.profranch.controleestoque.repository;

import com.profranch.controleestoque.model.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer> {
    Ingrediente findByNome(String nome);
}
