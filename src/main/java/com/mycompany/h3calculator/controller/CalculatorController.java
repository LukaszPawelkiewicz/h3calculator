package com.mycompany.h3calculator.controller;

import com.mycompany.h3calculator.model.Hero;
import com.mycompany.h3calculator.system.HeroContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
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

    @PostMapping("/hero/1/set")
    public String addHeroOne(@ModelAttribute Hero hero) {
        heroContainer.setHeroOne(hero);
        return "hello";
    }

    @PostMapping("/hero/2/set")
    public String addHeroTwo(@ModelAttribute Hero hero) {
        heroContainer.setHeroTwo(hero);
        return "hello";
    }

}
