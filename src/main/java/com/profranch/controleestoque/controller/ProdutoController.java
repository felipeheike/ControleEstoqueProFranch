package com.profranch.controleestoque.controller;

import com.profranch.controleestoque.model.Produto;
import com.profranch.controleestoque.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping("/relatorio")
    public String firstPage() {
        return "Hello World";
    }

    @GetMapping("/produtoDisponivel/{id}")
    public String sco() {
        return "Hello World";
    }


    //Rota para adicionar um produto
    @PostMapping("/addProduto")
    public Produto addProduto(@RequestBody @Valid Produto produto){
        return service.saveProduto(produto);
    }
    //Rota para adicionar vários produtos
    @PostMapping("/addProdutos")
    public List<Produto> addProdutos(@RequestBody List<Produto> produtos){
        return service.saveProdutos(produtos);
    }
    //Rota para listar os produto existentes
    @GetMapping("/produtos")
    public List<Produto> findAllProdutos() {
        return service.getProdutos();
    }

    // Busca especificas (id e nome)
    @GetMapping("/produtoById/{id}")
    public Produto getProdutoById(@PathVariable int id) {
        return service.getProdutoById(id);
    }
    @GetMapping("/produto/{name}")
    public Produto ProdutoByNome(@PathVariable String nome) {
        return service.ProdutoByNome(nome);
    }

    //Intercepta Bad request e informa os campos não preenchidos adequadamente (JSON)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
