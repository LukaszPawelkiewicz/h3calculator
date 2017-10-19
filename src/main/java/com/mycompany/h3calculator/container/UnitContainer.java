package com.mycompany.h3calculator.container;

import com.mycompany.h3calculator.model.Unit;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UnitContainer {

    private final Unit[] units = new Unit[2];

    public void setUnitOne(Unit unit) {
        units[0] = unit;
    }

    public void setUnitTwo(Unit unit) {
        units[1] = unit;
    }

    public Unit[] getUnits() {
        return units;
    }
}
