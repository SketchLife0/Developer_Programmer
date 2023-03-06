package units.Base.BaseHeroes;

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
}
