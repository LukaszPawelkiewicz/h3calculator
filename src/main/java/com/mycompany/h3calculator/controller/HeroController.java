package com.mycompany.h3calculator.controller;

import com.mycompany.h3calculator.model.Hero;
import com.mycompany.h3calculator.system.HeroContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hero")
public class HeroController {

    private final HeroContainer heroContainer;

    @Autowired
    public HeroController(HeroContainer heroContainer) {
        this.heroContainer = heroContainer;
    }

    @GetMapping("all")
    public Hero[] getAll() {
        return heroContainer.getHeroes();
    }


}
