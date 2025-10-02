//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.Controller;

import com.example.demo.Services.PagesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @Autowired
    private PagesServices pagesServices;

    @GetMapping({"/"})
    public String home() {
        return this.pagesServices.Login();
    }

    @GetMapping({"/Home"})
    public String Home() {
        return this.pagesServices.Home();
    }
}
