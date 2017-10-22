package com.mycompany.h3calculator.repository.impl;

import com.mycompany.h3calculator.model.Hero;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HeroRepositoryImpl implements HeroRepository {

    private final List<Hero> heroes = new ArrayList<>();

    public HeroRepositoryImpl() {
        Hero hero = new Hero(10, 10, 10, 10);
        heroes.add(hero);
    }

    @Override
    public List<Hero> getAll() {
        return heroes;
    }
}
