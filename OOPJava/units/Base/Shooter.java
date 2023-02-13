package units.Base;

/**Дальник*/
public class Shooter extends BaseHero{
    /**Боеприпасы*/
    private int ammunition;

    protected boolean aiming() {
        if (endurance < 100) {
            return false;
        }
        else return true;
    }
}
