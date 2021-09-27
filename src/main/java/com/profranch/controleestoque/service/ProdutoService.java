package com.profranch.controleestoque.service;

import com.profranch.controleestoque.model.Produto;
import com.profranch.controleestoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public Produto saveProduto(Produto produto){
        return repository.save(produto);
    }
    public List<Produto> getProdutos(){
        return repository.findAll();
    }
    public Produto getProdutoById(int id){
        return repository.findById(id).orElse(null);
    }
    public Produto ProdutoByNome(String nome){
        return repository.findByNome(nome);
    }
    public List<Produto> saveProdutos(List<Produto> produtos) {
        return repository.saveAll(produtos);
    }
    public Produto updateProduto(Produto produto){
        Produto existingProduto =  repository.findById(produto.getId()).orElse(null);
        existingProduto.setNome(produto.getNome());
        existingProduto.setPreco(produto.getPreco());
        return repository.save(existingProduto);
    }
}
