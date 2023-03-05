package units;

import units.Base.BaseHeroes.Mag;

/**Маг*/
public class BlackMag extends Mag {
    {
        super.speciality = "Чернокнижник";
        super.weapon = "staff";
        super.shield = 12;
        super.speed = 9;
        super.damage = -5;
    }


    public BlackMag(String name, int x, int y){
        super(name, x, y);
    }
    
    public BlackMag(int x, int y){
        super(x, y);
    }
}
