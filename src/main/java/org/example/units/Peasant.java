/**
 * Крестьянин (помощь)
 */
package org.example.units;

import java.util.ArrayList;

public class Peasant extends BaseHero {
    int warheads;
    public Peasant(Vector2D coords) {
        super(50.f, 50, 1, 1, 1, 1,
                3, coords.posX, coords.posY, "Peasant");
        warheads = 1;
    }
    // определение состояния объекта(этого подкласса):
    @Override
    public void step(ArrayList<BaseHero> team1, ArrayList<BaseHero> team2) {
        if (!state.equals("Die")) state = "Stand";
    }

    // реализуем метод интерфеса:
    @Override
    public StringBuilder getInfo() {
        StringBuilder builder = new StringBuilder();
        return builder.append("Peasant: \t").append(Peasant.super.name)
                .append("\t| ATK:\t").append(Peasant.super.attack)
                .append("\t| HP:\t").append(Peasant.super.hp)
                .append(" \t| Arrows: ").append(Peasant.this.warheads)
                .append("\t|").append("\t| (X.Y) : ").append(Peasant.super.coords.posX).append(".").append(Peasant.super.coords.posY);
    }
}
