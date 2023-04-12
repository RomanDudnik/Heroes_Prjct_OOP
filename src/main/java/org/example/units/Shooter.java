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
                      int damageMax, int defense, int initiative, int ammo,
                      int accuracy, int posX, int posY, String class_name) {
        super(hp, maxHp, attack, damageMin, damageMax, defense, initiative, posX, posY, class_name);
        this.accuracy = accuracy;
        this.ammo = ammo;
    }

    // Вызов и реализация методов из родительского класса для данного класса Shooter:

    // метод действия/хода персонажа данного класса:
    // условие для реализации - жив и есть стрелы
    // крестьянин занят ammo--, крестьянин в ожидании ammo без изменений
    // если если после выстрела крестьянин был в состоянии Stand, перевести состояние на Busy
    // иначе -1 боеприпас

    @Override
    public void step(ArrayList<BaseHero> friends, ArrayList<BaseHero> enemies) {
        if (state.equals("Die") || ammo == 0) return;
        BaseHero target = enemies.get(findNearest(enemies));
        float damage = (target.defense - attack)>0
                ? damageMin : (defense - attack)<0
                ? damageMax : (damageMin+damageMax)/2;
        target.getDamage(damage);
        for (BaseHero unit: friends) {
            if (unit.getInfo().toString().split(":")[0].equals("Peasant") && unit.state.equals("Stand")) {
                unit.state = "Busy";
                return;
            }
        }
        this.ammo--;
    }

    // переопределение(для данного подкласса) для метода получения информации о герое в визуале консоли:
    @Override
    public String toString() {
        return name +
                "(" + class_name + ")" +
                " \u2665: " + Math.round(hp) +
                " \u26E8:" + defense +
                " \u2694:" + attack +
                " Dmg:" + Math.round(Math.abs((damageMin+damageMax)/2)) +
                " \u27B6:" + ammo + " " +
                state;
    }

}