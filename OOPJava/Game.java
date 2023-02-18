import units.*;
import units.Base.BaseHeroes.BaseHero;
import units.Base.Names;
import java.util.ArrayList;
import java.util.Random;

/**сама игра*/
public class Game {
    public static void main(String[] args) {
        Random rd = new Random();
        int size = 10;
        ArrayList <BaseHero> heroes = new ArrayList<>(size);
        for(int i = 0; i < size; i++){
            int key = rd.nextInt(7);
            switch (key) {
                case 0:
                    heroes.add(new Arbalester(String.valueOf(Names.values()[rd.nextInt(Names.values().length)])));
                    break;
                case 1:
                    heroes.add(new BlackMag(String.valueOf(Names.values()[rd.nextInt(Names.values().length)])));
                    break;
                case 2:
                    heroes.add(new Monk(String.valueOf(Names.values()[rd.nextInt(Names.values().length)])));
                    break;
                case 3:
                    heroes.add(new Raider(String.valueOf(Names.values()[rd.nextInt(Names.values().length)])));
                    break;
                case 4:
                    heroes.add(new Sniper(String.valueOf(Names.values()[rd.nextInt(Names.values().length)])));
                    break;
                case 5:
                    heroes.add(new Spearman(String.valueOf(Names.values()[rd.nextInt(Names.values().length)])));
                    break;
                default:
                    heroes.add(new Villager(String.valueOf(Names.values()[rd.nextInt(Names.values().length)])));
                    break;
            }
        }
        for (BaseHero baseHero : heroes) {
            System.out.println(baseHero.toString());
        }

        for (BaseHero baseHero : heroes) {
            System.out.println(baseHero.getInfo());
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