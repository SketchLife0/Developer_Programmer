/* 
* Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. 
* Пользователю должно показаться сообщение, что пустые строки вводить нельзя. 
* Далее запросить повторный ввод строки
*/

package task4;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Введите строку: ");
            String a = sc.nextLine();
            try {
                if (a.equals("")) throw new Exception();
            } catch (Exception e) {
                System.out.println("Нельзя вводить пустую строку!");
            }
        }
    }
    
}
