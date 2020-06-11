package com.xsx;

public class Map {
    public Room currentRoom;

    public Map()
    {
        createRooms();
    }

    public void createRooms(){

        Room smd, ltxg, ahjd, wswhs,wlgb,lzmj;

        //	制造房间
        smd = new Room("神秘岛","boss1");
        ltxg = new Room("雷霆峡谷","boss2");
        ahjd = new Room("暗黑基地","boss3");
        wswhs = new Room("维苏威火山","boss4");
        wlgb = new Room("威廉古堡","boss5");
        lzmj = new Room("龙之秘境","boss6");
        //	初始化房间的出口
        smd.setExits(ltxg, null, wlgb, wswhs);
        ltxg.setExits(null, null, smd, ahjd);
        ahjd.setExits(null, ltxg, null, null);
        wswhs.setExits(null, smd, lzmj, null);
        wlgb.setExits(smd, null, null, null);
        lzmj.setExits(wswhs,null,null,null);

        currentRoom = smd;  //	从神秘岛开始
    }

    public void Welcome() {
        System.out.println("你当前在" + currentRoom);
        System.out.print("你可以去（go 方位）:");
        derection();
    }

    private void derection(){
        if(currentRoom.northExit != null)
            System.out.print(currentRoom.northExit+"(north) ");
        if(currentRoom.eastExit != null)
            System.out.print(currentRoom.eastExit+"(east) ");
        if(currentRoom.southExit != null)
            System.out.print(currentRoom.southExit+"(south) ");
        if(currentRoom.westExit != null)
            System.out.print(currentRoom.westExit+"(west) ");
        System.out.println();
    }

    public void goRoom(String direction)
    {
        Room nextRoom = null;
        if(direction.equals("north")) {
            nextRoom = currentRoom.northExit;
        }
        if(direction.equals("east")) {
            nextRoom = currentRoom.eastExit;
        }
        if(direction.equals("south")) {
            nextRoom = currentRoom.southExit;
        }
        if(direction.equals("west")) {
            nextRoom = currentRoom.westExit;
        }

        if (nextRoom == null) {
            System.out.println("此路不通");
        }
        else {
            currentRoom = nextRoom;
            System.out.println("你当前在" + currentRoom);
            System.out.print("你可以去（go 方位）: ");
            derection();
        }
    }
}
