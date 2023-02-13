package units.Base;

/**Базовые настройки персонажа*/
public class BaseHero {
    protected static String heroID;
    /**hp*/
    protected static int health = 100;
    /**Выносливость*/
    protected static int endurance = 100;
    protected static int speed = 300;

    // @Override
    public static void ToString() {
        System.out.printf("[heroID: %s, hp: %d, stamina: %d, speed: %d]", heroID, health, endurance, speed);
        
    }
}
