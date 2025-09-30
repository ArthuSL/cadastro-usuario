package com.java.aula.cadastro_usuario.business;

import com.java.aula.cadastro_usuario.infrastructure.entitys.Animal;
import com.java.aula.cadastro_usuario.infrastructure.repository.AnimalRepository;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    private final AnimalRepository repository;

    public AnimalService(AnimalRepository repository) {
        this.repository = repository;
    }
    public void salvarAnimal(Animal animal) {
        repository.saveAndFlush(animal);
    }

    public Animal buscarAnimalPorNome(String nome) {
        return repository.findByNome(nome).orElseThrow(
                () -> new RuntimeException("Nome não encontrado")
        );
    }

    public void deletarAnimalPorNome(String nome){
        repository.deleteByNome(nome);
    }

    public void atualizarAnimalPorId(Integer id, Animal animal){
        Animal animalAntigo = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Animal nao encontrado"));
        Animal animalAtualizado = Animal.builder()
                .nome(animal.getNome() != null ? animal.getNome() :
                        animalAntigo.getNome())
                .cor(animal.getCor() != null ? animal.getCor() :
                        animalAntigo.getCor())
                .especie(animal.getEspecie() != null ? animal.getEspecie() :
                        animalAntigo.getEspecie())
                .id(animalAntigo.getId())
                .build();

        repository.saveAndFlush(animalAtualizado);
    }

}
