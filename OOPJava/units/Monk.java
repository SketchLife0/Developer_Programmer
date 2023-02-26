package units;

import units.Base.BaseHeroes.Mag;

/**Монах*/
public class Monk extends Mag{
    /**Сколько маны требует лечение*/private int manaHeal = 30;
    {
        super.speciality = "Монах";
        super.weapon = "hammer";
        super.shield = 7;
        super.speed = 5;
    }


    public Monk(String name, int x, int y){
        super.name = name;
        new Monk(x, y);
    }
    
    public Monk(int x, int y){
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

    public boolean heal() {
        if (super.mana >= manaHeal) {
            super.mana -= manaHeal;
            return true;
        }
        return false;
    }

}
