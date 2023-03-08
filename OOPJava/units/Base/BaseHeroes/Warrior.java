package units.Base.BaseHeroes;

import java.util.ArrayList;
import units.Base.PlayingField;

/**Воин*/
public abstract class Warrior extends BaseHero{
    {
        super.maxHealth = 10;
        super.health = 10;
    }

    protected Warrior(String name, int x, int y){
        super(name, x, y);
    }

    protected Warrior(int x, int y){
        super(x, y);
    }

    @Override
    public void step(ArrayList<BaseHero> allies, ArrayList<BaseHero> enemy, PlayingField map) {
        if (super.alive){
            BaseHero a = filling(getX(), getY(), enemy, false);
            switch (longArm(a, map)) {
                case 1:
                    map.setPoint(0, getX(), getY(), true);
                    map.setPoint(getID(), getX()-1, getY(), false);
                    stepX(-1);
                    System.out.printf("%d сдвиг\n", getID());
                    break;
                
                case 2:
                    map.setPoint(0, getX(), getY(), true);
                    map.setPoint(getID(), getX()+1, getY(), false);
                    stepX(1);
                    System.out.printf("%d сдвиг\n", getID());
                    break;

                case 3:
                    map.setPoint(0, getX(), getY(), true);
                    map.setPoint(getID(), getX(), getY()-1, false);
                    stepY(-1);
                    System.out.printf("%d сдвиг\n", getID());
                    break;

                case 4:
                    map.setPoint(0, getX(), getY(), true);
                    map.setPoint(getID(), getX(), getY()+1, false);
                    stepY(1);
                    System.out.printf("%d сдвиг\n", getID());
                    break;

                case 5:
                    System.out.println(getID() + " бьёт " + a.getID());
                    a.ouch(getDamage(a.getShield()));
                    break;

                default:
                    System.out.printf("%d Меня зажали!\n", getID());
                    break;
            }
            
        }
    }

    private int longArm(BaseHero a, PlayingField map) {
        boolean minusX = false;
        boolean minusY = false;
        int rangeX = getX() - a.getX();
        int rangeY = getY() - a.getY();
        if (rangeX < 0) {
            rangeX *= -1;
            minusX = true;
        }
        if (rangeY < 0) {
            rangeY *= -1;
            minusY = true;
        }
        if (rangeY <= 1 && rangeX <= 1) return 5;
        if (rangeX >= rangeY) {
            if (minusX) {
                if (rangeX > 1 && map.freePoint(getX()+1, getY())) return 2;
            }
            else if (rangeX > 1 && map.freePoint(getX()-1, getY())) return 1;
        }
        else {
            if (minusY) {
                if (rangeY > 1 && map.freePoint(getX(), getY()+1)) return 4;
            }
            else if (rangeY > 1 && map.freePoint(getX(), getY()-1)) return 3;
        }
        return 0;
    }
}
