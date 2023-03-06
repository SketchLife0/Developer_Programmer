package units.Base.BaseHeroes;

import java.util.ArrayList;

import units.Villager;

/**Дальник*/
public abstract class Shooter extends BaseHero{
    /**Боеприпасы*/
    protected int ammunition = 16;
    protected int range = 500;

    protected Shooter(String name, int x, int y){
        super(name, x, y);
    }

    protected Shooter(int x, int y){
        super(x, y);
    }


    @Override
    //*При равноудалённости противников бьёт того кто был создан раньше*/
    public void step(ArrayList <BaseHero> allies, ArrayList <BaseHero> enemy) {
        if (super.alive && ammunition > 0){
            BaseHero a = filling(getX(), getY(), enemy);
            a.ouch(getDamage(a.getShield()));
            if (!searchVillager(allies)) ammunition --;
            System.out.println(getID() + " бьёт " + a.getID());
        }
    }

    public boolean searchVillager(ArrayList <BaseHero> allies){
        for (BaseHero baseHero : allies) {
            if (baseHero instanceof Villager) {
                Villager farmer = (Villager) baseHero;
                if (!farmer.getBusy()) {
                    farmer.occupation();
                    return true;
                }
            }
        }
        return false;
    }
}
