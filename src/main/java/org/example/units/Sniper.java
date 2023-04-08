
/**
 * Снайпер (дльние позиции)
 */
package org.example.units;

public class Sniper extends Shooter {

    public Sniper (Vector2D coords) {

        super(60.f, 60, 10, 3, 5, 3,
                9, 22, 10, coords.posX, coords.posY, "Sniper");
    }

    // реализуем метод интерфеса:
    @Override
    public StringBuilder getInfo() {

        StringBuilder builder = new StringBuilder();
        return builder.append("Sniper:\t").append(Sniper.super.name)
                .append("\t| ATK:\t").append(Sniper.super.attack)
                .append("\t| HP:\t").append(Sniper.super.hp)
                .append(" \t| Arrows:").append(Sniper.super.ammo)
                .append("\t|").append("\t| (X.Y) : ").append(Sniper.super.coords.posX).append(".").append(Sniper.super.coords.posY);
    }
}