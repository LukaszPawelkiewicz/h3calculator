package com.mycompany.h3calculator;

import com.mycompany.h3calculator.container.HeroContainer;
import com.mycompany.h3calculator.controller.HeroController;
import com.mycompany.h3calculator.repository.UnitRepository;
import com.mycompany.h3calculator.system.CalculatorEngine;
import com.mycompany.h3calculator.view.MainUI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = {
        HeroContainer.class,
        HeroController.class,
        UnitRepository.class,
        CalculatorEngine.class,
        MainUI.class
})
public class H3calculatorApplication {
    public static void main(String[] args) {
        SpringApplication.run(H3calculatorApplication.class, args);
    }
}
