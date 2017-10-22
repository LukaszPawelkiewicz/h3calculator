package com.mycompany.h3calculator.model;

public class Hero {

    private Unit unit;
    private int attack;
    private int defence;
    private int power;
    private int knowledge;

    public Hero() {
    }

    public Hero(int attack, int defence, int power, int knowledge) {
        this.attack = attack;
        this.defence = defence;
        this.power = power;
        this.knowledge = knowledge;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(int knowledge) {
        this.knowledge = knowledge;
    }
}
