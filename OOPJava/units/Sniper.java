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


    public Sniper(String name, int x, int y){
        super.name = name;
        new Sniper(x, y);
    }
    
    public Sniper(int x, int y){
        if (super.name == null) super.name = "Безымянный";
        try {
            if (x > GetX()) throw new Exception("Ошибка: Выход за пределы");
            else super.x = x;
            if (y > GetY()) throw new Exception("Ошибка: Выход за пределы");
            else super.y = y;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public boolean assasinate(int VictimHP) {
        Random rb = new Random();
        if(VictimHP <= 34) return rb.nextBoolean();
        return false;
    }
}
