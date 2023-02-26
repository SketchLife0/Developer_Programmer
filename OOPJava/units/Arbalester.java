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
    

    public Arbalester(String name, int x, int y){
        super.name = name;
        new Arbalester(x, y);
    }
    
    public Arbalester(int x, int y){
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
}
