package animals.basic_animal;

import java.util.ArrayList;

public abstract class Animal {
    private static int id;
    private int animalId = id;
    private String name;
    private ArrayList comands;
    private String birthday;
    private String specie;

    /**
     * @param n - Name
     * @param c - Comands
     * @param b - Birthday
     * @param s - Specie
    */
    public Animal(String n, ArrayList c, String b, String s){
        name = n;
        comands = c;
        birthday = b;
        specie = s;
    }
}
