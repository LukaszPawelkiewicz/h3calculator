package com.mycompany.h3calculator.model;

public class ModifierContext {

    private Level OffenceSkill = Level.NONE;
    private Level ArmorerSkill = Level.NONE;
    private Level shieldSpell = Level.NONE;
    private Level bloodLustSpell = Level.NONE;
    private Level stoneSkinSpell = Level.NONE;
    private Level blindSpell = Level.NONE;

    public ModifierContext() {
    }

    public Level getOffenceSkill() {
        return OffenceSkill;
    }

    public void setOffenceSkill(Level offenceSkill) {
        OffenceSkill = offenceSkill;
    }

    public Level getArmorerSkill() {
        return ArmorerSkill;
    }

    public void setArmorerSkill(Level armorerSkill) {
        ArmorerSkill = armorerSkill;
    }

    public Level getShieldSpell() {
        return shieldSpell;
    }

    public void setShieldSpell(Level shieldSpell) {
        this.shieldSpell = shieldSpell;
    }

    public Level getBloodLustSpell() {
        return bloodLustSpell;
    }

    public void setBloodLustSpell(Level bloodLustSpell) {
        this.bloodLustSpell = bloodLustSpell;
    }

    public Level getStoneSkinSpell() {
        return stoneSkinSpell;
    }

    public void setStoneSkinSpell(Level stoneSkinSpell) {
        this.stoneSkinSpell = stoneSkinSpell;
    }

    public Level getBlindSpell() {
        return blindSpell;
    }

    public void setBlindSpell(Level blindSpell) {
        this.blindSpell = blindSpell;
    }

    public enum Level {
        NONE,
        BEGINNER,
        ADVANCED,
        MASTER
    }

}
