package com.mycompany.h3calculator.controller;

import com.mycompany.h3calculator.model.Hero;
import com.mycompany.h3calculator.container.HeroContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
@Deprecated
@RequestMapping("/")
public class CalculatorController {

    private final HeroContainer heroContainer;

    @Autowired
    public CalculatorController(HeroContainer heroContainer) {
        this.heroContainer = heroContainer;
    }

    @GetMapping("/")
    public String hello(Model model) {
        model.addAttribute("hero", new Hero());
        return "hello";
    }



}
