package units.Base;

import java.util.HashMap;
import java.util.Map;

/**Базовые настройки персонажа*/
public abstract class BaseHero {
    protected Map<String, Integer> weapons = new HashMap();
    {
        weapons.put("fork", 5);
        weapons.put("knife", 7);
        weapons.put("spear", 10);
        weapons.put("hammer", 6);
        weapons.put("staff", 20);
        weapons.put("arbalet", 15);
        weapons.put("rifle", 17);
    }
    protected String heroID;
    /**hp*/
    protected int maxHealth = 100;
    protected int health = 100;
    /**Специализация*/
    protected String speciality;
    /**Выносливость*/
    protected int endurance = 100;
    protected int speed = 300;
    protected String weapon;
    protected int shield = 0;
    /**Уставание*/
    protected int fatigue = 10;
    private boolean alive = true;


    @Override
    public String toString() {
        if (alive) return String.format("[heroID: %4s, speciality: %12s, hp: %3d, damage: %2d, stamina: %3d, speed: %3d]", heroID, speciality, health, weapons.get(weapon), endurance, speed);
        return "Он дохлый";
    }

    /**Функция существует для блокировки перезаписи урона*/
    public int getDamage(){
        endurance -= fatigue;
        if (!alive) return 0;
        return weapons.get(weapon);
    }

    public int getHP() {
        if (!alive) return 0;
        return health;
    }

    /**Функция получения урона. damage - урон атакующего*/
    public void ouch(int damage) {
        this.health -= damage - this.shield;
        if (this.health < 1) alive = false;
    }

    public void healing(boolean manaBurn) {
        if(manaBurn){
            health += 10;
            if (health > maxHealth) health = maxHealth;
        }
        else System.out.println("Маны нет, но вы держитесь");
    }

    public void death(boolean swordOfDamocles) {
        if (swordOfDamocles) alive = false;
    }
}
