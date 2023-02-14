package units;

import units.Base.Mag;

/**Монах*/
public class Monk extends Mag{
    private int manaHeal = 30;
    {
        super.speciality = "Монах";
        super.weapon = "hammer";
    }

    public boolean heal() {
        if (super.mana >= manaHeal) {
            super.mana -= manaHeal;
            return true;
        }
        return false;
    }

}
