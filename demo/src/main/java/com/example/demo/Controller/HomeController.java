package com.example.demo.Controller;

import com.example.demo.Services.PagesServices;
import com.example.demo.Services.TarefasServices;
import com.example.demo.model.Tarefa;
import com.example.demo.model.User;
import com.example.demo.repository.TarefaRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.*;
import java.time.LocalDate;
import java.util.*;

@Controller
public class HomeController {
    @Autowired
    private UserRepository repository_u;
    @Autowired
    private PagesServices pagesServices;
    @Autowired
    private TarefasServices tarefasServices;
    @Autowired
    private TarefaRepository repository_t;

    String filtro = "data";
    String ordem = "mês";
    List<String> lista_tags = new ArrayList<>(Arrays.asList(
            "Urgente",
            "Importante",
            "Prioritária",
            "Opcional",
            "Rápida",
            "Demorada",
            "Fácil",
            "Média",
            "Difícil",
            "Imediata",
            "Rotina",
            "Especial",
            "Pessoal",
            "Estudo",
            "Trabalho",
            "Provas",
            "Entrega",
            "Revisão",
            "Pesquisa",
            "Criativa"
    ));

    @GetMapping({"/home"})
    public String homeForm(Model model,  @AuthenticationPrincipal UserDetails userDetails) {
        User user = repository_u.findByUsernameOrEmail(userDetails.getUsername());
        model.addAttribute("tarefa", new Tarefa());
        model.addAttribute("listaTagsProntas", lista_tags);
        List<Tarefa> tarefas = repository_t.findByidUser(user.getId());
        for(Tarefa tarefinha : tarefas){
            tarefasServices.Atraso(tarefinha);
        }
        LocalDate hoje = LocalDate.now();
        if (Objects.equals(filtro, "data")){
            switch(ordem){
                case "dia":
                    tarefas.removeIf(t -> !t.getDate().isEqual(hoje));
                    break;

                case "semana":
                    tarefas.removeIf(t -> {
                        long diff = java.time.temporal.ChronoUnit.DAYS.between(t.getDate(), hoje);
                        diff = diff*-1;
                        return diff > 7 || diff < 0;
                    });
                    break;

                case "mes":
                    tarefas.removeIf(t -> {
                        long diff = java.time.temporal.ChronoUnit.DAYS.between(t.getDate(), hoje);
                        diff = diff*-1;
                        return diff < 0 || diff > 30;
                    });
                    break;

                default:
                    break;
            }

        } else if(Objects.equals(filtro, "tag")){
            tarefas.removeIf(t -> !t.getTags().contains(ordem));
            for(Tarefa tarefa : tarefas){
                tarefa.setTag(ordem);
            }
        } else {
            if(!Objects.equals(ordem, "todas")){
                tarefas.removeIf(t -> !Objects.equals(t.getStatus(), ordem));
            }
        }
        tarefas.sort(Comparator.comparing(t -> t.getDate()));
        model.addAttribute("tarefas",tarefas);
        return this.pagesServices.Home();
    }

    @PostMapping({"/tarefas/adicionar"})
    public String Adicionar_Atividade(@ModelAttribute Tarefa tarefa, @AuthenticationPrincipal UserDetails userDetails){
        User user = repository_u.findByUsernameOrEmail(userDetails.getUsername());
        tarefasServices.adicionar(tarefa, user);
        return "redirect:/home";
    }

    @PostMapping("/tarefas/finalizar")
    public String finalizarTarefa(@RequestParam Long id) {
        tarefasServices.atualizar(id);
        return "redirect:/home";
    }

    @PostMapping("/tarefas/filtro")
    public String filtrarTarefa(@RequestParam String filtragem, String valor) {
        filtro = filtragem;
        ordem = valor;
        return "redirect:/home";
    }

    @PostMapping("/tags/adicionar")
    public String filtrarTarefa(@RequestParam String nomeTag) {
        if(!lista_tags.contains(nomeTag.trim())){
            lista_tags.add(nomeTag.trim());
        }
        return "redirect:/home";
    }



}
