package units;

import units.Base.BaseHeroes.Shooter;
import java.util.Random;

/**Снайпер*/
public class Sniper extends Shooter {
    {   
        super.speciality = "Снайпер";
        super.range *= 5;
        super.weapon = "rifle";
        super.shield = 10;
        super.ammunition = 32;
        super.maxHealth = 15;
        super.health = 15;
        super.speed = 9;
    }


    public Sniper(String name){
        super.name = name;
    }
    
    public Sniper(){
        super.name = "Безымянный";
    }

    public boolean assasinate(int VictimHP) {
        Random rb = new Random();
        if(VictimHP <= 34) return rb.nextBoolean();
        return false;
    }
}
