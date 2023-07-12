import java.util.ArrayList;
import java.util.Scanner;

import animals.*;
import animals.basic_animal.Animal;

public class program {
    public static ArrayList <Animal> animals;
    public static ArrayList <Animal> pets;
    public static ArrayList <Animal> pack_animals;

    public static void main(String[] args) {
        System.out.println("Здравствуйте!");
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(
                "Что желаете сделать?\n" + 
                "1 - Добавить новое животное\n" +
                "2 - Посмотреть список команд животного\n" +
                "3 - Обучить животное новым командам\n" +
                "4 - Выход\n"
            );
            String inpuString = sc.nextLine();
            switch (inpuString) {
                case "1":
                    System.out.print("Введите имя животного: ");
                    String a = sc.nextLine();
                    if(isOnlyLetters(a)){
                        //В принципе будь это реальный проект то можно было бы сделать и удаление команд
                        System.out.print("Введите команды через запятую: ");
                    }
                    else
                    break;
                case "2":
                    
                    break;
                case "3":
                    
                    break;
                case "4":
                    
                    break;
                default:
                    break;
            }
        } while (true);
    }
    
    public void add (String n, String b, ArrayList c, String s){
        switch(s){
            case "1":
                Cat cat = new Cat(n, c, b);
                animals.add(cat);
                pets.add(cat);
                break;
            case "2":
                Dog dog = new Dog(n, c, b);
                animals.add(dog);
                pets.add(dog);
                break;
            case "3":
                Hamster hamster = new Hamster(n, c, b);
                animals.add(hamster);
                pets.add(hamster);
                break;
            case "4":
                Horse horse = new Horse(n, c, b);
                animals.add(horse);
                pack_animals.add(horse);
                break;
            case "5":
                Camel camel = new Camel(n, c, b);
                animals.add(camel);
                pack_animals.add(camel);
                break;
            case "6":
                Donkey donkey = new Donkey(n, c, b);
                animals.add(donkey);
                pack_animals.add(donkey);
                break;
        }
    }

    public static boolean isOnlyLetters(String str) {
        return str.matches("[a-zA-Z]+");
    }
}
