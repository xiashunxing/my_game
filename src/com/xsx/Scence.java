package com.xsx;

import java.util.Scanner;

public class Scence {
    private Person role = new Person();
    private Monster monster1=new Monster();
    private Monster monster2=new Monster();
    private Monster monster3=new Monster();
    private Monster monster4=new Monster();
    private MonsterSet monsterSet=new MonsterSet();
    private Room currentRoom;
    Ui ui = new Ui();
    Map map = new Map();





    public void initScence(){
        initPerson();
        initMonster();
    }

    Scanner input = new Scanner(System.in);

    public void initPerson(){
        ui.display1(this);
        System.out.println("请选择你喜欢的角色(输入1 or 2 or 3): 1.龙星 2.小桃 3.奥多");
        int character = input.nextInt();
        switch (character) {
            case 1:
                role.setId("lx");
                role.setDescription("龙星");
                role.setHP(300);
                role.setSkill("烈焰冲撞");
                role.setRoom("smd");
                role.setAttack(50);
                role.setCurrentWeapon(new Attack(-50));
                break;
            case 2:
                role.setId("xt");
                role.setDescription("小桃");
                role.setHP(320);
                role.setSkill("天使之吻");
                role.setRoom("smd");
                role.setAttack(40);
                role.setCurrentWeapon(new Attack(-40));
                break;
            case 3:
                role.setId("ad");
                role.setDescription("奥多");
                role.setHP(250);
                role.setSkill("审判之石");
                role.setRoom("smd");
                role.setAttack(60);
                role.setCurrentWeapon(new Attack(-60));

                break;
            default:
                System.out.println("选择错误,请重新输入:");
                System.exit(0);
                break;
        }

    }
    public  void initMonster(){
        monster1.setId("m1");
        monster1.setHP(250);
        monster1.setDescription("霹雳领主");
        monster1.setSkill("靡靡之音");
        monster1.setRoom("雷霆峡谷");
        monster1.setAttack(80);
        monster1.setCurrentWeapon(new Attack(-80));

        monster2.setId("m2");
        monster2.setHP(300);
        monster2.setDescription("幽暗蟹");
        monster2.setSkill("恶魔之怒");
        monster2.setRoom("暗黑基地");
        monster2.setAttack(70);
        monster2.setCurrentWeapon(new Attack(-70));

        monster3.setId("m3");
        monster3.setHP(280);
        monster3.setDescription("火先锋");
        monster3.setSkill("暴击枪");
        monster3.setRoom("维苏威火山");
        monster3.setAttack(60);
        monster3.setCurrentWeapon(new Attack(-60));


        monsterSet.getMonsters().add(monster1);
        monsterSet.getMonsters().add(monster2);
        monsterSet.getMonsters().add(monster3);
    }


    public void play(){
        System.out.println("你选择的角色是：" + this.getHero().getDescription());
        map.Welcome();
        Scanner in = new Scanner(System.in);
        while (true) {
            String command = in.nextLine();
            String[] words = command.split(" ");
            if (words[0].equals("over")) {
                ui.displaybye();
                System.exit(0);
            } else if (words[0].equals("help")) {
                ui.displayHelp();
            } else if (words[0].equals("go")) {
                map.goRoom(words[1]);
            } else if (words[0].equals("chop")) {
                if (this.getMonsterSet().get(words[1]).getHP() <= 0) {
                    System.out.println("boss已死，别打了！！");
                } else {
                    this.getHero().useArticle(this.getHero().getCurrentWeapon(), this.getMonsterSet().get(words[1]));
                    this.getMonsterSet().get(words[1]).useArticle(this.getMonsterSet().get(words[1]).getCurrentWeapon(), this.getHero());
                    ui.showbattle(this, map);
                }
            }else if(words[0].equals("accept")){
                System.out.println("你不屈不挠的精神打动了龙之秘境领主神龙，你获得了它的法宝，攻击力和生命值大幅提高了！！！");
                System.out.println("输入 go east 回到维苏威火山,继续战斗吧！");
                this.getHero().setHP(600);
                this.getHero().setAttack(200);
                this.getHero().setCurrentWeapon(new Attack(-200));
            }
            else {
                ui.displayError();
            }

            ui.displayStaus(this, map);

        }
    }

    public MonsterSet getMonsterSet() {
        return monsterSet;
    }

    public void setMonsterSet(MonsterSet monsterset) {
        this.monsterSet = monsterSet;
    }

    public Person getHero() { return role; }

    public void setHero(Person hero) {
        this.role = role;
    }

    public Monster getMonster1() {
        return monster1;
    }

    public void setMonster1(Monster mhw) {
        this.monster1 = monster1;
    }

    public Monster getMonster2() {
        return monster2;
    }

    public void setMonster2(Monster monster2) {
        this.monster2 = monster2;
    }

    public Monster getMonster3() {
        return monster3;
    }

    public void setMonster3(Monster monster3) {
        this.monster3 = monster3;
    }

    public Monster getMonster4() {
        return monster4;
    }

    public void setMonster4(Monster monster4) {
        this.monster4 = monster4;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}
