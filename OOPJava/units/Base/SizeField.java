package units.Base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import units.Base.BaseHeroes.BaseHero;

public abstract class  SizeField {
    /**Горизонталь*/ private static int x = 10;
    /**Вертикаль*/ private static int y = 10; 
    protected static int [][] field = createField(x, y);

    public static int getHorizontal() {
        return x;
    }

    public static int getVertical() {
        return y;
    }

    public void setPoint(int id, int x, int y){
        try {
            if (field[x][y] == 0) field[x][y] = id;
            else throw new Exception("Ошибка: место занято");    
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static BaseHero filling(int x, int y, ArrayList<BaseHero> enemy) { 
        int[][]map = createField(getHorizontal(), getVertical());
        map[x][y] = 1;
        Queue<int[]> qu = new LinkedList<>(); 
        int [] start = new int [] {x, y}; 
        qu.add(start); 
        do{ 
            int [] elem = qu.remove();
            if (elem[0]-1 != -1 && map[elem[0]-1][elem[1]] == 0){ 
                qu.add(new int [] {elem[0]-1, elem[1]}); 
                map[elem[0]-1][elem[1]] = map[elem[0]][elem[1]] + 1;  
            } 
            if(elem[0]-1 != -1 && elem[1]+1 < map[0].length && map[elem[0]-1][elem[1]+1] == 0){
                qu.add(new int [] {elem[0]-1, elem[1]+1}); 
                map[elem[0]-1][elem[1]+1] = map[elem[0]][elem[1]] + 1;
            }
            if (elem[1]+1 < map[0].length && map[elem[0]][elem[1]+1] == 0){ 
                qu.add(new int [] {elem[0], elem[1]+1}); 
                map[elem[0]][elem[1]+1] = map[elem[0]][elem[1]] + 1; 
            }
            if(elem[0]+1 < map[0].length && elem[1]+1 < map[0].length && map[elem[0]+1][elem[1]+1] == 0){
                qu.add(new int [] {elem[0]+1, elem[1]+1}); 
                map[elem[0]+1][elem[1]+1] = map[elem[0]][elem[1]] + 1;
            }
            if (elem[0]+1 < map.length && map[elem[0]+1][elem[1]] == 0){ 
                qu.add(new int [] {elem[0]+1, elem[1]}); 
                map[elem[0]+1][elem[1]] = map[elem[0]][elem[1]] + 1;  
            }
            if(elem[0]+1 < map[0].length && elem[1]-1 != -1 && map[elem[0]+1][elem[1]+-1] == 0){
                qu.add(new int [] {elem[0]+1, elem[1]-1}); 
                map[elem[0]+1][elem[1]-1] = map[elem[0]][elem[1]] + 1;
            }
            if (elem[1]-1 != -1 && map[elem[0]][elem[1]-1] == 0){ 
                qu.add(new int [] {elem[0], elem[1]-1}); 
                map[elem[0]][elem[1]-1] = map[elem[0]][elem[1]] + 1;  
            } 
            if(elem[0]-1 != -1 && elem[1]-1 != -1 && map[elem[0]-1][elem[1]-1] == 0){
                qu.add(new int [] {elem[0]-1, elem[1]-1}); 
                map[elem[0]-1][elem[1]-1] = map[elem[0]][elem[1]] + 1;
            }
        }while(qu.size() > 0);
        return firstEnemy(map, enemy);
    }

    public static BaseHero firstEnemy(int[][] map, ArrayList<BaseHero> enemy) {
        int min = map[enemy.get(0).getX()][enemy.get(0).getY()];
        BaseHero opponent = enemy.get(0);
        boolean trueSearch = false;
        for (BaseHero elem : enemy) {
            if (!(elem.getMaxHP() < 1)) {
                opponent = elem;
                trueSearch = true;
            }
        }
        if(trueSearch){
            for (int i = 1; i < enemy.size(); i++) {
                int [] elem = new int []{enemy.get(i).getX(), enemy.get(i).getY()}; 
                if (map[elem[0]][elem[1]] < min ) {
                    min = map[elem[0]][elem[1]];
                    opponent = enemy.get(i);
                }
            }
        }
        else throw new NullPointerException("Игра окончена. Противники мертвы");
        return opponent;
    }

    private static int [][] createField(int x, int y) {
        int [][] result = new int [x+2] [y+2];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                if (i == 0 || j == 0 || i == result.length-1 || j == result[i].length-1) result[i][j] = -1;
            }
        }
        return result;
    }
}
