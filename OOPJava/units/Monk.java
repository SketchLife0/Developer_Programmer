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
        super.smallDamage = -4;
        super.hardDamage = -4;
    }


    public Monk(String name, int x, int y){
        super(name, x, y);
    }
    
    public Monk(int x, int y){
        super(x, y);
    }

    public boolean heal() {
        if (super.mana >= manaHeal) {
            super.mana -= manaHeal;
            return true;
        }
        return false;
    }

}
