package com.profranch.controleestoque.repository;

import com.profranch.controleestoque.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    Produto findByNome(String nome);
}


