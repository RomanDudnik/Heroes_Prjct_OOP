/**
 * Вор (тихий воин)
 */
package org.example.units;

public class Thief extends Infantry {
    int stealthMode;
    public Thief(Vector2D coords) {
        super(70.f, 70, 10, 2, 6, 7,
                7, coords.posX, coords.posY, "Thief");
        stealthMode = 50;
    }

    // реализуем метод интерфеса:
    @Override
    public StringBuilder getInfo() {
        StringBuilder builder = new StringBuilder();
        return builder.append("Thief: \t").append(Thief.super.name)
                .append("\t| ATK:\t").append(Thief.super.attack)
                .append("\t| HP:\t").append(Thief.super.hp)
                .append(" \t|\t\t\t|").append("\t| (X.Y) : ").append(Thief.super.coords.posX).append(".").append(Thief.super.coords.posY);
    }
}