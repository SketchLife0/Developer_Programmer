package units.Base;

/**Волшебник*/
public abstract class Mag extends BaseHero {
    protected int mana = 200;
    {super.weapon = "staff";
    super.health = health / 100 * 80;
    super.fatigue = 15;
    }
}
