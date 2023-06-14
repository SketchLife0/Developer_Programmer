/*
Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
ФИО, дата рождения, номер телефона, пол

Форматы данных:
фамилия, имя, отчество - строки
дата рождения - строка формата dd.mm.yyyy
номер телефона - целое беззнаковое число без форматирования
пол - символ латиницей f или m.

    1. Приложение должно проверить введенные данные по количеству. 
Если количество не совпадает с требуемым, вернуть код ошибки, обработать его и показать пользователю сообщение, 
что он ввел меньше или больше данных, чем требуется.

    2. Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. 
Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. 
Можно использовать встроенные типы java или создать свои. 

    3. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.
Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, 
в него в одну строку должны записаться полученные данные, вида:
<Фамилия><Имя><Отчество><дата рождения> <номер телефона><пол>

    4. Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
Не забудьте закрыть соединение с файлом.

    5. При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, 
пользователь должен увидеть стектрейс ошибки.
*/
package Seminar3;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class program {
    private static String surname;
    private static String name;
    private static String patronymic;
    private static int number;
    private static Date birthday;
    private static char gender;
    public static void main(String[] args) {
        while (true) {
            dataEntry();
        }
    }

// Задание поставленно неккоректно. Как можно запросить фио и другие данные чеsрез пробел? Как можно обьяснить программе что из этого фамилия,
// имя и отчество если все данные разделяются пробелом и вводятся в хаотичном порядке. Клиент введет дату, отчество, пол, имя, телефон, фамилия.
// И как в этой какафонии разобрать данные??? 
    public static void dataEntry() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите следующие данные\n" + "ФИО, дата рождения(дд.мм.гггг), номер телефона(без кода страны), пол(f или m)");
        String line = sc.nextLine();
        String[] data = line.split(" ");
        if(sizeСheck(data) && numberCheck(data) && genderCheck(data) && birthdayCheck(data) && nameCheck(data)) dataWrite();
    }

    public static void dataWrite() {
        String filename = surname + ".txt";
        try (FileWriter fw = new FileWriter(filename, true)) {
            String data = "<" + surname + "> " + "<" + name + "> " + "<" + patronymic + "> " + "<" + birthday + "> " + "<" + number + "> " + "<" + gender + ">\n";
            fw.append(data);
            System.out.println("Данные добавлены!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean sizeСheck(String[] data) {
        try {
            if (data.length < 6) throw new RuntimeException("RuntimeException: Слишком мало данных!");
            if (data.length > 6) throw new RuntimeException("RuntimeException: Слишком много данных!");
            return true;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean numberCheck(String[] data) {
        try {
            for (int i = 0; i < data.length; i++) {
                if (isNumeric(data[i])) {
                    if(data[i].length() == 10){
                    program.number = Integer.parseInt(data[i]);
                    return true;
                    }
                    else throw new RuntimeException("RuntimeException: Неверный формат номера телефона!");
                }
            }
            throw new RuntimeException("RuntimeException: Отсутствует номер телефона!");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static boolean genderCheck(String[] data) {
        try {
            for (int i = 0; i < data.length; i++) {
                if (data[i].equals("f") || data[i].equals("m")) {
                    program.gender = data[i].charAt(0);
                    return true;
                }
            }
            throw new RuntimeException("RuntimeException: Отсутствует гендер!");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static boolean birthdayCheck(String[] data) {
        for (int i = 0; i < data.length; i++) {
            if(isDate(data[i])) return true;
        }
        return false;
    }

    public static boolean nameCheck(String[] data) {
        // Нужно для понимания что там только фио
        int fullname = 0;
        for (int i = 0; i < data.length; i++) {
            // Проверка что в имя случайно не зачло гендер
            if (data[i].length() > 1){
                // Проверка что строка состоит только из символов русского и английского алфавитов
                if(data[i].matches("[a-zA-Zа-яА-Я]+")) {
                    // Клиент строго должен ввести сначало фамилию, потом имя, потом отчество
                    if (fullname == 0) program.surname = data[i];
                    else if (fullname == 1) program.name = data[i];
                    else program.patronymic = data[i];
                    fullname += 1;
                }
            }
        }
        if(fullname == 3) return true;
        try {
            throw new RuntimeException("RuntimeException: Имя введено некорректно!");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        // для строгого соответсвия парсинга
        dateFormat.setLenient(false);
        try {
            // TODO: Знаю что так лучше не делать в операциях проверки но нет сил переписывать
            program.birthday = dateFormat.parse(dateString);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
