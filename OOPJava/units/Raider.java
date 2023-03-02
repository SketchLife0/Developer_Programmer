package units;

import units.Base.BaseHeroes.Warrior;

/**Бандит*/
public class Raider extends Warrior {
    {
        super.speciality = "Бандит";
        super.weapon = "knife";
        super.shield = 3;
        super.speed = 6;
        super.damage = 3;
        super.smallDamage = 2;
        super.hardDamage = 4;
    }


    public Raider(String name, int x, int y){
        super(name, x, y);
    }
    
    public Raider(int x, int y){
        super(x, y);
    }
}
