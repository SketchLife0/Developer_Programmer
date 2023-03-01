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
        super.damage = -4;
    }


    public Monk(String name, int x, int y){
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
    
    public Monk(int x, int y){
        this("Безымянный", x, y);
    }

    public boolean heal() {
        if (super.mana >= manaHeal) {
            super.mana -= manaHeal;
            return true;
        }
        return false;
    }

}
