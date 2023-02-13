package units.Base;

/**Базовые настройки персонажа*/
public class BaseHero {
    protected static String heroID;
    /**hp*/
    protected int health = 100;
    /**Выносливость*/
    protected int endurance = 100;
    protected int speed = 300;

    @Override
    public String toString() {
        return String.format("[heroID: %s, hp: %d, stamina: %d, speed: %d]", heroID, health, endurance, speed);
    }
}
