package com.xsx;

public class Attack extends Weapon{
    public Attack(int damagePoints) {
        super(damagePoints);
    }

    @Override
    public void useArticle(Creature enemyCreature) {
        enemyCreature.setHP(enemyCreature.getHP()+this.getDamagePoints());
    }
}
