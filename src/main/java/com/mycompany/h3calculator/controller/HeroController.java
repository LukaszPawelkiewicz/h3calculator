package com.mycompany.h3calculator.controller;

import com.mycompany.h3calculator.model.Hero;
import com.mycompany.h3calculator.system.HeroContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HeroController {

    private final HeroContainer heroContainer;

    @Autowired
    public HeroController(HeroContainer heroContainer) {
        this.heroContainer = heroContainer;
    }

    @PostMapping("/hero/1/add")
    public String addHeroOne(@ModelAttribute Hero hero) {
        heroContainer.setHeroOne(hero);
        return "hello";
    }

    @PostMapping("/hero/2/add")
    public String addHeroTwo(@ModelAttribute Hero hero) {
        heroContainer.setHeroTwo(hero);
        return "hello";
    }

    @GetMapping("/")
    public String hello(Model model) {
        model.addAttribute("hero", new Hero());
        return "hello";
    }

}
