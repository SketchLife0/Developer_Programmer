package units.Base.BaseHeroes;

import java.util.ArrayList;

/**Дальник*/
public abstract class Shooter extends BaseHero{
    /**Боеприпасы*/
    protected int ammunition = 16;
    protected int range = 500;


    @Override
    public void step(ArrayList <BaseHero> enemy) {
        if (super.health < 1 || ammunition < 1) System.out.println("Неудачный ход");
        else{
            filling(getX(), getY(), enemy).ouch(getDamage());
        }
    }

    private void searchEnemy(ArrayList <BaseHero> enemy){
        
    }
}
