package units;

import units.Base.BaseHeroes.BaseHero;

/**Селюк*/
public class Villager extends BaseHero{
    {
        super.speciality = "Селюк";
        super.weapon = "fork";
    }
    private int delivery = 1;


    public Villager(String name, int x, int y){
        super.name = name;
        new Villager(x, y);
    }
    
    public Villager(int x, int y){
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

