//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.Controller;

import com.example.demo.Services.PagesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class LoginController {
    @Autowired
    private PagesServices pagesServices;

    @GetMapping({"/","/logout"})
    public String login() {
        return this.pagesServices.Login();
    }
    @GetMapping("/login")
    public String home(Model model, @RequestParam(required = false) String error) {
        if (error != null) {
            model.addAttribute("mensagemErro", "Usuário não existente.");
        }
        return this.pagesServices.Login();
    }
}
