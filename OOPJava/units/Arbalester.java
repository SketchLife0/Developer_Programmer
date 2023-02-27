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
    
    public Arbalester(int x, int y){
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
