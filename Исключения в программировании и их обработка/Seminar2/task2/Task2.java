/*Если необходимо, исправьте данный код
try {
    int d = 0;
    double catchedRes1 = intArray[8] / d;
    System.out.println("catchedRes1 = " + catchedRes1);
} catch (ArithmeticException e) {
    System.out.println("Catching exception: " + e);
}
*/

package task2;

public class Task2 {
    public static void main(String[] args) {
        int [] ar = new int [] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        error(ar);
    }

    public static void error(int [] intArray) {
        try {
            int d = 0;
            // Будь входящее число или d типа double то даже ошибку бы тут не вызывало
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        // Ну или просто Exception :)
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException | NullPointerException e) {
            System.out.println("Catching exception: " + e);
        }
    }
}
