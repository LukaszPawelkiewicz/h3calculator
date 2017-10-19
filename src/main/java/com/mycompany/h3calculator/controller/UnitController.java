package com.mycompany.h3calculator.controller;

import com.mycompany.h3calculator.container.UnitContainer;
import com.mycompany.h3calculator.model.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("unit")
public class UnitController {

    private final UnitContainer unitContainer;

    @Autowired
    public UnitController(UnitContainer unitContainer) {
        this.unitContainer = unitContainer;
    }

    @GetMapping("/local")
    public Unit[] getUnitLocal() {
        return unitContainer.getUnits();
    }

    @PostMapping("/1/set")
    public HttpStatus addUnitOne(@RequestBody Unit unit) {
        unitContainer.setUnitOne(unit);
        return HttpStatus.CREATED;
    }

    @PostMapping("/2/set")
    public HttpStatus addUnitTwo(@RequestBody Unit unit) {
        unitContainer.setUnitTwo(unit);
        return HttpStatus.CREATED;
    }
}
