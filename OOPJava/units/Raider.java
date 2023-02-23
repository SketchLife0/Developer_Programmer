package units;

import units.Base.BaseHeroes.Warrior;

/**Бандит*/
public class Raider extends Warrior {
    {
        super.speciality = "Бандит";
        super.weapon = "knife";
        super.shield = 3;
        super.speed = 6;
    }


    public Raider(String name){
        super.name = name;
    }
    
    public Raider(){
        super.name = "Безымянный";
    }
}
