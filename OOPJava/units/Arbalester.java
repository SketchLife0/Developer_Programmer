package units;

import units.Base.BaseHeroes.Shooter;

/**Арбалетчик*/
public class Arbalester extends Shooter{
    {
        super.speciality = "Стрелок";
        super.weapon = "arbalet";
    }
    

    public Arbalester(String name){
        super.name = name;
    }
    
    public Arbalester(){
        super.name = "Безымянный";
    }
}
