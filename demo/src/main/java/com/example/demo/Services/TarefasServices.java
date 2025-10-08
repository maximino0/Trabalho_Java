package com.example.demo.Services;

import com.example.demo.model.Tarefa;
import com.example.demo.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TarefasServices {
    @Autowired
    private TarefaRepository repository;

    public List<Tarefa> listarTodas() {
        return repository.findAll();
    }

    public void adicionar(Tarefa tarefa) {
        //verificação para criação de uma tarefa
        repository.save(tarefa);
    }


}
