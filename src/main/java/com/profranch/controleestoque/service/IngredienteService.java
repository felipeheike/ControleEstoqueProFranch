package com.profranch.controleestoque.service;

import com.profranch.controleestoque.repository.IngredienteRepository;
import com.profranch.controleestoque.model.Ingrediente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredienteService {
    @Autowired
    private IngredienteRepository repository;
    public Ingrediente saveIngrediente(Ingrediente ingrediente){
        return repository.save(ingrediente);
    }
    public List<Ingrediente> getIngredientes(){
        return repository.findAll();
    }
    public Ingrediente getIngredienteById(int id){
        return repository.findById(id).orElse(null);
    }
    public Ingrediente IngredienteByNome(String nome){
        return repository.findByNome(nome);
    }
    public List<Ingrediente> saveIngredientes(List<Ingrediente> ingredientes) {
        return repository.saveAll(ingredientes);
    }
    public Ingrediente updateIngrediente(Ingrediente ingrediente){
        Ingrediente existingIngrediente = repository.findById(ingrediente.getId()).orElse(null);
        existingIngrediente.setNome(ingrediente.getNome());
        existingIngrediente.setPreco(ingrediente.getPreco());
        existingIngrediente.setUnidadeDeMedida(ingrediente.getUnidadeDeMedida());
        return repository.save(existingIngrediente);
    }


}
