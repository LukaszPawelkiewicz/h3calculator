package com.mycompany.h3calculator.system;

import com.mycompany.h3calculator.model.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CalculatorEngine {

    private final HeroContainer heroContainer;

    @Autowired
    public CalculatorEngine(HeroContainer heroContainer) {
        this.heroContainer = heroContainer;
    }

    public void calculate() {
        Unit unit1 = new Unit(heroContainer.getHeroes()[0].getUnit());
        unit1.addHeroAttributes(heroContainer.getHeroes()[0]);
        Unit unit2 = new Unit(heroContainer.getHeroes()[1].getUnit());
        unit2.addHeroAttributes(heroContainer.getHeroes()[1]);
    }
}
