package com.example.demo.Controller;

import com.example.demo.Services.PagesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController {
    @Autowired
    private PagesServices pagesServices;

    @GetMapping("/")
    public String home() {
        return pagesServices.Login();
    }
    @GetMapping("/Log")
    public String Log() {
        return pagesServices.Log();
    }
    @GetMapping("/Cadastro")
    public String Cadastro() {
        return pagesServices.Cadastro();
    }
}
