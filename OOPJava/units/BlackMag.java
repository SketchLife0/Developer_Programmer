package units;

import units.Base.BaseHeroes.Mag;

/**Маг*/
public class BlackMag extends Mag {
    {
        super.speciality = "Чернокнижник";
        super.weapon = "staff";
        super.shield = 12;
        super.speed = 9;
    }


    public BlackMag(String name, int x, int y){
        super.name = name;
        new BlackMag(x, y);
    }
    
    public BlackMag(int x, int y){
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
