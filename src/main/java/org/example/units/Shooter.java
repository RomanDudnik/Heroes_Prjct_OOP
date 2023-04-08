/**
 * Абстрактный класс 2-ого уровня (для создания стрелков)
 */
package org.example.units;
import java.util.Random;
import java.util.ArrayList;

public abstract class Shooter extends BaseHero {
    int ammo;         // кол-во боеприпасов
    int accuracy;       // точность выстрела

    protected Shooter(float hp, int maxHp, int attack, int damageMin,
                      int damageMax, int defense, int speed, int ammo,
                      int range, int posX, int posY, String class_name) {
        super(hp, maxHp, attack, damageMin, damageMax, defense, speed, posX, posY, class_name);
        this.accuracy = range;
        this.ammo = ammo;
    }

    // Вызов и реализация методов из родительского класса для данного класса Shooter:

    // метод действия/хода персонажа данного класса:
    // условие для реализации - жив и есть стрелы

    @Override
    public void step(ArrayList<BaseHero> team1, ArrayList<BaseHero> team2) {
        if (state.equals("Die") || ammo == 0) return;
        BaseHero target = team2.get(findNearest(team2));
        float damage = (target.defense - attack)>0 ? damageMin : (target.defense - attack)<0 ? damageMax : (damageMin+damageMax)/2;
        target.getDamage(damage);
        for (BaseHero unit: team1) {
            if (unit.getInfo().toString().split(":")[0].equals("Peasant") && unit.state.equals("Stand")) {
                unit.state = "Busy";
                return;
            }
        }
        ammo--;
    }
    // переопределение(для данного подкласса) для метода получения информации для героя в визуале консоли:
    @Override
    public String toString() {
        return name +
                "(" + class_name + ")" +
                " H:" + Math.round(hp) +
                " D:" + defense +
                " A:" + attack +
                " Dmg:" + Math.round(Math.abs((damageMin+damageMax)/2)) +
                " Shots:" + ammo + " " +
                state;
    }

}