package com.example.demo.Services;

import com.example.demo.model.Tarefa;
import com.example.demo.model.User;
import com.example.demo.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class TarefasServices {
    @Autowired
    private TarefaRepository repository;

    public List<Tarefa> listarTodas() {
        return repository.findAll();
    }

    public void adicionar(Tarefa tarefa, User user) {
        //verificação para criação de uma tarefa
        tarefa.setIdUser(user);
        tarefa.setSituacao(true);
        tarefa.setStatus("Pendente");
        repository.save(tarefa);
    }
    public void Atraso(Tarefa tarefa) {
        Tarefa t = repository.findById(tarefa.getId()).orElseThrow();
        LocalDate hoje = LocalDate.now();
        if (hoje.isAfter(t.getDate())&& tarefa.getSituacao()==true){
            t.setSituacao(false);
            t.setStatus("Vencido");
        }
        repository.save(t);
    }
    public void atualizar(Long id) {
        Tarefa t = repository.findById(id).orElseThrow();
        if (Objects.equals(t.getStatus(), "Pendente")){
            t.setStatus("Em Andamento");
        }else{
            t.setStatus("Finalizado");
            t.setSituacao(false);
        }
        repository.save(t);
    }


}
