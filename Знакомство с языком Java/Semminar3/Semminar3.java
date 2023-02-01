// Дана прямоугольная карта размера MxN (N, M меньше 20)
// На карте стоит фигура в точке(Х, Y), которая может ходить на одну клеточку вправо или вниз за один ход
// Посчитать количество маршрутов, которым фигура может попасть в нижнюю правую клетку
// * * На карте могут быть стены

import java.util.Arrays; 
import java.util.Random; 
 
public class Semminar3 {
    public static void main(String[] args) { 
        int [] field = FieldGeneration(false, false, 8);
        // int [] field = new int [] {8, 8};
        int [][] wall = WallGeneration( 3, field[0], field[1]); 
        // int [][] wall = new int [][] {{1, 1}, {2, 2}, {4, 1}};
        int [] point = field.length > 1 ? PointSetting(field[0], field[1]) : PointSetting(field[0], field[0]); 
        // int [] point = new int [] {1, 1};
        System.out.printf("%d %d\n", point[0], point[1]); 
        Way(field, point, wall); 
    } 
 
 
    public static int [] PointSetting(int a, int b) { 
        return new int [] {new Random().nextInt(1, a + 1), new Random().nextInt(1, b + 1),}; 
    } 
 
 
    // square - отвечает за то, должно ли быть поле квадратным 
    // stability - отвечает за то, чтобы поле было именно указанного размера и квадратным
    public static int[] FieldGeneration(boolean square, boolean stability, int max) { 
        if (stability) return new int [] {max, max}; 
        int border = new Random().nextInt(4, max + 1); 
        return square == true ? new int [] {border, border} : new int [] {border, new Random().nextInt(4, max + 1)}; 
    } 
 
    
    // Программа нарочно игнорирует если закрытая точка совпадает с точкой старта
    public static void Way(int[] field, int[] point, int[][] way) { 
        int [][] a = new int [field[0]][field[1]]; 
        a[point[0]-1][point[1]-1] = 1;
        int [] start = new int [] {point[0], point[1]};
        for (int j = point[1]-1; j < field[1]; j++){ 
            for (int i = point[0]-1; i < field[0]; i++){
                int [] block = new int[] {i+1, j+1};
                for(int k = 0; k < way.length; k++) {
                    if (Arrays.equals(block, way[k])) {
                        if (!Arrays.equals(block, start)) a[i][j] = -1;
                    }
                }
                if (i == start[0]-1 && j == start[1]-1);
                else if (a[i][j] == -1) a[i][j] = 0;
                else if (i-1 != -1 && j-1 != -1) a[i][j] = a[i-1][j] + a[i][j-1] + a[i][j]; 
                else if (i-1 == -1) a[i][j] = a[i][j-1] + a[i][j];
                else a[i][j] = a[i-1][j] + a[i][j];
            } 
        } 
        for(int i = 0; i < a.length; i++) System.out.println(Arrays.toString(a[i])); 
        System.out.println(a[field[0]-1][field[1]-1]); 
    } 
 

    public static int [][] WallGeneration(int size, int a, int b) { 
        int [][] result = new int[size][2];  
        for (int i = 0; i < result.length; i++){ 
            result[i][0] = new Random().nextInt(2, a); 
            result[i][1] = new Random().nextInt(2, b);
        } 
        System.out.println(Arrays.deepToString(result)); 
        return result; 
    } 
}
