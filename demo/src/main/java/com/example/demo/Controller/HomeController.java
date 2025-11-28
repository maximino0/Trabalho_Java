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

import java.time.LocalDate;
import java.util.Comparator;
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
    public String homeForm(Model model,  @AuthenticationPrincipal UserDetails userDetails) {
        User user = repository_u.findByUsernameOrEmail(userDetails.getUsername());
        model.addAttribute("tarefa", new Tarefa());

        List<Tarefa> tarefas = repository_t.findByidUser(user.getId());
        LocalDate hoje = LocalDate.now();

        tarefas.sort(Comparator.comparing(t -> {
            LocalDate data = t.getDate();
            return data.isBefore(hoje) ? hoje.plusYears(100) : data; // atrasadas vão pro final
        }));
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
        tarefasServices.finalizar(id);
        return "redirect:/home";
    }
}
