package com.xsx;

import java.util.ArrayList;

public abstract class Creature {
    private String id;
    private String description;
    private int HP;
    private int Attack;
    private String skill;
    private String room;
    private Weapon currentWeapon;
    private ArrayList<Weapon> weapons=new ArrayList<Weapon>();


    public abstract void useArticle(Weapon weapon,Creature targetCreature);

    public Creature() {
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public int getHP() { return HP; }

    public void setHP(int HP) { this.HP = HP; }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public int getAttack() {
        return Attack;
    }

    public void setAttack(int attack) {
        Attack = attack;
    }

    public String getRoom() { return room; }

    public void setRoom(String room) { this.room = room; }

    public Weapon getCurrentWeapon() { return currentWeapon; }

    public void setCurrentWeapon(Weapon currentWeapon) { this.currentWeapon = currentWeapon; }
}
