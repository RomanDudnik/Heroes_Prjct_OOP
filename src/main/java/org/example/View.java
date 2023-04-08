/** Класс сборки визуализации в консоли
 * 2D карта и расстановка на ней персонажей
*/

package org.example;
import org.example.units.BaseHero;
import java.util.Collections;

public class View {
    private static int step = 1;
    private static final int[] l = {0};
    private static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(9, formatDiv("-b"))) + formatDiv("-c");
    private static final String midl10 = formatDiv("d") + String.join("", Collections.nCopies(9, formatDiv("-e"))) + formatDiv("-f");
    private static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(9, formatDiv("-h"))) + formatDiv("-i");
    private static void tabSetter(int count, int max){
        int dif = max - count + 2;
        if (dif>0) System.out.printf("%" + dif + "s", ":\t"); else System.out.print(":\t");
    }
    private static String formatDiv(String str) {
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500');
    }

    // метод заполнения персонажей по позициям с помощью первых букв их звания:
    private static String getChar(int x, int y){
        String out = "| ";
        for (BaseHero unit: Main.allTeam) {
            if (unit.getCoords()[0] == x && unit.getCoords()[1] == y){
                if (unit.getHp() == 0) {
                    out = "|" + (AnsiColors.ANSI_RED + unit.getInfo().charAt(0) + AnsiColors.ANSI_RESET);
                    break;
                }
                if (Main.teamChaos.contains(unit)) out = "|" + (AnsiColors.ANSI_GREEN + unit.getInfo().charAt(0) + AnsiColors.ANSI_RESET);
                if (Main.teamLight.contains(unit)) out = "|" + (AnsiColors.ANSI_BLUE + unit.getInfo().charAt(0) + AnsiColors.ANSI_RESET);
                break;
            }
        }
        return out;
    }
    // метод сборки визуала в консоли:
    public static void view() {
        if (step == 1 ){
            System.out.print(AnsiColors.ANSI_RED + "First step" + AnsiColors.ANSI_RESET);
        } else {
            System.out.print(AnsiColors.ANSI_RED + "Step:" + step + AnsiColors.ANSI_RESET);
        }
        step++;
        Main.allTeam.forEach((v) -> l[0] = Math.max(l[0], v.toString().length()));
        System.out.print("_".repeat(l[0]*2));
        System.out.println("");
        System.out.print(top10 + "    ");
        System.out.print("Blue side");
        //for (int i = 0; i < l[0]-9; i++)
        System.out.print(" ".repeat(l[0]-9));
        System.out.println(":\tGreen side");
        for (int i = 1; i < 11; i++) {
            System.out.print(getChar(1, i));
        }
        System.out.print("|    ");
        System.out.print(Main.teamLight.get(0));
        tabSetter(Main.teamLight.get(0).toString().length(), l[0]);
        System.out.println(Main.teamChaos.get(0));
        System.out.println(midl10);

        for (int i = 2; i < 10; i++) {
            for (int j = 1; j < 11; j++) {
                System.out.print(getChar(i, j));
            }
            System.out.print("|    ");
            System.out.print(Main.teamLight.get(i-1));
            tabSetter(Main.teamLight.get(i-1).toString().length(), l[0]);
            System.out.println(Main.teamChaos.get(i-1));
            System.out.println(midl10);
        }
        for (int j = 1; j < 11; j++) {
            System.out.print(getChar(10, j));
        }
        System.out.print("|    ");
        System.out.print(Main.teamLight.get(9));
        tabSetter(Main.teamLight.get(9).toString().length(), l[0]);
        System.out.println(Main.teamChaos.get(9));
        System.out.println(bottom10);
    }
}