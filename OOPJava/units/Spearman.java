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
        super(name, x, y);
    }
    
    public Spearman(int x, int y){
        super(x, y);
    }
}
