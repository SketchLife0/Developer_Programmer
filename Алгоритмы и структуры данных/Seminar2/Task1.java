import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        int[] abc = {4, 6, 1, 0, 9, 3, 10, 2, 5, 7, 8};
        System.out.println(Arrays.toString(abc));

        sort(abc);
        System.out.println(Arrays.toString(abc));
    }

    public static void sort(int[] array) {
        // Построение max-кучи
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, array.length, i);
        }
        
        // Перестройка кучи и сортировка
        for (int i = array.length - 1; i >= 0; i--) {
            int buffer = array[0];
            array[0] = array[i];
            array[i] = buffer;
            
            heapify(array, i, 0);
        }
    }
    
    private static void heapify(int[] array, int n, int i) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        
        if (leftChild < n && array[leftChild] > array[largest]) {
            largest = leftChild;
        }
        
        if (rightChild < n && array[rightChild] > array[largest]) {
            largest = rightChild;
        }
        
        if (largest != i) {
            int buffer = array[i];
            array[i] = array[largest];
            array[largest] = buffer;
            
            heapify(array, n, largest);
        }
    }
}