/**
 * Пользовательский интерфейс
 */
package org.example;
import org.example.units.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Main {
    // задаем кол-во персонажей (для обеих команд одинаковое кол-во):
    public static final int UNITS = 10;
    // три списка для создания команд (1, 2, все(1+2)):
    public static ArrayList<BaseHero> teamLight = new ArrayList<>();
    public static ArrayList<BaseHero> teamChaos = new ArrayList<>();
    public static ArrayList<BaseHero> allTeam = new ArrayList<>();

    public static void main(String[] args) {
        init();                                 // вызываем метод для инициализации персонажей для формирования команд
        Scanner input = new Scanner(System.in);
        while (true){
            allTeam = sortTeam();               // заполняем список персонажами обеих команд с сортировкой по инициативе
            View.view();    // визуал в консоли
            input.nextLine();
            for (BaseHero unit: allTeam) {
                if (teamChaos.contains(unit)) unit.step(teamChaos, teamLight);
                else unit.step(teamLight, teamChaos);
            }
        }
    }

    // метод для рандомного подбора двух команд c расстановкой каждого юнита по координатам
    private static void init() {
        for (int i = 0; i < UNITS; i++) {
            switch (new Random().nextInt(4)) {
                case 0:
                    teamLight.add(new Crossbowman(new Vector2D(i+1, 1)));
                    break;
                case 1:
                    teamLight.add(new Monk(new Vector2D(i+1, 1)));
                    break;
                case 2:
                    teamLight.add(new Spearman(new Vector2D(i+1, 1)));
                    break;
                default:
                    teamLight.add(new Peasant(new Vector2D(i+1, 1)));
            }

            switch (new Random().nextInt(4)) {
                case 0:
                    teamChaos.add(new Sniper(new Vector2D(i+1, 10)));
                    break;
                case 1:
                    teamChaos.add(new Wizard(new Vector2D(i+1, 10)));
                    break;
                case 3:
                    teamChaos.add(new Thief(new Vector2D(i+1, 10)));
                    break;
                default:
                    teamChaos.add(new Peasant(new Vector2D(i+1, 10)));

            }
        }

    }
    // метод сортировки по инициативе, для распределения порядка ходов для персонажей:
    private static ArrayList<BaseHero> sortTeam () {
        ArrayList<BaseHero> list = new ArrayList<>();
        list.addAll(teamLight);
        list.addAll(teamChaos);
        // компоратором определяем очереднось ходов ->
        // порядок больше инициатива и больше здоровье
        list.sort(new Comparator<BaseHero>() {
            @Override
            public int compare(BaseHero t1, BaseHero t2) {
                if (t2.getInitiative() == t1.getInitiative()) {
                    return (int) (t2.getHp() - t1.getHp());
                } else return (int) (t2.getInitiative() - t1.getInitiative());
            }
        });
        return list;
    }

}
