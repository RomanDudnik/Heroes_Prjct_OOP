package org.example.units;

public class Vector2D {
    protected int posX;
    protected int posY;

    public Vector2D(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public float distance (BaseHero enemy) {
        float dx = Math.abs(posX - enemy.coords.posX);
        float dy = Math.abs(posY - enemy.coords.posY);
        return (float) Math.round(Math.sqrt(dx*dx+dy*dy));
    }
    public int [] direction (BaseHero enemy) {
        return new int[]{enemy.coords.posX - this.posX, enemy.coords.posY - this.posY};
    }
}
