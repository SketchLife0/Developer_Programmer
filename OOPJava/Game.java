import units.*;
import units.Base.BaseHeroes.BaseHero;
import units.Base.Names;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**сама игра*/
public class Game {
    public static void main(String[] args) {
        ArrayList <BaseHero> radiant = createTeam(false);
        ArrayList <BaseHero> dare = createTeam(true);
        radiant.sort(null);
        dare.sort(null);
        System.out.println("Сортированные Силы Света");
        printTeam(radiant);
        System.out.println("Сортированные Силы Тьмы");
        printTeam(dare);  
        Iterator<BaseHero> iter1 = radiant.iterator();
        Iterator<BaseHero> iter2 = dare.iterator();
        System.out.println();
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

        if (radiant.size() == 0) while(iter2.hasNext()) System.out.println(iter2.next());
        else if (dare.size() == 0) while(iter1.hasNext()) System.out.println(iter1.next());
        else{
            int command = 0;
            BaseHero a = iter1.next();
            BaseHero b = iter2.next();
            do {
                if (command == 0){
                    System.out.println(a.getSpeed() > b.getSpeed() ? a : b);
                    command = a.getSpeed() > b.getSpeed() ? 2 : 1;
                }
                else if (command == 1){
                    if (iter2.hasNext()) {
                        b = iter2.next();
                        System.out.println(a.getSpeed() > b.getSpeed() ? a : b);
                        command = a.getSpeed() > b.getSpeed() ? 2 : 1;
                    }
                    else {
                        System.out.println(a);
                        command = 0;
                        while (iter1.hasNext()) {
                            System.out.println(iter1.next());
                        }
                    }
                }
                else{
                    if (iter1.hasNext()) {
                        a = iter1.next();
                        System.out.println(a.getSpeed() > b.getSpeed() ? a : b);
                        command = a.getSpeed() > b.getSpeed() ? 2 : 1;
                    }
                    else{
                        System.out.println(b);
                        command = 0;
                        while (iter2.hasNext()) {
                            System.out.println(iter2.next());
                        }
                    }
                }
            } while (iter1.hasNext() || iter2.hasNext() || command != 0);
        }
    }
        // // Демонстрация работы

        // Arbalester hoodwink = new Arbalester();
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
    public static ArrayList <BaseHero> createTeam(boolean dark) {
        System.out.println(dark ? "Силы Тьмы" : "Силы Света");
        int size = 10;
        Random rd = new Random();
        ArrayList <BaseHero> result = new ArrayList<>(size);
        for(int i = 0; i < size; i++){
            int key = rd.nextInt(4);
            String name = String.valueOf(Names.values()[rd.nextInt(Names.values().length)]);
            switch (key) {
                case 0:
                    result.add(dark ? new Raider(name) : new Spearman(name));
                    break;
                case 1:
                    result.add(dark ? new BlackMag(name) : new Monk(name));
                    break;
                case 2:
                    result.add(dark ? new Sniper(name) : new Arbalester(name));
                    break;
                default:
                    result.add(new Villager(name));
                    break;
            }
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