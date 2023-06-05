package Seminar4;

public class Program {
    public static void main(String[] args) {
        HashMapAnalog <Integer, String> map = new HashMapAnalog<>();
        System.out.println(map.put(1, "2"));
        System.out.println(map.put(2, "b"));
        System.out.println(map.put(3, "c"));
        System.out.println(map.put(4, "d"));
        System.out.println(map.put(17, "F+1"));
        System.out.println(map.put(18, "F+2"));
        System.out.println(map.put(33, "F+21"));
        System.out.println(map.put(1, "e"));
        System.out.println(map.put(2, null));
        System.out.println();

        // System.out.println(map.get(1));
        // System.out.println(map.get(106));
        // System.out.println(map.get(33));
        // System.out.println(map.get(2));
        // System.out.println();

        // System.out.println(map.remove(106));
        // System.out.println(map.remove(33));
        // System.out.println(map.remove(1));
        // System.out.println();

        // System.out.println(map.replays(1, "r"));
        // System.out.println(map.replays(33, "F+31"));
        // System.out.println();

        // System.out.println(map.size());
        // System.out.println();
    }
}
