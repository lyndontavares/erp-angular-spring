package com.comercial.easyrules.spring;

import org.easyrules.api.RulesEngine;
import org.easyrules.core.RulesEngineBuilder;

public class Launcher {

    public static void main(String[] args) {
        //create a person instance
        Person tom = new Person("Tom", 14);
        System.out.println("Tom: Hi! can I have some Vodka please?");

        //create a rules engine
        RulesEngine rulesEngine = RulesEngineBuilder.aNewRulesEngine()
                .named("shop rules engine")
                .build();

        //register rules
        rulesEngine.registerRule(new AgeRule(tom));
        rulesEngine.registerRule(new AlcoholRule(tom));

        //fire rules
        rulesEngine.fireRules();
    }

}