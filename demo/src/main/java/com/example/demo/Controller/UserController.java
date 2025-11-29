package com.example.demo.Controller;


import com.example.demo.Services.PagesServices;
import com.example.demo.Services.UserServices;
import com.example.demo.model.Tarefa;
import com.example.demo.model.User;
import com.example.demo.repository.TarefaRepository;
import com.example.demo.repository.UserRepository;
import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class UserController {
    @Autowired
    private UserRepository repository_u;
    @Autowired
    private TarefaRepository repository_t;



    @Autowired
    private PagesServices pagesServices;

    @Autowired
    private UserServices UserServices;

    User User = new User();

    @GetMapping({"/cadastro"})
    public String cadastroForm(Model model) {
        model.addAttribute("user", new User());
        return this.pagesServices.Cadastro();
    }

    @PostMapping({"/cadastro"})
    public String cadastroSubmit(Model model,@ModelAttribute @Valid User user, BindingResult result) {
        //criação de uma lógica para verificar os dados que entram
        if(UserServices.Cadastrar(user) && !result.hasErrors()){
            UserServices.AdicionarCadastro(user);
            return this.pagesServices.Login();
        }
        model.addAttribute("mensagemErro", "Credenciais inválidas.");
        return this.pagesServices.Cadastro();
    }

    @GetMapping({"/usuarios"})
    @ResponseBody
    public List<User> listarUsuarios() {
        return this.repository_u.findAll();
    }

    @GetMapping({"/tarefas"})
    @ResponseBody
    public List<Tarefa> listarTarefas() {
        return this.repository_t.findAll();
    }
}

