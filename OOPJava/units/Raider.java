package units;

import units.Base.BaseHeroes.Warrior;

/**Бандит*/
public class Raider extends Warrior {
    {
        super.speciality = "Бандит";
        super.weapon = "knife";
        super.shield = 3;
        super.speed = 6;
    }


    public Raider(String name, int x, int y){
        super.name = name;
        new Raider(x, y);
    }
    
    public Raider(int x, int y){
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
