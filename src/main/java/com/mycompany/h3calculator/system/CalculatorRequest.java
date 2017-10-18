package com.mycompany.h3calculator.system;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Deprecated
@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CalculatorRequest {

    public CalculatorRequest() {
    }

    @PostConstruct
    public void init() {
        System.out.println("start request");
    }

    @PreDestroy
    public void onDestroy() {
        System.out.println("ends request");
    }

}
