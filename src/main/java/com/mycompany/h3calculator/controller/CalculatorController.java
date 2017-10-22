package com.mycompany.h3calculator.controller;

import com.mycompany.h3calculator.model.Report;
import com.mycompany.h3calculator.system.CalculatorEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("calculator")
public class CalculatorController {

    private final CalculatorEngine calculatorEngine;

    @Autowired
    public CalculatorController(CalculatorEngine calculatorEngine) {
        this.calculatorEngine = calculatorEngine;
    }

    @GetMapping("/calculate")
    public Report calculate() {
        calculatorEngine.createArmyOne();
        calculatorEngine.createArmyTwo();

        return calculatorEngine.calculate();
    }

}
