/*
Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив, 
каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке. 
Если длины массивов не равны, необходимо как-то оповестить пользователя. 
Важно: При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше
 */

package task3;

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(arraysDivision(new double[]{1, 2, 3}, new double []{3, 2, 1})));
    }

    public static double [] arraysDivision (double[] a, double [] b) {
        if (a.length != b.length) throw new RuntimeException("Массивы разной длины");
        double [] result = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            double splitter = b[i];
            if (splitter == 0) throw new RuntimeException("Деление на ноль");
            result[i] = a[i] / b[i];
        }
        return result;
    }
}
