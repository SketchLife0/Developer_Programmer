package units.Base;

/**Волшебник*/
public class Mag extends BaseHero {
    private int mana = 200;
    {super.health = health / 100 * 80;}

    @Override
    public String toString() {
        return String.format("[heroID: %s, hp: %d, stamina: %d, speed: %d, mp:%d]", heroID, health, endurance, speed, mana);
    }
}
    

