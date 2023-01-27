/*Реализовать функцию возведения числа а в степень b. a, b ∈ Z. Сводя количество выполняемых действий к минимуму.  
Пример 1: а = 3, b = 2, ответ: 9  
Пример 2: а = 2, b = -2, ответ: 0.25 
Пример 3: а = 3, b = 0, ответ: 1 
Пример 4: а = 0, b = 0, ответ: не определено ? Насколько я понимаю в условии ошибка так как по математическим законам 0^0=1 
Пример 5 
входные данные находятся в файле input.txt в виде 
b 3 
a 10 
Результат нужно сохранить в файле output.txt 
1000*/ 
 
import java.io.BufferedReader; 
import java.io.File; 
import java.io.FileReader; 
import java.io.FileWriter;
 
 
public class Semminar2Homework { 
    public static void main(String[] args) { 
        int a = 0;
        String af = RetrievingElements("a", "input.txt");
        boolean at = IsInt(af);
        int b = 0;
        String bf = RetrievingElements("b", "input.txt");
        boolean bt = IsInt(bf);
        if(at == true && bt == true){
            a = Integer.parseInt(af);
            b = Integer.parseInt(bf);
            double example = Math.pow(a, b);
            String s = String.valueOf(example) + "\n"; 
            WriteResult(s, "output.txt");
        }
        else WriteResult("Невозможно выполнить\n", "output.txt");
    } 
     
 
    public static String RetrievingElements(String elem, String pathname){ 
        try { 
            File file = new File(pathname); 
            FileReader fr = new FileReader(file); 
            BufferedReader br = new BufferedReader (fr);
            String line;
            while ((line = br.readLine()) != null){
                String [] object = line.split(" ");
                if (elem.equals(object[0])){
                    br.close();
                    return object[1];
                }
            }
            br.close();
            return "Объект не найден";
        } 
        catch (Exception e) { 
            e.printStackTrace(); 
            return "Завершено с ошибкой";
        } 
    } 
 

    public static boolean IsInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public static void WriteResult(String example, String pathname) {
        try {
            FileWriter fw = new FileWriter(pathname, true);
            fw.write(example);
            fw.close();
       } catch(Exception ex){
            System.out.println(ex.getMessage());
       }
       
    }
}