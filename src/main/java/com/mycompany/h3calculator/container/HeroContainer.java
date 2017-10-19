package com.mycompany.h3calculator.container;

import com.mycompany.h3calculator.model.Hero;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class HeroContainer {

    private final Hero[] heroes = new Hero[2];

    public void setHeroOne(Hero hero) {
        heroes[0] = hero;
    }

    public void setHeroTwo(Hero hero) {
        heroes[1] = hero;
    }

    public Hero[] getHeroes() {
        return heroes;
    }
}
