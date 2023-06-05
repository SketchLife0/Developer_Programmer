package Seminar4;

public class Node <K, V>{
    K key;
    V value;
    Node<K, V> nextNode;
    Node<K, V> previousNode;
    
    public void Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
