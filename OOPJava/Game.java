import units.*;
import units.Base.BaseHeroes.BaseHero;
import units.Base.Names;
import java.util.ArrayList;
import java.util.Random;

/**сама игра*/
public class Game {
    public static void main(String[] args) {
        int size = 10;
        Random rd = new Random();
        ArrayList <BaseHero> heroes = new ArrayList<>(size);
        for(int i = 0; i < size; i++){
            int key = rd.nextInt(7);
            String name = String.valueOf(Names.values()[rd.nextInt(Names.values().length)]);
            switch (key) {
                case 0:
                    heroes.add(new Arbalester(name));
                    break;
                case 1:
                    heroes.add(new BlackMag(name));
                    break;
                case 2:
                    heroes.add(new Monk(name));
                    break;
                case 3:
                    heroes.add(new Raider(name));
                    break;
                case 4:
                    heroes.add(new Sniper(name));
                    break;
                case 5:
                    heroes.add(new Spearman(name));
                    break;
                default:
                    heroes.add(new Villager(String.valueOf(Names.values()[rd.nextInt(Names.values().length)])));
                    break;
            }
            System.out.println(heroes.get(i));
            System.out.println(heroes.get(i).getInfo());
        }
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
    }
}