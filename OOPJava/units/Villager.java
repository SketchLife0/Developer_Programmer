package units;

import java.util.ArrayList;

import units.Base.BaseHeroes.BaseHero;

/**Селюк*/
public class Villager extends BaseHero{
    {
        super.speciality = "Селюк";
        super.weapon = "fork";
    }
    boolean busy = false;
    private int delivery = 1;


    public Villager(String name, int x, int y){
        super(name, x, y);
    }
    
    public Villager(int x, int y){
        super(x, y);
    }

    public void occupation() {
        busy = true;
    }

    @Override
    public void step(ArrayList<BaseHero> allies, ArrayList<BaseHero> enemy) {
        if (alive) busy = false;
    }

    public boolean getBusy(){
        if (!alive) return true;
        return busy;
    }

}

