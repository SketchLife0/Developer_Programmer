package units;

import units.Base.BaseHeroes.BaseHero;

/**Селюк*/
public class Villager extends BaseHero{
    {
        super.speciality = "Селюк";
        super.weapon = "fork";
    }
    private int seeds;


    public Villager(String name){
        super.name = name;
    }
    
    public Villager(){
        super.name = "Безымянный";
    }
}
