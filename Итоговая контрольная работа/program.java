import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import animals.*;
import animals.basic_animal.Animal;

public class program {
    public static ArrayList <Animal> animals = new ArrayList<>();
    public static ArrayList <Animal> pets = new ArrayList<>();
    public static ArrayList <Animal> pack_animals = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Здравствуйте!");
        Scanner sc = new Scanner(System.in);
        boolean cont = true;
        do {
            System.out.print(
                "Что желаете сделать?\n" + 
                "1 - Добавить новое животное\n" +
                "2 - Посмотреть список команд животного\n" +
                "3 - Обучить животное новым командам\n" +
                "4 - Посмотреть список всех животных\n" +
                "0 - Выход\n"
            );
            String inputString = sc.nextLine();
            switch (inputString) {
                case "1":
                    add(inputName(sc), inputDate(sc), inputComands(sc), sc);
                    break;

                case "2":
                    System.out.println(searchComands(sc));
                    break;

                case "3":
                    int id = searchId(sc);
                    Animal a = searchAnimal(id);
                    if (a != null){
                        ArrayList<String> comands = inputComands(sc);
                        a.addComands(comands);
                    }
                    else System.out.println("Животное с таким id отсутсвует");
                    break;

                case "4":
                    showAllAnimals();
                    break;

                case "0":
                    System.out.println("Прощайте!");
                    sc.close();
                    cont = false;
                    break;

                default:
                    System.out.println("Неккоректный ввод");
                    break;

            }
        } while (cont);
    }
    
    public static void add (String n, String b, ArrayList<String> c, Scanner sc){
        System.out.print("Выберите вид животного:\n" +
                        "1 - Кот\n" +
                        "2 - Собака\n" +
                        "3 - Хомяк\n" +
                        "4 - Лошадь\n" +
                        "5 - Верблюд\n" +
                        "6 - Осёл\n" +
                        "7 - Иное\n");
        String s = sc.nextLine();
        if(!isNumeric(s)) System.out.println("Некорректный ввод!");
        else{
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
                    break;
            }
        }
    }

    public static void showAllAnimals(){
        for (Animal a : animals) {
            System.out.println(a.getInfo());
        }
    }

    public static String searchComands(Scanner sc){
        String result = "";
        int id = searchId(sc);
        Animal an = searchAnimal(id);
        if (an != null){
            for (String comand : an.getComands()) {
                    result += comand + "-";
                }
                return result;
        }
        return "Элемент не найден";
    }

    public static ArrayList<String> inputComands(Scanner sc){
        System.out.println("Введите команды через запятую: ");
        String [] items = sc.nextLine().split(",");
        ArrayList<String> comands = new ArrayList<>();
        for (String string : items) {
            comands.add(string.trim());
        }
        return comands;
    }

    public static String inputName(Scanner sc){
        String name;
        do {
            System.out.print("Введите имя: ");
            name = sc.nextLine().trim();
            if(!name.isEmpty() && isOnlyLetters(name)) {
                return name;
            }
            System.out.println("Некорректный ввод");
        } while(true);
    }

    public static String inputDate(Scanner sc){
        do {
            System.out.print("Введите дату рождения в формате дд-мм-гггг: ");
            String date = sc.nextLine();
            if(isValidDate(date)) {
                return date;
            }
            else System.out.println("Некорректный ввод");
        } while(true);
    }

    public static Animal searchAnimal(int id){
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getID() == id) return animals.get(i);
        }
        return null;
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

    public static boolean isValidDate(String input) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(input);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static int searchId(Scanner sc){
        String b;
        do {
            System.out.print("Введите id животного из общего списка: ");
            b = sc.nextLine();
        } while (!isNumeric(b));
        return Integer.parseInt(b);
    }
}
