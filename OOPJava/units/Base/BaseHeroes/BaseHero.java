package units.Base.BaseHeroes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import units.Base.GameIntarface;
import units.Base.SizeField;

/**Базовые настройки персонажа*/
public abstract class BaseHero extends SizeField implements GameIntarface,  Comparable <BaseHero>, Iterator{
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
    protected String weapon;
    /**Специализация*/ protected String speciality;
    protected String name;
    /**max hp*/ protected int maxHealth = 1;
    /**hp*/ protected int health = maxHealth;
    /**Выносливость*/ protected int endurance = 100;
    protected int speed = 3;
    protected int shield = 1;
    /**Место по горизонтали*/ protected int x;
    /**Место по вертикали*/ protected int y;
    /**Уставание*/ protected int fatigue = 10;
    /**Живой или нет*/ private boolean alive = true;
    private static int id = 1;
    private int heroID = id;

    
    public BaseHero(){
        id++;
    }

    @Override
    public void step(ArrayList <BaseHero> enemy) {
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


    @Override
    public int compareTo(BaseHero o) {
        if(this.speed > o.speed) return -1;
        if(this.speed < o.speed) return 1;
        return 0;
    }

    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Object next() {
        // TODO Auto-generated method stub
        return null;
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
