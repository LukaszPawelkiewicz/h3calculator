package com.mycompany.h3calculator;

import com.mycompany.h3calculator.controller.CalculatorController;
import com.mycompany.h3calculator.repository.HeroRepository;
import com.mycompany.h3calculator.system.CalculatorEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = {
        HeroRepository.class,
        CalculatorController.class,
        CalculatorEngine.class
})
public class H3calculatorApplication {
    public static void main(String[] args) {
        SpringApplication.run(H3calculatorApplication.class, args);
    }
}