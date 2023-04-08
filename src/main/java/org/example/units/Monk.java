/**
 * Монах
 */
package org.example.units;

public class Monk extends Mage {
    //    protected ArrayList<SpellBook> spells_book;    // книга заклинаний
    public Monk (Vector2D coords) {
        super(50.f, 50, 10, -7, -7, 3,
                7, 5 ,5, coords.posX, coords.posY, "Monk");
    }

    // реализуем метод интерфеса:
    @Override
    public StringBuilder getInfo() {
        StringBuilder builder = new StringBuilder();
        return builder.append("Monk:  \t").append(Monk.super.name)
                .append("\t| ATK:\t").append(Monk.super.attack)
                .append("\t| HP:\t").append(Monk.super.hp)
                .append(" \t| MP:\t").append(Monk.super.mana)
                .append("\t|").append("\t| (X.Y) : ").append(Monk.super.coords.posX).append(".").append(Monk.super.coords.posY);
    }

}
