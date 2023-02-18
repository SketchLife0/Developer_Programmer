package units;

import units.Base.BaseHeroes.Warrior;

/**Копейщик*/
public class Spearman extends Warrior{
    {
        super.speciality = "Рыцарь";
        super.weapon = "spear";
    }


    public Spearman(String name){
        super.name = name;
    }
    
    public Spearman(){
        super.name = "Безымянный";
    }
}
