package units;

import units.Base.BaseHeroes.Warrior;

/**Копейщик*/
public class Spearman extends Warrior{
    {
        super.speciality = "Рыцарь";
        super.weapon = "spear";
        super.shield = 5;
        super.speed = 4;
        super.damage = 2;
        super.smallDamage = 1;
        super.hardDamage = 3;
    }


    public Spearman(String name, int x, int y){
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
    
    public Spearman(int x, int y){
        this("Безымянный", x, y);
    }
}
