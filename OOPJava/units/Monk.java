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


    public Monk(String name){
        super.name = name;
    }
    
    public Monk(){
        super.name = "Безымянный";
    }

    public boolean heal() {
        if (super.mana >= manaHeal) {
            super.mana -= manaHeal;
            return true;
        }
        return false;
    }

}
