package units;

import units.Base.BaseHeroes.Warrior;

/**Копейщик*/
public class Spearman extends Warrior{
    {
        super.speciality = "Рыцарь";
        super.weapon = "spear";
        super.shield = 5;
        super.speed = 4;
    }


    public Spearman(String name, int x, int y){
        super.name = name;
        new Spearman(x, y);
    }
    
    public Spearman(int x, int y){
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
