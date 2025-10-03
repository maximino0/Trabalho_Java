package com.example.demo.repository;

import com.example.demo.model.Tarefa;
import com.example.demo.model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    Tarefa findByName(String name);

    Tarefa findByDate(String date);

    default Tarefa findByNameOrDate(String fazer) {
        Tarefa tarefa = this.findByName(fazer);
        if (tarefa == null) {
            tarefa = this.findByDate(fazer);
        }
        return tarefa;
    }

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
