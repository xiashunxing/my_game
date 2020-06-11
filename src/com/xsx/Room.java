package com.xsx;

public class Room {
    public String description;
    public String boss;
    public Room eastExit;
    public Room southExit;
    public Room westExit;
    public Room northExit;


    public Room(String description, String boss) {
        this.description = description;
        this.boss = boss;
    }

    public void setExits(Room east, Room south, Room west, Room north)
    {
        if(east != null)
            eastExit = east;
        if(south != null)
            southExit = south;
        if(west != null)
            westExit = west;
        if(north != null)
            northExit = north;
    }

    @Override
    public String toString()
    {
        return description;
    }

}
