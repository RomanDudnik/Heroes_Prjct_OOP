/**
 * Копейщик (ближний бой)
 */
package org.example.units;

public class Spearman extends BaseHero {
    protected  int death_blow;
    public Spearman(Vector2D coords) {
        super(70.f, 70, 10, 2, 4, 10,
                6, coords.posX, coords.posY, "Spearman");
        death_blow = 1;
    }

    // реализуем метод интерфеса:
    @Override
    public StringBuilder getInfo() {
        StringBuilder builder = new StringBuilder();
        return builder.append("Spearman:\t").append(Spearman.super.name)
                .append("\t| ATK:\t").append(Spearman.super.attack)
                .append("\t| HP:\t").append(Spearman.super.hp)
                .append(" \t|\t\t\t|").append("\t| (X.Y) : ").append(Spearman.super.coords.posX).append(".").append(Spearman.super.coords.posY);
    }
}