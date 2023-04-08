/**
 * Книга заклинаний (для магов)
 * power - сила
 * cost - стоимость
 */
package org.example;

public enum SpellBook {
    // лечение (стоимость, восполнение):
    healOne(1, -1), healFive(2, -5), healTen(3, -10),

    // урон (стоимость, восполнение):
    damageOne(1, 1), damageFive(5, 2), damageTen(10, 3),

    // возрождение погибшего (стоимость, состояние):
    ressurect(25, Float.NaN);       // у float есть состояние NaN -> (0/0) - "ничего" - в данном случае возрождение убитого героя

    private final float power, cost;        //

    SpellBook(int cost, float power) {
        this.cost = cost;
        this.power = power;
    }

    public float getPower() {
        return power;
    }

    public float getCost() {
        return cost;
    }

}

