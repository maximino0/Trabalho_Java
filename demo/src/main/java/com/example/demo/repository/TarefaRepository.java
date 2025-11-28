package com.example.demo.repository;

import com.example.demo.model.Tarefa;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    Tarefa findByName(String name);

    Tarefa findByTag(String tag);

    Tarefa findByDate(LocalDate date);

    default Tarefa findByNameOrTag(Tarefa entrada) {
        Tarefa tarefa = this.findByName(entrada.getName());
        if (tarefa == null) {
            tarefa = this.findByTag(entrada.getTag());
        }
        return tarefa;
    }

    List<Tarefa> findByidUser(Long IdUser);

    @Override
    default <S extends Tarefa> List<S> findAll(Example<S> example) {
        return List.of();
    }

    default List<Tarefa> buscarPorTag(String tag) {
        Tarefa probe = new Tarefa();
        probe.setTag(tag);
        Example<Tarefa> example = Example.of(probe);
        return this.findAll(example);
    }
}
