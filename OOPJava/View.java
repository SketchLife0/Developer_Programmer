
import units.Base.BaseHeroes.BaseHero;
import java.util.Collections;


public class View {
    private static int step = 1;
    private static final int[] l = {0};
    private static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(9, formatDiv("--b"))) + formatDiv("--c");
    private static final String midl10 = formatDiv("d") + String.join("", Collections.nCopies(9, formatDiv("--e"))) + formatDiv("--f") +" ".repeat(73) + "|";
    private static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(9, formatDiv("--h"))) + formatDiv("--i");
   
    private static void tabSetter(int cnt, int max){
        int dif = max - cnt + 2;
        if (dif>0) System.out.printf("%" + dif + "s", "\t|\t"); else System.out.print("\t|\t");
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

    private static String getChar(int x, int y){
        String out = "|  ";
        for (BaseHero human: Game.allTeam) {
            if (human.getX() == x && human.getY() == y){
                if (human.getHP() == 0) {
                    out = "|" + (String) String.format("%11s", (AnsiColors.ANSI_RED + human.getID() + AnsiColors.ANSI_RESET));
                    return out;
                }
                if (Game.dare.contains(human)) out = "|" + String.format("%11s", (AnsiColors.ANSI_GREEN + human.getID() + AnsiColors.ANSI_RESET));
                if (Game.radiant.contains(human)) out = "|" + String.format("%11s", (AnsiColors.ANSI_BLUE + human.getID() + AnsiColors.ANSI_RESET));
                return out;
            }
        }
        return out;
    }

    public static void view() {
        System.out.print(AnsiColors.ANSI_RED + "Step:" + step + AnsiColors.ANSI_RESET);
        step++;
        Game.allTeam.forEach((v) -> l[0] = Math.max(l[0], v.toString().length()));
        System.out.print("_".repeat(l[0]*2) + "\n");
        System.out.print(top10 + "    ");
        System.out.print(AnsiColors.ANSI_BLUE + "Blue side" + AnsiColors.ANSI_RESET);
        System.out.print(" ".repeat(l[0]-9));
        System.out.println("\t|\t" + AnsiColors.ANSI_GREEN + "Green side" + AnsiColors.ANSI_RESET);
        for (int i = 1; i < 11; i++) {
            System.out.print(getChar(1, i));
        }
        System.out.print("|    ");
        System.out.print(Game.radiant.get(0));
        tabSetter(Game.radiant.get(0).toString().length(), l[0]);
        System.out.println(Game.dare.get(0));
        System.out.println(midl10);

        for (int i = 2; i < 10; i++) {
            for (int j = 1; j < 11; j++) {
                System.out.print(getChar(i, j));
            }
            System.out.print("|    ");
            System.out.print(Game.radiant.get(i-1));
            tabSetter(Game.radiant.get(i-1).toString().length(), l[0]);
            System.out.println(Game.dare.get(i-1));
            System.out.println(midl10);
        }
        for (int j = 1; j < 11; j++) {
            System.out.print(getChar(10, j));
        }
        System.out.print("|    ");
        System.out.print(Game.radiant.get(9));
        tabSetter(Game.radiant.get(9).toString().length(), l[0]);
        System.out.println(Game.dare.get(9));
        System.out.println(bottom10);
    }
}