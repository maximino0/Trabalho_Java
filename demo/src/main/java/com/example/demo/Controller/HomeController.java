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

import java.util.List;

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

    @GetMapping({"/home"})
    public String homeForm(Model model) {
        model.addAttribute("tarefa", new Tarefa());
//        model.addAttribute("imagens", List.of("")); criar lógica para essas imagens
        model.addAttribute("tarefas", tarefasServices.listarTodas());
        return this.pagesServices.Home();
    }

    @PostMapping({"/atividades/adicionar"})
    public String Adicionar_Atividade(@ModelAttribute Tarefa tarefa){

        System.out.println(tarefa);

        tarefasServices.adicionar(tarefa);
        Tarefa teste = repository_t.findByNameOrTag(tarefa);
        System.out.println(teste);
        //adicionar lógica para verificação dos dados que entraram como tarefa
        return this.pagesServices.Home();
    }
}
