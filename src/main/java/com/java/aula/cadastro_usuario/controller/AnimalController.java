package com.java.aula.cadastro_usuario.controller;

import com.java.aula.cadastro_usuario.business.AnimalService;
import com.java.aula.cadastro_usuario.infrastructure.entitys.Animal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/animal")

public class AnimalController {

    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {this.animalService = animalService;}

    @PostMapping
    public ResponseEntity<Void> salvarAnimal(@RequestBody Animal animal){
        animalService.salvarAnimal(animal);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Animal> buscarAnimalPorNome(@RequestParam String nome){
        return ResponseEntity.ok(animalService.buscarAnimalPorNome(nome));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarAnimalPorNome(@RequestParam String nome){
        animalService.deletarAnimalPorNome(nome);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarUsuarioPorId(@RequestParam Integer id,
                                                      @RequestBody Animal animal){
        animalService.atualizarAnimalPorId(id, animal);
        return ResponseEntity.ok().build();
    }

}
