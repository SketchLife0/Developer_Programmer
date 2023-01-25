import java.util.Scanner;;
public class program {
    public static void main(String[] args) {
        int num = inputNum();
        int result  = formula(num);
        System.out.printf("Ответ %d", result);
        
    }

    public static int inputNum(){
        Scanner scan = new Scanner(System.in);
        System.out.printf("Введите треугольное число: ");
        return scan.nextInt();
    }

    public static int formula(int x){
        return (x * ++x)/2;
    }
}