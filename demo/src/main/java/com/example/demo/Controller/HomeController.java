package com.example.demo.Controller;

import com.example.demo.Services.PagesServices;
import com.example.demo.Services.TarefasServices;
import com.example.demo.model.Tarefa;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private UserRepository repository;
    @Autowired
    private PagesServices pagesServices;
    @Autowired
    private TarefasServices tarefasServices;

    @GetMapping({"/home"})
    public String homeForm(Model model) {
        model.addAttribute("tarefa", new Tarefa());
//        model.addAttribute("imagens", List.of("")); criar lógica para essas imagens
        model.addAttribute("tarefas", tarefasServices.listarTodas());
        return this.pagesServices.Home();
    }

    @PostMapping({"/atividades/adicionar"})
    public void Adicionar_Atividade(@ModelAttribute Tarefa tarefa){
        System.out.println(tarefa);
        tarefasServices.adicionar(tarefa);
        //adicionar lógica para verificação dos dados que entraram como tarefa
    }
}
