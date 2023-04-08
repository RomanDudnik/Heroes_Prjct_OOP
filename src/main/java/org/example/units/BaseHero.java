/**
 * Шаблон(класс) для создания базового героя
 * абстрактный класс - нельзя создать экземпляр , но на базе этого шаблона создаются герои
 * поля protected видны/можно вызвать только внутри пакета (*units)
 */
package org.example.units;
import org.example.Names;

import java.util.ArrayList;
import java.util.Random;

public abstract class BaseHero implements GameInterface {
// implements GI обозначаем реализацию интерфеса в этом родительском классе

    protected String name;
    protected String class_name;
    protected float hp, maxHp;
    protected int attack;
    protected int damageMin;
    protected int damageMax;
    protected int defense;
    protected int initiative;
    protected Vector2D coords;
    protected String state;
    protected static int heroCount;

    // переопределение для метода получения информации для героя в визуале консоли:
    @Override
    public  String toString() {
        return  name +
                "(" + class_name + ")" +
                " H:" + Math.round(hp) +
                " D:" + defense +
                " A:" + attack +
                " Dmg:" + Math.round(Math.abs((damageMin + damageMax)/2)) +
                " " + state;
    }
    public int[] getCoords() {return new int[]{coords.posX, coords.posY};}
    protected BaseHero(float hp, int maxHp, int attack, int damageMin,
                       int damageMax, int defense, int initiative, int posX, int posY, String class_name) {
        this.name = getName();
        this.hp = hp;
        this.maxHp = maxHp;
        this.attack = attack;
        this.damageMin = damageMin;
        this.damageMax = damageMax;
        this.defense = defense;
        this.initiative = initiative;
        this.class_name = class_name;
        coords = new Vector2D(posX, posY);
        state = "Stand";
        heroCount++;
    }
    // метод для определения порядка хода тиммейтов:
    public int getInitiative() { return initiative;}
    public float getHp() { return hp;}
    @Override                // переопределение метода
    public void step(ArrayList<BaseHero> team1, ArrayList<BaseHero> team2){}    // заглушки для интерфеса, пока мы им не пользуемся(не реализуем)


    // метод поиска ближайшего противника (по его координатам) :
    public int findNearest(ArrayList<BaseHero> team){
        int index = 0;
        double min = Double.MAX_VALUE;
        for (int i = 0; i < team.size(); i++) {
            if(min > coords.getDistance(team.get(i).coords) && !team.get(i).state.equals("Die")) {
                index = i;
                min = coords.getDistance(team.get(i).coords);
            }
        }
        return index;
    }
    // метод подсчета урона при атаке:
    protected void getDamage(float damage){
        this.hp -= damage;
        if (hp <= 0) {
            hp = 0;
            state = "Die";
        }
        if (hp > maxHp) hp = maxHp;
    }

    // метод из игрового интерфеса для получения информации конкретного героя:
    @Override
    public StringBuilder getInfo() {
        return new StringBuilder("");
    }
    // метод присваивания имени при формировании команд из списка имен enum:
    protected String getName () {
        return Names.values()[new Random().nextInt(Names.values().length)].toString();
    }

}
