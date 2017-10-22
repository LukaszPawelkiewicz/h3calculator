package com.mycompany.h3calculator.controller;

import com.mycompany.h3calculator.container.ArmyContainer;
import com.mycompany.h3calculator.model.Army;
import com.mycompany.h3calculator.model.Unit;
import com.mycompany.h3calculator.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("army")
public class ArmyController {

    private final ArmyContainer armyContainer;
    private final UnitRepository unitRepository;

    @Autowired
    public ArmyController(ArmyContainer armyContainer, UnitRepository unitRepository) {
        this.armyContainer = armyContainer;
        this.unitRepository = unitRepository;
    }

    @GetMapping("/local")
    public Army[] getUnitLocal() {
        return armyContainer.getArmies();
    }

    @GetMapping("/all")
    public List<Unit> getAllUnits() {
        return unitRepository.getAllUnits();
    }

    @PostMapping("/1/set")
    public void addArmyOne(@RequestBody Army army) {
        armyContainer.setArmyOne(army);
    }

    @PostMapping("/2/set")
    public void addArmyTwo(@RequestBody Army army) {
        armyContainer.setArmyTwo(army);
    }
}
