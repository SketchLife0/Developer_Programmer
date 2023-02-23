package units;

import units.Base.BaseHeroes.Shooter;

/**Арбалетчик*/
public class Arbalester extends Shooter{
    {
        super.speciality = "Стрелок";
        super.weapon = "arbalet";
        super.shield = 3;
        super.maxHealth = 10;
        super.health = 10;
        super.speed = 4;
    }
    

    public Arbalester(String name){
        super.name = name;
    }
    
    public Arbalester(){
        super.name = "Безымянный";
    }
}
