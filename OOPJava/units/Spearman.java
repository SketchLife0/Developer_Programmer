package units;

import units.Base.BaseHeroes.Warrior;

/**Копейщик*/
public class Spearman extends Warrior{
    {
        super.speciality = "Рыцарь";
        super.weapon = "spear";
        super.shield = 5;
        super.speed = 4;
    }


    public Spearman(String name){
        super.name = name;
    }
    
    public Spearman(){
        super.name = "Безымянный";
    }
}
