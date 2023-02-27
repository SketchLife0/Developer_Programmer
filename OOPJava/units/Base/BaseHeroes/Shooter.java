package units.Base.BaseHeroes;

import java.util.ArrayList;

import units.Villager;

/**Дальник*/
public abstract class Shooter extends BaseHero{
    /**Боеприпасы*/
    protected int ammunition = 16;
    protected int range = 500;


    @Override
    //*При равноудалённости противников бьёт того кто был создан раньше*/
    public void step(ArrayList <BaseHero> allies, ArrayList <BaseHero> enemy) {
        if (super.health < 1 || ammunition < 1) System.out.println("Неудачный ход");
        else{
            filling(getX(), getY(), enemy).ouch(getDamage());
            if (! searchVillager(allies)) ammunition --;
        }
    }

    public boolean searchVillager(ArrayList <BaseHero> allies){
        boolean result = false;
        for (BaseHero baseHero : allies) {
            if(baseHero instanceof Villager) {
                result = true;
                break;
            }
        }
        return result;
    }
}
