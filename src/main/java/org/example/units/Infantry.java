package org.example.units;

import java.util.ArrayList;

public abstract class Infantry extends BaseHero {
    public Infantry(float hp, int maxHp, int attack, int damageMin, int damageMax, int defense,
                    int initiative, int posX, int posY, String class_name) {
        super(hp, maxHp, attack, damageMin, damageMax, defense, initiative, posX, posY, class_name);

    }

    @Override
    public void step(ArrayList<BaseHero> friends, ArrayList<BaseHero> enemies) {
        if (state.equals("Die") || enemies.isEmpty()) return;
        BaseHero target = enemies.get(findNearest(enemies));
        if (coords.distance(target) < 2) {
            float damage = (target.defense - this.attack)>0
                    ? this.damageMin : (target.defense - this.attack)<0
                    ? this.damageMax : (this.damageMin + this.damageMax)/2;
            target.getDamage(damage);
        } else {
            if (Math.abs(coords.direction(target)[0]) > Math.abs(coords.direction(target)[1]) && (friendOnWay(friends))) {
                coords.posX += Math.signum(coords.direction(target)[0]);
            } else {
                coords.posY += Math.signum(coords.direction(target)[1]);
            }

        }

    }
    public boolean friendOnWay (ArrayList<BaseHero> friends) {
        for (int i = 0; i < friends.size(); i++) {
            if (this.getCoords() == friends.get(i).getCoords()) return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return name +
                "(" + class_name + ")" +
                " \u2665: " + Math.round(hp) +
                " \u26E8:" + defense +
                " \u2694:" + attack +
                " Dmg:" + Math.round(Math.abs((damageMin+damageMax)/2)) +
                " " +
                state;
    }

}
