import units.*;
import units.Base.BaseHeroes.BaseHero;
import units.Base.Names;
import units.Base.PlayingField;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

/**сама игра*/
public class Game {
    public static void main(String[] args) {
        PlayingField field = new PlayingField();
        ArrayList <BaseHero> radiant = createTeam(field, false);
        ArrayList <BaseHero> dare = createTeam(field, true);
        field.showField();
        radiant.sort(null);
        dare.sort(null);
        Iterator<BaseHero> iter1 = radiant.iterator();
        Iterator<BaseHero> iter2 = dare.iterator();
        // // Вариант через короткую запись но большое количество памяти

        // int maxsize = radiant.size() > dare.size() ? radiant.size() : dare.size();
        // ArrayList <BaseHero> queue = new ArrayList<>(radiant.size() + dare.size());
        // for (int i = 0; i < maxsize; i++) {
        //     if(iter1.hasNext()) queue.add(iter1.next());
        //     if(iter2.hasNext()) queue.add(iter2.next());
        // }
        // queue.sort(null);
        // printTeam(queue);
        
        
        // Вариант через сложную запись но меньшее количество памяти

        // if (radiant.size() == 0) while(iter2.hasNext()) System.out.println(iter2.next());
        // else if (dare.size() == 0) while(iter1.hasNext()) System.out.println(iter1.next());
        // else{
        //     int command = 0;
        //     BaseHero a = iter1.next();
        //     BaseHero b = iter2.next();
        //     boolean busy = true;
        //     do {
        //         switch (command) {
        //             case 0:
        //                 System.out.println(a.getSpeed() > b.getSpeed() ? a : b);
        //                 command = a.getSpeed() > b.getSpeed() ? 2 : 1;
        //                 break;
        //             default:
        //                 if (command == 1 ? iter2.hasNext() : iter1.hasNext()) {
        //                     if (command == 1) b = iter2.next();
        //                     else a = iter1.next();
        //                     System.out.println(a.getSpeed() > b.getSpeed() ? a : b);
        //                     command = a.getSpeed() > b.getSpeed() ? 2 : 1;
        //                 }
        //                 else {
        //                     System.out.println(command == 1 ? a : b);
        //                     busy = false;
        //                     while (command == 1 ? iter1.hasNext() : iter2.hasNext()) System.out.println(command == 1 ? iter1.next() : iter2.next());
        //                 }
        //                 break;
        //         }    
        //     } while (busy);
        // }
    

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

    public static void printTeam(ArrayList a) {
        for (Object object : a) {
            System.out.println(object);
        }
    }

}