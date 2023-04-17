/**
 * Маг
 */
package org.example.units;

import java.util.ArrayList;
import java.util.Random;

public abstract class Mage extends BaseHero {

    protected int mana;
    protected int maxMana;

    public Mage(float hp, int maxHp, int attack, int damageMin, int damageMax, int defense,
                int initiative, int mana, int maxMana, int posX, int posY, String class_name) {
        super(hp, maxHp, attack, damageMin, damageMax, defense, initiative, posX, posY, class_name);
        this.mana = mana;
        this.maxMana = maxMana;
    }

    @Override
    public void step(ArrayList<BaseHero> friends, ArrayList<BaseHero> enemies) {
        for (BaseHero unit: friends) {
            if (unit.hp < unit.maxHp & !unit.state.equals("Die") & mana > 0) {
                int health = (int) unit.hp;
                Random r = new Random();
                unit.getHealth(r.nextInt((int) unit.hp, (int) unit.maxHp));
                if (unit.hp > unit.maxHp)
                    unit.hp = unit.maxHp;
                mana -= 1;
                return;
            }
        }
    }
    @Override
    public String toString() {
        return name +
                "(" + class_name + ")" +
                " \u2665: " + Math.round(hp) +
                " \u26E8:" + defense +
                " \u2694:" + attack +
                " Dmg:" + Math.round(Math.abs((damageMin+damageMax)/2)) +
                " Mna:" + mana + " " +
                state;
    }
    public void health(){
        System.out.println("Health!");
    }
}
