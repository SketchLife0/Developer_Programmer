import units.*;
import units.Base.BaseHeroes.BaseHero;
import units.Base.Names;
import units.Base.PlayingField;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**сама игра*/
public class Game {
    public static PlayingField field = new PlayingField();
    public static ArrayList <BaseHero> radiant = createTeam(field, false);
    public static ArrayList <BaseHero> dare = createTeam(field, true);
    public static ArrayList <BaseHero> allTeam = new ArrayList<>(radiant.size() + dare.size());
    public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in);
        System.out.print("Press Enter to begin.");
        user_input.nextLine();
        allTeam.addAll(radiant);
        allTeam.addAll(dare);
        allTeam.sort(null);
        printTeam(allTeam);
        boolean continueGame = true;
        while (continueGame){
            try {
                View.view();
                user_input.nextLine();
                for (BaseHero human: allTeam) {
                    if (radiant.contains(human)) human.step(radiant, dare);
                    else human.step(dare, radiant);
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
                continueGame = false;
                user_input.close();
            }
            
        }

    }

    /**Создаёт команду счогласно указанным параметрам в задаче. dark - отвечает за сторону тьмы*/
    public static ArrayList <BaseHero> createTeam(PlayingField f, boolean dark) {
        int size = 10;
        Random rd = new Random();
        ArrayList <BaseHero> result = new ArrayList<>(size);
        int position = 1;
        for(int i = 0; i < size; i++){
            int key = rd.nextInt(4);
            String name = String.valueOf(Names.values()[rd.nextInt(Names.values().length)]);
            switch (key) {
                case 0:
                    result.add(dark ? new Raider(name, f.getHorizontal(), position) : new Spearman(name, 1, position));
                    break;
                case 1:
                    result.add(dark ? new BlackMag(name, f.getHorizontal(), position) : new Monk(name, 1, position));
                    break;
                case 2:
                    result.add(dark ? new Sniper(name, f.getHorizontal(), position) : new Arbalester(name, 1, position));
                    break;
                default:
                    result.add(dark ? new Villager(name, f.getHorizontal(), position) : new Villager(name, 1, position));
                    break;
            }
            position++;
        }
        return result;
    }

    public static void printTeam(ArrayList<BaseHero> a) {
        for (BaseHero object : a) {
            System.out.println(object);
        }
    }

}