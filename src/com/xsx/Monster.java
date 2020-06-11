package com.xsx;

public class Monster extends Creature{
    @Override
    public void useArticle(Weapon weapon, Creature targetCreature) {
        weapon.useArticle(targetCreature);
    }


}
