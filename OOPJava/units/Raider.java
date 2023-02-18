package units;

import units.Base.BaseHeroes.Warrior;

/**Бандит*/
public class Raider extends Warrior {
    {
        super.speciality = "Бандит";
        super.weapon = "knife";
    }


    public Raider(String name){
        super.name = name;
    }
    
    public Raider(){
        super.name = "Безымянный";
    }
}
