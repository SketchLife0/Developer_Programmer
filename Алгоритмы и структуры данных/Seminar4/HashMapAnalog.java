package Seminar4;

public class HashMapAnalog <K, V>{
    Node<K, V>[] nodes = new Node[16];

    /**
     * Добавить элемент
     * @param key - HashCode остаток от деления на 16
     * @param value - Значение элемента
     * @return boolean значение успеха функции
     */
    public static boolean put(Integer key , Integer value) {
        
        return
    }

    /**
     * Получить значение соответствующее ключу
     * @param key - HashCode элемента для поиска
     * @return Integer Значение найденного элемента
     */
    public static Integer get(Integer key){
        return 
    }

    /**
     * Удалить элемент по ключу
     * @param key - HashCode элемента для удаления
     * @return boolean значение успеха функции
     */
    public static boolean remove(Integer key){
        return 
    }

    /**
     * Замена значения по ключу
     * @param key - HashCode элемента для замены
     * @param v - Новое значение элемента
     * @return boolean значение успеха функции
     */
    public static boolean replays(Integer key, Integer v) {
        return
    }

    /**
     * Вывод количество элементов в функции
     * @return Integer размер массива
     */
    public static Integer size(){
        return
    }

    /**
     * Проверка существования ключа
     * @param key - необходимый ключ для поиска
     * @return boolean значение успеха функции
     */
    public static boolean containsKey(Integer key){
        return 
    }

    /**
     * Проверка существования значения
     * @param v - необходимое значение для поиска
     * @return boolean значение успеха функции
     */
    public static boolean containsValue(Integer v){
        return
    }
}
