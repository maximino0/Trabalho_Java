package com.example.demo.Controller;

import com.example.demo.Services.PagesServices;
import com.example.demo.model.Tarefa;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private UserRepository repository;
    @Autowired
    private PagesServices pagesServices;

    @GetMapping({"/Home"})
    public String homeForm(Model model) {
        model.addAttribute("tarefa", new Tarefa());
        return this.pagesServices.Home();
    }
}
