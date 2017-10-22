package com.mycompany.h3calculator.model;

public class Army {

    private Unit unit;
    private int numberOfUnits;

    public Army() {
    }

    public Army(Unit unit, int numberOfUnits) {
        this.unit = unit;
        this.numberOfUnits = numberOfUnits;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public int getNumberOfUnits() {
        return numberOfUnits;
    }

    public void setNumberOfUnits(int numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }
}
