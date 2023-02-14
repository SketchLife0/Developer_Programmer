import units.*;

/**сама игра*/
public class Game {
    public static void main(String[] args) {
        Arbalester hoodwink = new Arbalester();
        BlackMag warlock = new BlackMag();
        Monk omniknight = new Monk();
        Raider riki = new Raider();
        Sniper sniper = new Sniper();
        Spearman mars = new Spearman();
        Villager creep = new Villager();
        System.out.println(hoodwink.toString());
        System.out.println(warlock.toString());
        System.out.println(omniknight.toString());
        System.out.println(riki.toString());
        System.out.println(sniper.toString());
        System.out.println(mars.toString());
        System.out.println(creep.toString());
        omniknight.ouch(sniper.getDamage());
        System.out.println(sniper.toString());
        System.out.println(omniknight.toString());
        omniknight.healing(omniknight.heal());
        System.out.println(omniknight.toString());
        riki.ouch(warlock.getDamage());
        riki.ouch(warlock.getDamage());
        riki.ouch(warlock.getDamage());
        riki.ouch(warlock.getDamage());
        riki.death(sniper.assasinate(riki.getHP()));
        System.out.println(warlock.toString());
        System.out.println(riki.toString());
    }
}