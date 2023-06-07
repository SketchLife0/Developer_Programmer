// Реализуйте 3 метода, чтобы в каждом из них получить разные исключения

package task1;

public class Task1 {
    public static void main(String[] args) {
        // System.out.println(zeroing(3, 0));
        // System.out.println(indexBeyondRubicon(new int[]{3, 2, 4}, 3));
        // int[] a = open(-1);
    }

    /**
     * Деление без остатка.
     * ArithmeticException при делении на ноль
     * @param a - Делимое
     * @param b - Делитель
     * @return
     */
    public static int zeroing(int a, int b) {
        return a / b;
    }

    /**
     * Выдаёт элемент массива по индексу.
     * ArrayIndexOutOfBoundsException при индексе за пределами массива
     * @param a int[]
     * @param i индекс
     * @return
     */
    public static int indexBeyondRubicon(int[]a, int i) {
        return a[i];
    }

    /**
     * Создаёт массив чисел.
     * NegativeArraySizeException при размере массива < 0
     * @param size - меньше 0
     * @return int[]
     */
    public static int[] open(int size) {
        return new int [size];
    }
}
