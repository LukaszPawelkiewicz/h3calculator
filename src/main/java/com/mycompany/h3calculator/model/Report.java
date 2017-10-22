package com.mycompany.h3calculator.model;

public class Report {

    private long minDmg;
    private long maxDmg;
    private long minUnitsDestroyed;
    private long maxUnitsDestroyed;

    public Report() {
    }

    public long getMinDmg() {
        return minDmg;
    }

    public void setMinDmg(long minDmg) {
        this.minDmg = minDmg;
    }

    public long getMaxDmg() {
        return maxDmg;
    }

    public void setMaxDmg(long maxDmg) {
        this.maxDmg = maxDmg;
    }

    public long getMinUnitsDestroyed() {
        return minUnitsDestroyed;
    }

    public void setMinUnitsDestroyed(long minUnitsDestroyed) {
        this.minUnitsDestroyed = minUnitsDestroyed;
    }

    public long getMaxUnitsDestroyed() {
        return maxUnitsDestroyed;
    }

    public void setMaxUnitsDestroyed(long maxUnitsDestroyed) {
        this.maxUnitsDestroyed = maxUnitsDestroyed;
    }
}
