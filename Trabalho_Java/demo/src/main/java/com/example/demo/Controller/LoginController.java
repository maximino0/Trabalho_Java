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

    @GetMapping("/Home")
    public String Home() {
        return pagesServices.Home();
    }
}
