package com.xsx;

public abstract class Weapon {
    private int damagePoints;

    public Weapon( int damagePoints) {
        this.damagePoints = damagePoints;
    }

    public abstract void useArticle(Creature enemyCreature);

    public Weapon() {
    }

    public int getDamagePoints() {
        return damagePoints;
    }

    public void setDamagePoints(int damagePoints) {
        this.damagePoints = damagePoints;
    }
}
