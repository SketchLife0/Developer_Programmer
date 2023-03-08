package units.Base.BaseHeroes;

import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.HashMap;
import units.Base.GameIntarface;
import units.Base.SizeField;

/**Базовые настройки персонажа*/
public abstract class BaseHero extends SizeField implements GameIntarface,  Comparable <BaseHero>{
    protected HashMap<String, Integer> weapons = new HashMap<>();
    {
        weapons.put("fork", 1);
        weapons.put("knife", 8);
        weapons.put("spear", 4);
        weapons.put("hammer", 12);
        weapons.put("staff", 17);
        weapons.put("arbalet", 6);
        weapons.put("rifle", 12);
    }
    protected int damage = 1;
    protected int smallDamage;
    protected int hardDamage;
    protected String weapon = "fork";
    protected int atack = weapons.get(weapon);
    /**Специализация*/ protected String speciality;
    protected String name;
    /**max hp*/ protected int maxHealth = 1;
    /**hp*/ protected int health = maxHealth;
    protected int speed = 3;
    protected int shield = 1;
    /**Место по горизонтали*/ protected int x;
    /**Место по вертикали*/ protected int y;
    /**Живой или нет*/ protected boolean alive = true;
    private static int id = 1;
    private int heroID = id;

    
    public BaseHero(String name, int x, int y){
        this.name = name;
        try {
            if (x > getHorizontal()) throw new Exception("Ошибка: X Выход за пределы");
            else {
                this.x = x;
                if (y > getVertical()) throw new Exception("Ошибка: Y Выход за пределы");
                else {
                    this.y = y;
                    setPoint(getID(), x, y, false);
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        id++;
    }

    public BaseHero(int x, int y){
        this("Никто", x, y);
    }

    @Override
    public String getInfo() {
        return String.format("Я %s, и я %s", name, speciality);
    }

    @Override
    public String toString() {
        if (alive) return String.format("[ID: %2d, name: %5s, Job: %7s, hp: %3d, maxdg:%2d, speed: %2d]", heroID, name, speciality, health, hardDamage, speed);
        return "Он дохлый";
    }

    @Override
    public int compareTo(BaseHero o) {
        if(this.speed > o.speed) return -1;
        if(this.speed < o.speed) return 1;
        return 0;
    }

    /**По врагу*/ 
    public int getDamage(int shieldEnemy){ 
        if(atack > shieldEnemy) return hardDamage;
        else if(atack == shieldEnemy) return damage;
        else return smallDamage; 
        }

    /**По союзнику*/
    public int getDamage() {
        return damage;
    }

    public int getShield() {
        return shield;
    }

    public int getHP() {
        return health;
    }

    public int getMaxHP(){
        return maxHealth;

    }

    public int getSpeed() {
        return this.speed;
    }

    public int getID(){
        return this.heroID;
    }

    public int getX() {
        return x;
    }

    public int getY(){
        return y;
    }

    public ArrayList<Integer> getPosition(){
        ArrayList<Integer> a = new ArrayList<>(2);
        a.add(x);
        a.add(y);
        return a;
    }

    /**Функция получения урона. damage - урон атакующего*/
    public void ouch(int damage) {
        health -= damage;
        if(health > maxHealth) health = maxHealth;
        if(health < 1) death(true);
    }

    public void healing(boolean manaBurn) {
        if(manaBurn){
            health += 10;
            if (health > maxHealth) health = maxHealth;
        }
        else System.out.println("Маны нет, но вы держитесь");
    }

    public void death(boolean swordOfDamocles) {
        if (swordOfDamocles) {
            alive = false;
            damage = 0;
            smallDamage = 0;
            hardDamage = 0;
            maxHealth = 0;
            health = 0;
            speed = 0;
            shield = 0;
            System.out.printf("%d убит\n", getID());
        }
    }

    public void stepX(int step) {
        this.x += step;
    }

    public void stepY(int step) {
        this.y += step;
    }
}
