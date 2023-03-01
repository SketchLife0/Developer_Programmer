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
        super.name = name;
        try {
            if (x > getHorizontal()) throw new Exception("Ошибка: X Выход за пределы");
            else {
                super.x = x;
                if (y > getVertical()) throw new Exception("Ошибка: Y Выход за пределы");
                else {
                    super.y = y;
                    setPoint(getID(), x, y);
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public Sniper(int x, int y){
        this("Безымянный", x, y);
    }

    public boolean assasinate(int VictimHP) {
        Random rb = new Random();
        if(VictimHP <= 34) return rb.nextBoolean();
        return false;
    }
}
