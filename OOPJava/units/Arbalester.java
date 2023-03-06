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
        super.damage = 3;
        super.smallDamage = 2;
        super.hardDamage = 3;
    }
    

    public Arbalester(String name, int x, int y){
        super(name, x, y);
    }
    
    public Arbalester(int x, int y){
        super(x,y);
    }
}
