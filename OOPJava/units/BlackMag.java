package units;

import units.Base.BaseHeroes.Mag;

/**Маг*/
public class BlackMag extends Mag {
    {
        super.speciality = "Чернокнижник";
        super.weapon = "staff";
    }


    public BlackMag(String name){
        super.name = name;
    }
    
    public BlackMag(){
        super.name = "Безымянный";
    }
}
