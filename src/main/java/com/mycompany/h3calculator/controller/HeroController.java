package com.mycompany.h3calculator.controller;

import com.mycompany.h3calculator.container.HeroContainer;
import com.mycompany.h3calculator.model.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hero")
public class HeroController {

    private final HeroContainer heroContainer;

    @Autowired
    public HeroController(HeroContainer heroContainer) {
        this.heroContainer = heroContainer;
    }

    @GetMapping("/local")
    public Hero[] getLocal() {
        return heroContainer.getHeroes();
    }

    @PostMapping("/1/set")
    public HttpStatus addHeroOne(@RequestBody Hero hero) {
        heroContainer.setHeroOne(hero);
        return HttpStatus.CREATED;
    }

    @PostMapping("/2/set")
    public HttpStatus addHeroTwo(@RequestBody Hero hero) {
        heroContainer.setHeroTwo(hero);
        return HttpStatus.CREATED;
    }


}
