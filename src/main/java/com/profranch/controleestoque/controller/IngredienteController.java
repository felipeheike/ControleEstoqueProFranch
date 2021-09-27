package com.profranch.controleestoque.controller;

import com.profranch.controleestoque.model.Ingrediente;
import com.profranch.controleestoque.service.IngredienteService;
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
public class IngredienteController {

    @Autowired
    private IngredienteService service;

    //Rota para adicionar um produto
    @PostMapping("/addIgrediente")
    public Ingrediente addIngrediente(@RequestBody @Valid Ingrediente ingrediente){
        return service.saveIngrediente(ingrediente);
    }
    //Rota para adicionar vários ingredientes
    @PostMapping("/addIngredientes")
    public List<Ingrediente> addIngredientes(@RequestBody List<Ingrediente> ingredientes){
        return service.saveIngredientes(ingredientes);
    }
    //Rota para listar os ingrediente existentes
    @GetMapping("/igredientes")
    public List<Ingrediente> findAllIngredientes() {
        return service.getIngredientes();
    }

    // Busca especificas (id e nome)
    @GetMapping("/igredienteById/{id}")
    public Ingrediente getIngredienteById(@PathVariable int id) {
        return service.getIngredienteById(id);
    }
    @GetMapping("/igrediente/{name}")
    public Ingrediente IngredienteByNome(@PathVariable String nome) {
        return service.IngredienteByNome(nome);
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
