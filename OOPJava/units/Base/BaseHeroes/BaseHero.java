package units.Base.BaseHeroes;

import java.util.HashMap;
import units.Base.GameIntarface;

/**Базовые настройки персонажа*/
public abstract class BaseHero implements GameIntarface{
    protected HashMap<String, Integer> weapons = new HashMap<>();
    {
        weapons.put("fork", 5);
        weapons.put("knife", 7);
        weapons.put("spear", 10);
        weapons.put("hammer", 6);
        weapons.put("staff", 20);
        weapons.put("arbalet", 15);
        weapons.put("rifle", 17);
    }
    protected String weapon;
    /**Специализация*/ protected String speciality;
    protected String name;
    /**max hp*/ protected int maxHealth = 100;
    /**hp*/ protected int health = maxHealth;
    /**Выносливость*/ protected int endurance = 100;
    protected int speed = 300;
    protected int shield = 0;
    /**Уставание*/ protected int fatigue = 10;
    /**Живой или нет*/ private boolean alive = true;
    private static int id = 1;
    private int heroID = id;

    
    public BaseHero(){
        id++;
    }

    @Override
    public void step() {
    }

    @Override
    public String getInfo() {
        return String.format("Я %s, и я %s", name, speciality);
    }

    @Override
    public String toString() {
        if (alive) return String.format("[heroID: %4d, name: %10s, speciality: %12s, hp: %3d, damage: %2d, stamina: %3d, speed: %3d]", heroID, name, speciality, health, weapons.get(weapon), endurance, speed);
        return "Он дохлый";
    }

    /**Функция существует для блокировки перезаписи урона*/ 
    public int getDamage(){ 
        if (!alive || fatigue > endurance) return 0; 
        else{ 
            endurance -= fatigue; 
            return weapons.get(weapon); 
        } 
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
