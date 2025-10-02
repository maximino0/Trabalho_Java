package com.example.demo.repository;

import com.example.demo.model.Tarefa;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

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
}
