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
                    add();
                    System.out.print("Выберите вид животного:\n" +
                                        "1 - Кот\n" +
                                        "2 - Собака\n" +
                                        "3 - Хомяк\n" +
                                        "4 - Лошадь\n" +
                                        "5 - Верблюд\n" +
                                        "6 - Осёл\n" +
                                        "7 - Иное\n");
                    String vid = sc.nextLine();
                    do {
                        
                    System.out.print("Введите имя животного: ");
                    String a = sc.nextLine();
                    if(isOnlyLetters(a)){
                        //В принципе будь это реальный проект то можно было бы сделать и удаление команд
                        System.out.print("Введите команды через запятую: ");
                    }
                    } while (isOnlyLetters(a));
                    break;
                case "2":
                    System.out.println(searchComands(sc));
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
    
    public void add (String n, String b, ArrayList c){
        Scanner sc = new Scanner(System.in);
        System.out.print("Выберите вид животного:\n" +
                        "1 - Кот\n" +
                        "2 - Собака\n" +
                        "3 - Хомяк\n" +
                        "4 - Лошадь\n" +
                        "5 - Верблюд\n" +
                        "6 - Осёл\n" +
                        "7 - Иное\n");
        String s = sc.nextLine();
        if(isNumeric(s)){
            int number = Integer.parseInt(s);
            if(number > 0 && number < 7)
        }
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
            default: 
                System.out.println("Такое животное отсутсвует. Обратитесь к системному администратору");
        }
    }

    public static String searchComands(Scanner sc){
        String b;
        String result = "";
        do {
            System.out.print("Введите id животного из общего списка: ");
            b = sc.nextLine();
        } while (isNumeric(b));
        int id = Integer.parseInt(b);
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getID() == id){
                for (Animal elem : animals.get(i).getComands()) {
                    result += elem + " ";
                }
                return result;
            }
        }
        return "Элемент не найден";
    }
    
    public static boolean isOnlyLetters(String str) {
        return str.matches("[a-zA-Z]+");
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
