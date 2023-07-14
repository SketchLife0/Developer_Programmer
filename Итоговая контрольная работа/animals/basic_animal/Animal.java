package animals.basic_animal;

import java.util.ArrayList;

public abstract class Animal {
    private static int id;
    private int animalId = id;
    private String name;
    private ArrayList<String> comands;
    private String birthday;
    private String specie;

    /**
     * @param n - Name
     * @param c - Comands
     * @param b - Birthday
     * @param s - Specie
    */
    public Animal(String n, ArrayList<String> c, String b, String s){
        name = n;
        comands = c;
        birthday = b;
        specie = s;
    }

    public int getID(){
        return animalId;
    }

    public ArrayList<String> getComands(){
        return comands;
    }

    public String getName(){
        return name;
    }

    public String getBirthday(){
        return birthday;
    }

    public String getSpecie(){
        return specie;
    }

    public String getInfo(){
        return id + " " + specie + " " + name + " " + birthday;
    }

    public void addComands(ArrayList<String> com){
        for (String string : com) {
            comands.add(string);
        }
    }
}
