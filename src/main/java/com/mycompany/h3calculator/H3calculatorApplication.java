package com.mycompany.h3calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.mycompany.h3calculator.container",
        "com.mycompany.h3calculator.controller",
        "com.mycompany.h3calculator.repository",
        "com.mycompany.h3calculator.system",
        "com.mycompany.h3calculator.view"
})
public class H3calculatorApplication {
    public static void main(String[] args) {
        SpringApplication.run(H3calculatorApplication.class, args);
    }
}
