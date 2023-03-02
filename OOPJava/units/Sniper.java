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
        super.damage = 9;
        super.smallDamage = 8;
        super.hardDamage = 10;
    }


    public Sniper(String name, int x, int y){
        super(name, x, y);
    }
    
    public Sniper(int x, int y){
        super(x, y);
    }

    public boolean assasinate(int VictimHP) {
        Random rb = new Random();
        if(VictimHP <= 34) return rb.nextBoolean();
        return false;
    }
}
