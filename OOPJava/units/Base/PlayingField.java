package units.Base;

public class PlayingField extends SizeField{
    public void showField(){

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (j == field[i].length - 1) System.out.printf("%2d\n", field[i][j]);
                else System.out.printf("%2d ", field[i][j]);
            }
        }
        
    }
}
