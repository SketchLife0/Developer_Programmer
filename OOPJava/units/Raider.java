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
    
    public Raider(int x, int y){
        super.name = "Безымянный";
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
}
