package com.mycompany.h3calculator.container;

import com.mycompany.h3calculator.model.Army;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ArmyContainer {

    private final Army[] armies = new Army[2];

    public void setArmyOne(Army armyOne) {
        armies[0] = armyOne;
    }

    public void setArmyTwo(Army armyTwo) {
        armies[1] = armyTwo;
    }

    public Army[] getArmies() {
        return armies;
    }
}
