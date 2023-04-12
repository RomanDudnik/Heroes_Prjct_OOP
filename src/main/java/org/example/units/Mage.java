/**
 * Маг
 */
package org.example.units;

import java.util.ArrayList;

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
