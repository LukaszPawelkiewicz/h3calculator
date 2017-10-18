package com.mycompany.h3calculator.controller;

import com.mycompany.h3calculator.model.Hero;
import com.mycompany.h3calculator.repository.HeroRepository;
import com.mycompany.h3calculator.system.HeroContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping("/")
public class CalculatorController {

    private final HeroRepository heroRepository;
    private final HeroContainer heroContainer;

    @Autowired
    public CalculatorController(HeroRepository heroRepository, HeroContainer heroContainer) {
        this.heroRepository = heroRepository;
        this.heroContainer = heroContainer;
    }

    @GetMapping("hero/all")
    public List<Hero> allHeroes() {
        return heroRepository.getAll();
    }

    @GetMapping("heroes/all")
    public Hero[] getAll() {
        return heroContainer.getHeroes();
    }

    @PostMapping("hero/1/set")
    public void addHeroOne(Hero hero) {
        heroContainer.setHeroTwo(hero);
    }

    @PostMapping("hero/2/set")
    public void addHeroTwo(Hero hero) {
        heroContainer.setHeroOne(hero);
    }


}
