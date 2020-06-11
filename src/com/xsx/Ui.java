package com.xsx;

public class Ui {
    public void display1(Scence scence) {
        System.out.println("------------------------------------------");
        System.out.println("龙星，HP：300，技能：烈焰冲撞，伤害：50");
        System.out.println("小桃，HP：320，技能：天使之吻，伤害：40");
        System.out.println("奥多，HP：250，技能：审判之石，伤害：60");
        System.out.println("------------------------------------------");

        System.out.println("地图:");
        System.out.println("龙之秘境————————维苏威火山     暗黑基地");
        System.out.println("                  |           |");
        System.out.println("                  |           |");
        System.out.println("威廉古堡—————————神秘岛————————雷霆峡谷");
    }

    public void displayStaus(Scence scence, Map map) {
        System.out.println(scence.getHero().getDescription() + ":" + scence.getHero().getHP());
        if (map.currentRoom.description.equals("龙之秘境")) {
            if (scence.getHero().getHP() <= 270 ) {
                System.out.println("龙之秘境领主神龙说：“你很刻苦努力，让我助你一臂之力吧！”");
                System.out.println("请输入 accept 获得神龙的帮助");
            }
        } else {
            for (Monster item : scence.getMonsterSet().getMonsters()) {
                if (item.getRoom().equals(map.currentRoom.description)){
                    System.out.println("地图:");
                    System.out.println("龙之秘境————————维苏威火山     暗黑基地");
                    System.out.println("                  |           |");
                    System.out.println("                  |           |");
                    System.out.println("威廉古堡—————————神秘岛————————雷霆峡谷");
                    System.out.println("你当前在" + item.getRoom() + "，这里的boss是" + item.getDescription() + "(" + item.getId() + ")" + "  HP:" + item.getHP());
            }
            }
            System.out.println();
            System.out.println("------------------------------------------");
        }
    }

    public void displaybye() {
        System.out.println("山水有相逢，下次来玩！");
        System.exit(0);
    }
    public void displayHelp() {
        System.out.println("3个指令选择:①chop(chop monster) ②over ③help");
    }

    public void displayError() { System.out.println("无效指令,请重新输入，或者输入help查看帮助:"); }

    public void showbattle(Scence scence, Map map) {
        if (scence.getHero().getHP() <= 0) {
            System.out.println("你失败了！不过不要气馁！快要坚持不住的时候请在地图里寻找高人指点吧！继续战斗！");
            System.exit(0);
        }
        for (Monster item : scence.getMonsterSet().getMonsters()) {
            if (item.getRoom().equals(map.currentRoom.description)) {
                System.out.println(scence.getHero().getDescription() + "使用技能" + "'" + scence.getHero().getSkill() + "'" + "对" + item.getDescription() + "造成了" + scence.getHero().getAttack() + "点伤害");
                System.out.println(item.getDescription() + "使用技能" + "'" + item.getSkill() + "'" + "对" + scence.getHero().getDescription() + "造成了" + item.getAttack() + "点伤害");
                if (item.getHP() <= 0) {
                    item.setHP(0);
                    item.setAttack(0);
                    System.out.println("------------------------------------------");
                    System.out.println(item.getDescription() + "已被你打败！" + ",恭喜你获得" + item.getDescription()+ "的徽章！！");
                }
            }
        }
        for (Monster item : scence.getMonsterSet().getMonsters()) {
            if (scence.getMonster1().getHP() == 0 && scence.getMonster2().getHP() == 0 && scence.getMonster3().getHP() == 0) {
                System.out.println("恭喜你获得所有徽章，你已成为洛克王国的正式魔法师!!!(๑•̀ㅂ•́)و✧");
                System.exit(0);
            }
        }
    }
}
