package units.Base.BaseHeroes;

import java.util.ArrayList;

/**Воин*/
public abstract class Warrior extends BaseHero{
    {
        super.maxHealth = 10;
        super.health = 10;
    }

    protected Warrior(String name, int x, int y){
        super(name, x, y);
    }

    protected Warrior(int x, int y){
        super(x, y);
    }

    @Override
    public void step(ArrayList<BaseHero> allies, ArrayList<BaseHero> enemy) {
        if (super.alive){
            BaseHero a = filling(getX(), getY(), enemy, false);
            a.ouch(getDamage(a.getShield()));
            System.out.println(getID() + " бьёт " + a.getID());
        }
    }
}
