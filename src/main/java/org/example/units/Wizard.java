/**
 * Маг (волшебник - лечит)
 */
package org.example.units;

public class Wizard extends Mage {
    //    protected ArrayList<Spells> spells_book;
    public Wizard (Vector2D coords) {
        super(50.f, 50, 9, -6, -6, 3,
                4, 5,5, coords.posX, coords.posY, "Wizard");
    }

    // реализуем метод интерфеса:
    @Override
    public StringBuilder getInfo() {
        StringBuilder builder = new StringBuilder();
        return builder.append("Wizard: \t").append(Wizard.super.name)
                .append("\t| ATK:\t").append(Wizard.super.attack)
                .append("\t| HP:\t").append(Wizard.super.hp)
                .append(" \t| MP:\t").append(Wizard.super.mana)
                .append("\t|").append("\t| (X.Y) : ").append(Wizard.super.coords.posX).append(".").append(Wizard.super.coords.posY);
    }
}