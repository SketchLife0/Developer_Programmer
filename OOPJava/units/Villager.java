package units;

import java.util.ArrayList;

import units.Base.BaseHeroes.BaseHero;

/**Селюк*/
public class Villager extends BaseHero{
    {
        super.speciality = "Селюк";
        super.weapon = "fork";
    }
    boolean busy = false;
    private int delivery = 1;


    public Villager(String name, int x, int y){
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
    
    public Villager(int x, int y){
        this("Безымянный", x, y);
    }

    public void occupation() {
        busy = true;
    }

    @Override
    public void step(ArrayList<BaseHero> allies, ArrayList<BaseHero> enemy) {
        if (alive) busy = false;
    }

    public boolean getBusy(){
        if (!alive) return true;
        return busy;
    }

}

