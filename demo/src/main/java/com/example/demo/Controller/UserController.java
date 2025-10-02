package com.example.demo.Controller;


import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping({"/cadastro"})
    public String cadastroForm(Model model) {
        model.addAttribute("user", new User());
        return "cadastro";
    }

    @PostMapping({"/cadastro"})
    public String cadastroSubmit(@ModelAttribute User User) {
        this.repository.save(User);
        return "redirect:/";
    }

    @GetMapping({"/usuarios"})
    @ResponseBody
    public List<User> listarUsuarios() {
        return this.repository.findAll();
    }
}

