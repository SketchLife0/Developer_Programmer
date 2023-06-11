/*
 * Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение. 
 * Ввод текста вместо числа не должно приводить к падению приложения, 
 * вместо этого, необходимо повторно запросить у пользователя ввод данных.
 */

package task1;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        mirror();
    }

    public static void mirror() {
        Scanner sc = new Scanner(System.in);
        float f = Float.NaN;
        while (Float.isNaN(f)) {
            System.out.print("Введите число типа float: ");
            String line = sc.nextLine();
            try {
                f = Float.parseFloat(line);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        sc.close();
        System.out.println(f);
    }
}
