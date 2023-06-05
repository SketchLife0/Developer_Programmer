package Seminar4;

public class HashMapAnalog <K, V>{
    Node<K, V>[] nodes = new Node[16];

    /**
     * Добавить элемент
     * @param key - HashCode остаток от деления на 16
     * @param value - Значение элемента
     * @return boolean значение успеха функции
     */
    public boolean put(K key , V value) {
        Node<K, V> input = new Node<>(key, value);
        Integer hash16 = input.key.hashCode() % 16;
        if (nodes[hash16] != null) {
            Node<K, V> currentNode = nodes[hash16];
            while (currentNode != null) {
                if (currentNode.key == key) {
                    currentNode.value = value;
                    return true;
                }
                currentNode = currentNode.nextNode;
            }
            input.nextNode = nodes[hash16];
        }
        nodes[hash16] = input;
        return true;
    }

    /**
     * Получить значение соответствующее ключу
     * @param key - HashCode элемента для поиска
     * @return Значение найденного элемента
     */
    public V get(Integer key){
        Integer index = key.hashCode() % 16;
        Node<K, V> currentNode = nodes[index];
        while (currentNode != null) {
            if (currentNode.key == key) {
                return currentNode.value;
            }
            currentNode = currentNode.nextNode;
        }
        return null;
    }

    /**
     * Удалить элемент по ключу
     * @param key - HashCode элемента для удаления
     * @return boolean значение успеха функции
     */
    public boolean remove(Integer key){
        Integer index = key.hashCode() % 16;
        Node<K, V> currentNode = nodes[index];
        Node<K, V> previousNode = null;
        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                if (previousNode == null)
                    nodes[index] = currentNode.nextNode;
                else if (currentNode.nextNode == null)
                    previousNode.nextNode = null;
                else
                    previousNode.nextNode = currentNode.nextNode;
                return true;
            }
            previousNode = currentNode;
            currentNode = currentNode.nextNode;
        }
        return false;
    }

    /**
     * Замена значения по ключу
     * @param key - HashCode элемента для замены
     * @param v - Новое значение элемента
     * @return boolean значение успеха функции
     */
    public boolean replays(Integer key, V v) {
        Integer index = key.hashCode() % 16;
        Node<K, V> currentNode = nodes[index];
        while (currentNode != null) {
            if (currentNode.key == key) {
                currentNode.value = v;
                return true;
            }
            currentNode = currentNode.nextNode;
        }
        return false;
    }

    /**
     * Вывод количество элементов в функции
     * @return Integer размер массива
     */
    public int size(){
        int result = 0;
        for (int i = 0; i < 16; i++){
            Node<K, V> currentNode = nodes[i];
            while (currentNode != null){
                result ++;
                currentNode = currentNode.nextNode;
            }
        }
        return result;
    }

    /**
     * Проверка существования ключа
     * @param key - необходимый ключ для поиска
     * @return boolean значение успеха функции
     */
    public boolean containsKey(Integer key){
        Integer index = key.hashCode() % 16;
        Node<K, V> currentNode = nodes[index];
        while (currentNode != null) {
            if (currentNode.key == key) {
                return true;
            }
            currentNode = currentNode.nextNode;
        }
        return false;
    }

    /**
     * Проверка существования значения
     * @param v - необходимое значение для поиска
     * @return boolean значение успеха функции
     */
    public boolean containsValue(Integer v){
        for (int i = 0; i < 16; i++){
            Node<K, V> currentNode = nodes[i];
            if (currentNode != null && currentNode.value == v){
                return true;
            }
        }
        return false;
    }
}
