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
        Arbalester hoodwink = new Arbalester("Вася", 2, 5);
        field.showField();
        hoodwink.step(dare);
        printTeam(dare);



        // radiant.sort(null);
        // dare.sort(null);
        // System.out.println("Сортированные Силы Света");
        // printTeam(radiant);
        // System.out.println("Сортированные Силы Тьмы");
        // printTeam(dare);  
        // Iterator<BaseHero> iter1 = radiant.iterator();
        // Iterator<BaseHero> iter2 = dare.iterator();
        // System.out.println();
        // // Вариант через короткую запись но большое количество памяти

        // int maxsize = radiant.size() > dare.size() ? radiant.size() : dare.size();
        // ArrayList <BaseHero> queue = new ArrayList<>(radiant.size() + dare.size());
        // for (int i = 0; i < maxsize; i++) {
        //     if(iter1.hasNext()) queue.add(iter1.next());
        //     if(iter2.hasNext()) queue.add(iter2.next());
        // }
        // printTeam(queue);
        // System.out.println();
        // queue.sort(null);
        // printTeam(queue);
        
        
        // Вариант через сложную запись но меньшее количество памяти

    //     if (radiant.size() == 0) while(iter2.hasNext()) System.out.println(iter2.next());
    //     else if (dare.size() == 0) while(iter1.hasNext()) System.out.println(iter1.next());
    //     else{
    //         int command = 0;
    //         BaseHero a = iter1.next();
    //         BaseHero b = iter2.next();
    //         boolean busy = true;
    //         do {
    //             switch (command) {
    //                 case 0:
    //                     System.out.println(a.getSpeed() > b.getSpeed() ? a : b);
    //                     command = a.getSpeed() > b.getSpeed() ? 2 : 1;
    //                     break;
    //                 default:
    //                     if (command == 1 ? iter2.hasNext() : iter1.hasNext()) {
    //                         if (command == 1) b = iter2.next();
    //                         else a = iter1.next();
    //                         System.out.println(a.getSpeed() > b.getSpeed() ? a : b);
    //                         command = a.getSpeed() > b.getSpeed() ? 2 : 1;
    //                     }
    //                     else {
    //                         System.out.println(command == 1 ? a : b);
    //                         busy = false;
    //                         while (command == 1 ? iter1.hasNext() : iter2.hasNext()) System.out.println(command == 1 ? iter1.next() : iter2.next());
    //                     }
    //                     break;
    //             }    
    //         } while (busy);
    //     }
    

    }
        // // Демонстрация работы

        // Arbalester hoodwink = new Arbalester("Вася", 11, 10);
        // BlackMag warlock = new BlackMag();
        // Monk omniknight = new Monk();
        // Raider riki = new Raider();
        // Sniper sniper = new Sniper();
        // Spearman mars = new Spearman();
        // Villager creep = new Villager();
        // System.out.println(hoodwink.toString());
        // System.out.println(warlock.toString());
        // System.out.println(omniknight.toString());
        // System.out.println(riki.toString());
        // System.out.println(sniper.toString());
        // System.out.println(mars.toString());
        // System.out.println(creep.toString());
        // omniknight.ouch(sniper.getDamage());
        // System.out.println(sniper.toString());
        // System.out.println(omniknight.toString());
        // omniknight.healing(omniknight.heal());
        // System.out.println(omniknight.toString());
        // riki.ouch(warlock.getDamage());
        // riki.ouch(warlock.getDamage());
        // riki.ouch(warlock.getDamage());
        // riki.ouch(warlock.getDamage());
        // riki.death(sniper.assasinate(riki.getHP()));
        // System.out.println(warlock.toString());
        // System.out.println(riki.toString());


    /**Создаёт команду счогласно указанным параметрам в задаче. dark - отвечает за сторону тьмы*/
    public static ArrayList <BaseHero> createTeam(PlayingField f, boolean dark) {
        System.out.println(dark ? "Силы Тьмы" : "Силы Света");
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
            // result.get(i).setPoint(result.get(i).getID(), result.get(i).getX(), result.get(i).getY());;
            // a.setPoint(a.getID(), a.getX(), a.getY());
            position++;
            System.out.println(result.get(i));
        }
        return result;
    }


    public static void printTeam(ArrayList a) {
        for (Object object : a) {
            System.out.println(object);
        }
    }


}