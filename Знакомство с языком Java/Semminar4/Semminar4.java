package Semminar4;
import Semminar3.*; 
import java.util.Arrays; 
import java.util.LinkedList; 
import java.util.Queue;  

public class Semminar4 {
    public static void main(String[] args) {
        int [] field = Semminar3.FieldGeneration(false, true, 8); 
        int [][] wall = Semminar3.WallGeneration(10, field[0], field[1]);  
        int [] start = field.length > 1 ? Semminar3.PointSetting(field[0], field[1]) : Semminar3.PointSetting(field[0], field[0]); 
        int [][] finish = Semminar3.WallGeneration( 2, field[0], field[1]); 
        System.out.printf("%d %d\n", start[0], start[1]);  
        int [][] board = blocking(field, start, wall, finish); 
        exit(false, board, start);
        for(int i = 0; i < board.length; i++) System.out.println(Arrays.toString(board[i]));
        int shortCut = searchMin(board, finish);
        switch(shortCut){
            case -1:
                System.out.println("Финиш не определён");
                break;
            case 0:
                System.out.println("Выход закрыт стенами");
                break;
            case 1: 
                System.out.println("Точка начала является точкой конца");
                break;
            default: 
                System.out.printf("Самый короткий путь состоит из %d элементов\n", shortCut);
                int[] nearestFinish = firstFinish(board, finish);
                int [][] way = lightWay(board, nearestFinish, shortCut);
                System.out.println(Arrays.deepToString(way));
                break;
        }    
    } 
     
     
    public static int [][] blocking(int[] field, int[] point, int[][] wall, int[][] finish) { 
        int [][] a = new int [field[0]][field[1]]; 
        for (int i = 0; i < wall.length; i++) a[wall[i][0]-1][wall[i][1]-1] = -1; 
        for (int i = 0; i < finish.length; i++) a[finish[i][0]-1][finish[i][1]-1] = 0;
        return a; 
    } 


    public static int [] firstFinish(int[][] field, int[][]finish) {
        int [] elem = finish[0];
        int [] result = new int []{elem[0], elem[1]};
        int min = field[elem[0]-1][elem[1]-1];
        for (int i = 1; i < finish.length; i++) {
            elem = finish[i]; 
            if (field[elem[0]-1][elem[1]-1] < min) {
                min = field[elem[0]-1][elem[1]-1];
                result[0] = elem[0];
                result[1] = elem[1];
            }
        }
        return result;
    }


    public static int searchMin(int[][] field, int[][]finish) {
        if(finish.length == 0) return -1;
        int[] elem = finish[0]; 
        int min = field[elem[0]-1][elem[1]-1];
        for (int i = 1; i < finish.length; i++) {
            elem = finish[i]; 
            if (field[elem[0]-1][elem[1]-1] < min) min = field[elem[0]-1][elem[1]-1];
        }
        return min;
    }
 
 
    public static void exit(boolean diagonal, int[][] field, int[] point) { 
        field[point[0]-1][point[1]-1] = 1; 
        Queue<int[]> qu = new LinkedList<>(); 
        int [] start = new int [] {point[0]-1, point[1]-1}; 
        qu.add(start); 
        do{ 
            int [] elem = qu.remove();
            if (elem[0]-1 != -1 && field[elem[0]-1][elem[1]] == 0){ 
                qu.add(new int [] {elem[0]-1, elem[1]}); 
                field[elem[0]-1][elem[1]] = field[elem[0]][elem[1]] + 1;  
            } 
            if (elem[1]+1 < field[0].length && field[elem[0]][elem[1]+1] == 0){ 
                qu.add(new int [] {elem[0], elem[1]+1}); 
                field[elem[0]][elem[1]+1] = field[elem[0]][elem[1]] + 1; 
            }
            if (elem[0]+1 < field.length && field[elem[0]+1][elem[1]] == 0){ 
                qu.add(new int [] {elem[0]+1, elem[1]}); 
                field[elem[0]+1][elem[1]] = field[elem[0]][elem[1]] + 1;  
            } 
            if (elem[1]-1 != -1 && field[elem[0]][elem[1]-1] == 0){ 
                qu.add(new int [] {elem[0], elem[1]-1}); 
                field[elem[0]][elem[1]-1] = field[elem[0]][elem[1]] + 1;  
            } 
        }while(qu.size() > 0);  
    }


    public static int[][] lightWay(int[][] field, int [] finish, int size) {
        int[][] result = new int[size][2];
        result[0][0] = finish[0];
        finish[0]--;
        result[0][1] = finish[1];
        finish[1]--;
        for(int i = 1; i < size; i++) {
            if(finish[0]-1 != -1 && field[finish[0]-1][finish[1]] != -1 && field[finish[0]-1][finish[1]] < field[finish[0]][finish[1]]){
                result[i][0] = finish[0];
                result[i][1] = finish[1]+1;
                finish = new int []{finish[0]-1, finish[1]};
            }
            else if(finish[1] + 1 < field.length && field[finish[0]][finish[1]+1] != -1 && field[finish[0]][finish[1]+1] < field[finish[0]][finish[1]]){
                result[i][0] = finish[0]+1;
                result[i][1] = finish[1]+2;
                finish = new int []{finish[0], finish[1]+1};
            }
            else if(finish[0] + 1 < field.length && field[finish[0]+1][finish[1]] != -1 && field[finish[0]+1][finish[1]] < field[finish[0]][finish[1]]){
                result[i][0] = finish[0]+2;
                result[i][1] = finish[1]+1;
                finish = new int []{finish[0]+1, finish[1]};
            }
            else {
                result[i][0] = finish[0]+1;
                result[i][1] = finish[1];
                finish = new int []{finish[0], finish[1]-1};
            }
        }
        return result;
    }
}
