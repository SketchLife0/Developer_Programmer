package units.Base.BaseHeroes;

import java.util.ArrayList;
import units.Base.PlayingField;

/**Волшебник*/
public abstract class Mag extends BaseHero {
    protected int mana = 200;
    {
        super.maxHealth = 30;
        super.health = 30;
    }

    protected Mag(String name, int x, int y){
        super(name, x, y);
    }

    protected Mag(int x, int y){
        super(x, y);
    }

    @Override
    public void step(ArrayList<BaseHero> allies, ArrayList<BaseHero> enemy, PlayingField map) {
        if (alive) {
            double minPercent = 100.0;
            BaseHero hero = allies.get(0);
            boolean initialized = false;
            for (BaseHero baseHero : allies) {
                double percent = (double) baseHero.getHP() / ((double) baseHero.getMaxHP() / 100.0);
                if(percent < minPercent) {
                    minPercent = percent;
                    hero = baseHero;
                    if (!initialized) initialized = true;
                }
            }
            if (initialized) {
                hero.ouch(getDamage());
                System.out.printf("%d хилит %d\n", getID(), hero.getID());
            }
        }
    }
}
