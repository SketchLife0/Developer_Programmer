package units;

import units.Base.BaseHeroes.Mag;

/**Маг*/
public class BlackMag extends Mag {
    {
        super.speciality = "Чернокнижник";
        super.weapon = "staff";
        super.shield = 12;
        super.speed = 9;
    }


    public BlackMag(String name){
        super.name = name;
    }
    
    public BlackMag(){
        super.name = "Безымянный";
    }
}
