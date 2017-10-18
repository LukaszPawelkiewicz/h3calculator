package com.mycompany.h3calculator.model;

public class Unit {

    private int attack;
    private int defence;
    private int minDmg;
    private int maxDmg;
    private int hp;
    private int speed;

    public Unit() {
    }

    public Unit(int attack, int defence, int minDmg, int maxDmg, int hp, int speed) {
        this.attack = attack;
        this.defence = defence;
        this.minDmg = minDmg;
        this.maxDmg = maxDmg;
        this.hp = hp;
        this.speed = speed;
    }

    public Unit(Unit unit) {
        this.attack = unit.attack;
        this.defence = unit.defence;
        this.minDmg = unit.minDmg;
        this.maxDmg = unit.maxDmg;
        this.hp = unit.hp;
        this.speed = unit.speed;
    }

    public void addHeroAttributes(Hero hero) {
        this.attack += hero.getAttack();
        this.defence += hero.getDefence();
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

    public int getMinDmg() {
        return minDmg;
    }

    public void setMinDmg(int minDmg) {
        this.minDmg = minDmg;
    }

    public int getMaxDmg() {
        return maxDmg;
    }

    public void setMaxDmg(int maxDmg) {
        this.maxDmg = maxDmg;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
