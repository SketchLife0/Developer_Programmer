import java.util.Scanner;;
public class program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.printf("Введите треугольное число: ");
        int num = scan.nextInt();
        num  = (num * ++num)/2;
        System.out.printf("Ответ %d", num);
        scan.close();
    }
}