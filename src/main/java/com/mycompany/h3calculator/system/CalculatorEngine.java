package com.mycompany.h3calculator.system;

import com.mycompany.h3calculator.container.ArmyContainer;
import com.mycompany.h3calculator.container.HeroContainer;
import com.mycompany.h3calculator.model.Army;
import com.mycompany.h3calculator.model.Report;
import com.mycompany.h3calculator.model.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CalculatorEngine {

    private final HeroContainer heroContainer;
    private final ArmyContainer armyContainer;

    private Army armyOne;
    private Army armyTwo;

    @Autowired
    public CalculatorEngine(HeroContainer heroContainer, ArmyContainer armyContainer) {
        this.heroContainer = heroContainer;
        this.armyContainer = armyContainer;
        armyOne = new Army();
        armyTwo = new Army();
    }

    public void createArmyOne() {
        armyOne.setUnit(new Unit(armyContainer.getArmies()[0].getUnit()));
        armyOne.getUnit().addHeroAttributes(heroContainer.getHeroes()[0]);
        armyOne.setNumberOfUnits(armyContainer.getArmies()[0].getNumberOfUnits());
    }

    public void createArmyTwo() {
        armyTwo.setUnit(new Unit(armyContainer.getArmies()[1].getUnit()));
        armyTwo.getUnit().addHeroAttributes(heroContainer.getHeroes()[1]);
        armyTwo.setNumberOfUnits(armyContainer.getArmies()[1].getNumberOfUnits());
    }

    public Report calculate() {
        Report report = new Report();
        double minDmg;
        double maxDmg;

        report.setMinDmg((long) (armyOne.getUnit().getMinDmg()
                * armyOne.getNumberOfUnits()
                * dmgModifier()));

        report.setMaxDmg((long) (armyOne.getUnit().getMaxDmg()
                * armyOne.getNumberOfUnits()
                * dmgModifier()));

        report.setMinUnitsDestroyed(report.getMinDmg() / armyTwo.getUnit().getHp());
        report.setMaxUnitsDestroyed(report.getMaxDmg() / armyTwo.getUnit().getHp());

        return report;
    }

    private double dmgModifier() {
        return (1
                + calculateAttack()
                + calculateOffenceSkill()
                + calculateOffenceHeroSkill()
                + calculateLuck()
                + calculateHateModifier())
                * (1
                - calculateDefence())
                * (1
                - calculateArmorerSkill()
                - calculateHeroArmorerSkill())
                * (1
                - calculateSpellShields())
                * (1
                - calculateRangedPenalty())
                * (1
                - calculateObstaclePenalty())
                * (1
                - calculateUnderBlindSpell())
                * (1
                - calculateSpellImmunity());
    }

    private double calculateAttack() {
        if (armyOne.getUnit().getAttack() > armyTwo.getUnit().getDefence()) {
            return 0.05 * (armyOne.getUnit().getAttack() - armyTwo.getUnit().getDefence());
        } else return 0;
    }

    private double calculateDefence() {
        if (armyOne.getUnit().getAttack() < armyTwo.getUnit().getDefence()) {
            return 0.025 * (armyTwo.getUnit().getDefence() - armyOne.getUnit().getAttack());
        } else return 0;
    }

    private double calculateOffenceSkill() {
        return 0;
    }

    private double calculateOffenceHeroSkill() {
        return 0;
    }

    private double calculateLuck() {
        return 0;
    }

    private double calculateHateModifier() {
        return 0;
    }

    private double calculateArmorerSkill() {
        return 0;
    }

    private double calculateHeroArmorerSkill() {
        return 0;
    }

    private double calculateSpellShields() {
        return 0;
    }

    private double calculateRangedPenalty() {
        return 0;
    }

    private double calculateObstaclePenalty() {
        return 0;
    }

    private double calculateUnderBlindSpell() {
        return 0;
    }

    private double calculateSpellImmunity() {
        return 0;
    }

}
