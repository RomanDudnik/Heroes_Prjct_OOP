/**
 * Маг
 */
package org.example.units;

import java.util.ArrayList;

public abstract class Mage extends BaseHero {

    protected int mana;
    protected int maxMana;

    public Mage(float hp, int maxHp, int attack, int damageMin, int damageMax, int defense,
                int speed, int mana, int maxMana, int posX, int posY, String class_name) {
        super(hp, maxHp, attack, damageMin, damageMax, defense, speed, posX, posY, class_name);
        this.mana = mana;
        this.maxMana = maxMana;
    }

    @Override
    public void step(ArrayList<BaseHero> team1, ArrayList<BaseHero> team2) {
        for (BaseHero unit: team1) {
            if (unit.hp < unit.maxHp & !unit.state.equals("Die")) {
                unit.getDamage(damageMax);
                return;
            }
        }
    }
    public void health(){
        System.out.println("Health!");
    }
}
